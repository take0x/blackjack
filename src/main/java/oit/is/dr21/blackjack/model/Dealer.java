package oit.is.dr21.blackjack.model;

import org.springframework.stereotype.Component;

@Component
public class Dealer extends Human {
  public Dealer() {
    super();
  }

  public void drawCards() {
    while (super.calcSum() < 17) {
      super.drawCard();
    }
  }

  public void judge(Player player) {
    String result = "";
    int ds = super.calcSum();
    int ps = player.calcSum();
    if (ps > 21) {
      result = "Burst";
    } else if (ps > ds || ds > 21) {
      result = "Win";
    } else if (ps == ds) {
      result = "Draw";
    } else {
      result = "Lose";
    }
    player.setResult(result);
  }

}
