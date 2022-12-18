package oit.is.dr21.blackjack.model;

import org.springframework.stereotype.Component;

@Component
public class Player extends Human {
  String result = "";
  String name;

  public Player() {
    super();
  }

  public Player(String name) {
    super();
    this.name = name;
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
