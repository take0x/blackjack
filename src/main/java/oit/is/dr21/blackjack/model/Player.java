package oit.is.dr21.blackjack.model;

import org.springframework.stereotype.Component;

@Component
public class Player extends Human {
  String result = "";
  String name;
  int coin;
  int bet;

  public Player() {
    super();
  }

  public Player(String name) {
    super();
    this.name = name;
  }

  public int betCoin(int bet) {
    this.coin -= bet;
    this.bet = bet;
    return this.coin;
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

  public int getCoin() {
    return coin;
  }

  public void setCoin(int coin) {
    this.coin = coin;
  }

  public int getBet() {
    return bet;
  }

  public void setBet(int bet) {
    this.bet = bet;
  }

}
