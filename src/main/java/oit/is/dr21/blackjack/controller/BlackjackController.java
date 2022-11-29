package oit.is.dr21.blackjack.controller;

// import java.security.Principal;
// import java.util.ArrayList;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
// import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.dr21.blackjack.model.Dealer;
import oit.is.dr21.blackjack.model.Player;

@Controller
@RequestMapping("/blackjack")
public class BlackjackController {

  Player player;
  Dealer dealer;

  @GetMapping("/home")
  public String home() {
    return "home.html";
  }

  @GetMapping("/game")
  public String game() {
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
  public String gameplay(@RequestParam String action, ModelMap model) {
    if (action.equals("hit")) {
      this.player.drawCard();
    } else if (action.equals("stand")) {
      this.player.setIsStand(true);
    }
    model.addAttribute("Player", this.player);
    model.addAttribute("Dealer", this.dealer);
    return "game.html";
  }
}
