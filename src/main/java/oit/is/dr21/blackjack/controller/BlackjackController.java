package oit.is.dr21.blackjack.controller;

import java.security.Principal;
// import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
// import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.dr21.blackjack.model.Dealer;
import oit.is.dr21.blackjack.model.Player;
import oit.is.dr21.blackjack.model.Room;
import oit.is.dr21.blackjack.service.AsyncPlayers;
import oit.is.dr21.blackjack.service.AsyncRoom;

@Controller
@RequestMapping("/blackjack")
public class BlackjackController {

  Player player;
  Dealer dealer;

  @Autowired
  Room room;

  @Autowired
  AsyncRoom asyncRoom;

  @Autowired
  AsyncPlayers reception;

  @GetMapping("/home")
  public String home(ModelMap model) {
    model.addAttribute("room", this.room);
    return "home.html";
  }

  @GetMapping("/game")
  public String game(Principal prin, ModelMap model) {
    boolean Start = true;
    Player p = new Player(prin.getName());
    this.room.addPlayer(p);
    this.room.setEnableEntry(false);
    model.addAttribute("Start", Start);
    model.addAttribute("room", this.room);

    return "game.html";
  }

  @GetMapping("/gamestart")
  public String gameStart(ModelMap model) {
    this.player = new Player();
    this.dealer = new Dealer();
    model.addAttribute("Player", this.player);
    model.addAttribute("Dealer", this.dealer);
    return "game.html";
  }

  @GetMapping("/gameplay")
  public String gamePlay(@RequestParam String action, ModelMap model) {
    if (action.equals("hit")) {
      this.player.drawCard();
    } else if (action.equals("stand")) {
      this.player.setIsStand(true);
      this.dealer.drawCards();
      this.dealer.setIsStand(true);
    }
    model.addAttribute("Player", this.player);
    model.addAttribute("Dealer", this.dealer);
    return "game.html";
  }

  @GetMapping("/gameresult")
  public String gameResult(ModelMap model) {
    this.dealer.judge(this.player);
    model.addAttribute("Player", this.player);
    model.addAttribute("Dealer", this.dealer);
    return "result.html";
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
