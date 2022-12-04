package oit.is.dr21.blackjack.model;

import java.util.ArrayList;

public abstract class Human {
  ArrayList<Card> cards = new ArrayList<>();
  boolean isStand = false;
  int sum = 0;

  public Human() {
    drawCard();
    drawCard();
  }

  public void calcSum() {
    Integer sum = 0;
    for (Card card : this.cards) {
      sum += card.getValue();
    }
    this.sum = sum;
  }

  public void drawCard() {
    cards.add(new Card());
    this.calcSum();
  }

  public ArrayList<Card> getCards() {
    return cards;
  }

  public void setCards(ArrayList<Card> cards) {
    this.cards = cards;
  }

  public boolean getIsStand() {
    return isStand;
  }

  public void setIsStand(boolean isStand) {
    this.isStand = isStand;
  }

  public int getSum() {
    return sum;
  }

  public void setSum(int sum) {
    this.sum = sum;
  }
}
