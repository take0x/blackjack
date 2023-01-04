package oit.is.dr21.blackjack.model;

import org.springframework.stereotype.Component;

@Component
public class Mining {

  public int miningCoin() {

    int p = (int) (Math.random() * 10000);
    if (p == 0) {// 1/10,000の確率で10,000コイン 確率の合計：1/10,000
      return 10000;
    } else if (1 <= p && p <= 10) { // 10/10,000の確率で1,000コイン 確率の合計：11/10,000
      return 1000;
    } else if (11 <= p && p <= 110) { // 100/10,000の確率で100コイン 確率の合計：111/10,000
      return 100;
    } else if (111 <= p && p <= 1110) { // 1,000/10,000の確率で10コイン 確率の合計：1,111/10,000
      return 10;
    } else if (1111 <= p && p <= 5000) {// 3,889/10,000の確率で1コイン 確率の合計：5,000/10,000
      return 1;
    } else {// 5,000/10,000の確率で0コイン 確率の合計：10,000/10,000
      return 0;
    }
  }
}
