package oit.is.dr21.blackjack.controller;

import java.security.Principal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import oit.is.dr21.blackjack.model.Dealer;
import oit.is.dr21.blackjack.model.Mining;
import oit.is.dr21.blackjack.model.Player;
import oit.is.dr21.blackjack.model.Room;
import oit.is.dr21.blackjack.model.UserDataMapper;
import oit.is.dr21.blackjack.service.AsyncPlayers;
import oit.is.dr21.blackjack.service.AsyncRoom;

@Controller
@RequestMapping("/blackjack")
public class BlackjackController {

  Player player;
  Dealer dealer;
  Mining miningMachine;

  @Autowired
  Room room;

  @Autowired
  AsyncRoom asyncRoom;

  @Autowired
  AsyncPlayers reception;

  @Autowired
  UserDataMapper udMapper;

  @GetMapping("/home")
  public String home(ModelMap model) {
    model.addAttribute("room", this.room);
    return "home.html";
  }

  @GetMapping("/controluser")
  public String controluser(ModelMap model) {
    ArrayList<Player> players = udMapper.selectAllUser();
    model.addAttribute("resetcoin", false);
    model.addAttribute("resetroom", false);
    model.addAttribute("players", players);
    return "control.html";
  }

  @GetMapping("/resetcoin")
  public String resetcoin(ModelMap model) {
    udMapper.resetCoinAllUser();
    ArrayList<Player> players = udMapper.selectAllUser();
    model.addAttribute("resetcoin", true);
    model.addAttribute("resetroom", false);
    model.addAttribute("players", players);
    return "control.html";
  }

  @GetMapping("/kickplayers")
  public String kickplayers(ModelMap model) {
    ArrayList<Player> players = udMapper.selectAllUser();
    this.room.removeAllPlayers();
    model.addAttribute("resetcoin", false);
    model.addAttribute("resetroom", true);
    model.addAttribute("players", players);
    return "control.html";
  }

  @GetMapping("/lobby")
  public String lobby(Principal prin, ModelMap model) {
    Player p = new Player(prin.getName());
    p.setCoin(udMapper.selectCoinByName(p.getName()));
    this.room.addPlayer(p);
    model.addAttribute("coin", p.getCoin());
    model.addAttribute("room", this.room);
    return "lobby.html";
  }

  @GetMapping("/miningroom")
  public String miningroom(Principal prin, ModelMap model) {
    miningMachine = new Mining();
    Player p = udMapper.selectPlayerByName(prin.getName());
    model.addAttribute("coin", p.getCoin());
    return "miningroom.html";
  }

  @GetMapping("/mining")
  public String mining(Principal prin, ModelMap model) {
    int minedCoin = 0;
    minedCoin = miningMachine.miningCoin();
    Player p = udMapper.selectPlayerByName(prin.getName());
    p.setCoin(p.getCoin() + minedCoin);
    udMapper.updateCoinByName(p.getName(), p.getCoin());
    model.addAttribute("coin", p.getCoin());
    return "miningroom.html";
  }

  @PostMapping("/gamestart")
  @Transactional
  public String gameStart(Principal prin, ModelMap model, @RequestParam int bet) {
    if (!this.room.getDealerUpdated()) {
      this.room.setDealer(new Dealer());
      this.room.setDealerUpdated(true);
    }
    Player player = room.getPlayerByName(prin.getName());
    bet = this.room.checkBet(bet);
    int coin = player.betCoin(bet);
    udMapper.updateCoinByName(player.getName(), coin);
    player.drawFirst();
    model.addAttribute("coin", bet);
    model.addAttribute("room", this.room);
    if (player.getSum() >= 21) {
      model.addAttribute("burst", true);
    }
    this.room.setEnableEntry(false);
    this.room.setUpdated(true);
    return "game.html";
  }

  @GetMapping("/gameplay")
  public String gamePlay(Principal prin, @RequestParam String action, ModelMap model) {
    Player player = room.getPlayerByName(prin.getName());
    // Dealer dealer = room.getDealer();

    if (action.equals("hit")) {
      player.drawCard();
      if (player.getSum() >= 21) {
        model.addAttribute("burst", true);
      }
      room.setUpdated(true);
    } else if (action.equals("stand")) {
      player.setIsStand(true);
      // dealer.drawCards();
      // dealer.setIsStand(true);
      model.addAttribute("room", this.room);
      return "result.html";
    }
    model.addAttribute("room", this.room);

    return "game.html";
  }

  @GetMapping("/gameresult")
  @Transactional
  public String gameResult(Principal prin, ModelMap model) {
    Player player = room.getPlayerByName(prin.getName());
    player.setIsStand(true);
    if (this.room.checkAllStanded()) {
      model.addAttribute("return", true);
      if (!this.room.getEnableEntry()) {
        this.room.judgePlayers();
        for (Player p : this.room.getPlayers()) {
          udMapper.updateCoinByName(p.getName(), p.getCoin());
        }
        this.room.setEnableEntry(true);
        this.room.setUpdated(true);
        this.room.setDealerUpdated(false);
      }
    }
    model.addAttribute("room", this.room);
    return "result.html";
  }

  @GetMapping("/returnlobby")
  public String returnlobby(Principal prin, ModelMap model) {
    this.room.removePlayer(prin.getName());
    Player p = new Player(prin.getName());
    p.setCoin(udMapper.selectCoinByName(p.getName()));
    this.room.addPlayer(p);
    model.addAttribute("coin", p.getCoin());
    model.addAttribute("room", this.room);
    return "lobby.html";
  }

  @GetMapping("/returnhome")
  public String returnhome(Principal prin, ModelMap model) {
    this.room.removePlayer(prin.getName());
    model.addAttribute("room", this.room);
    return "home.html";
  }

  @GetMapping("/monitorRoom")
  public SseEmitter monitorRoom() {
    final SseEmitter sseEmitter = new SseEmitter();
    this.asyncRoom.asyncEnableEntry(sseEmitter, room);
    return sseEmitter;
  }

  @GetMapping("/monitorPlayers")
  public SseEmitter monitorPlayers() {
    final SseEmitter sseEmitter = new SseEmitter();
    this.reception.asyncShowPlayersList(sseEmitter, room);
    return sseEmitter;
  }
}
