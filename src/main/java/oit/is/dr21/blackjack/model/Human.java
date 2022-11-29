package oit.is.dr21.blackjack.model;

import java.util.ArrayList;

public abstract class Human {
  ArrayList<Integer> cards = new ArrayList<>();

  public Human() {
    drawCard();
    drawCard();
  }

  public Integer calcSum() {
    Integer sum = 0;
    for (int i = 0; i < this.cards.size(); i++) {
      if (cards.get(i) > 10) {
        sum += 10;
      } else {
        sum += cards.get(i);
      }
    }
    return sum;
  }

  public void drawCard() {
    cards.add((int) (Math.random() * 13) + 1);
  }

  public void setCards(ArrayList<Integer> cards) {
    this.cards = cards;
  }

  public ArrayList<Integer> getCards() {
    return cards;
  }

}
