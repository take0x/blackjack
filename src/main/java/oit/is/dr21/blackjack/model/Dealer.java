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
}
