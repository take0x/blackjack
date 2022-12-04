package oit.is.dr21.blackjack.model;

import java.util.ArrayList;

public abstract class Human {
  ArrayList<Integer> cards = new ArrayList<>();
  boolean isStand = false;
  int sum = 0;

  public Human() {
    drawCard();
    drawCard();
  }

  public void drawCard() {
    int card = (int) (Math.random() * 13) + 1;
    this.sum += card > 10 ? 10 : card;
    cards.add(card);
  }

  public void setCards(ArrayList<Integer> cards) {
    this.cards = cards;
  }

  public ArrayList<Integer> getCards() {
    return cards;
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
