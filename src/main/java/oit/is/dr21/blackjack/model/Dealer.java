package oit.is.dr21.blackjack.model;

import org.springframework.stereotype.Component;

@Component
public class Dealer extends Human {
  public Dealer() {
    super.drawCard();
  }

  public void drawCards() {
    while (super.getSum() < 17) {
      super.drawCard();
    }
  }

  public void judge(Player player) {
    String result = "";
    int dealerSum = super.getSum();
    int playerSum = player.getSum();

    if (player.isBlackjack() && !super.isBlackjack()) {
      result = "Blackjack!";
      player.setCoin(player.getCoin() + (int) (player.getBet() * 2.5));
    } else if (playerSum > 21) {
      result = "Burst";
    } else if (playerSum > dealerSum || dealerSum > 21) {
      result = "Win";
      player.setCoin(player.getCoin() + player.getBet() * 2);
    } else if (playerSum == dealerSum) {
      result = "Draw";
      player.setCoin(player.getCoin() + player.getBet());
    } else {
      result = "Lose";
    }
    player.setResult(result);
  }

}
