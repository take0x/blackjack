package oit.is.dr21.blackjack.model;

import java.util.ArrayList;

public abstract class Human {
  ArrayList<Card> cards = new ArrayList<>();
  boolean isStand = false;
  int sum = 0;

  public Human() {
  }

  public void calcSum() {
    Integer sum = 0;
    for (Card card : this.cards) {
      sum += card.getValue();
    }
    this.sum = sum;
    if (this.sum > 21) {
      changeAce();
    }
  }

  public void drawCard() {
    cards.add(new Card());
    this.calcSum();
  }

  private void changeAce() {
    boolean isChange = false;
    for (Card card : this.cards) {
      isChange = card.changeAceValue();
      if (isChange) {
        calcSum();
        break;
      }
    }
  }

  public Boolean isBlackjack() {
    return this.cards.size() == 2 && this.sum == 21;
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
