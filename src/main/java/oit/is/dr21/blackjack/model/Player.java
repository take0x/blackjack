package oit.is.dr21.blackjack.model;

import org.springframework.stereotype.Component;

@Component
public class Player extends Human {
  boolean isStand = false;

  public Player() {
    super();
  }

  public boolean getIsStand() {
    return isStand;
  }

  public void setIsStand(boolean isStand) {
    this.isStand = isStand;
  }

}
