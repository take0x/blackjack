package oit.is.dr21.blackjack.model;

import org.springframework.stereotype.Component;

@Component
public class Player extends Human {
  String result;

  public Player() {
    super();
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  



}
