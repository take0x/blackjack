package oit.is.dr21.blackjack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlackjackRuleController {
  @GetMapping("/rule")
  public String rule() {
    return "blackjackRule.html";
  }

  @GetMapping("/top")
  public String top() {
    return "index";
  }
}
