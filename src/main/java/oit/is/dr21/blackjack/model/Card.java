package oit.is.dr21.blackjack.model;

import java.util.Random;

public class Card {
  private String number;
  private int value;
  private String display;

  private String suite;
  final String SPADE = "♠";
  final String CLUB = "♣";
  final String DIA = "♦";
  final String HEART = "♥";

  /**
   * 引数無しのコンストラクタ
   * 数字をランダムで指定される
   */
  public Card() {
    Random random = new Random();
    initNumber(random.nextInt(13) + 1);
    initSuite(random.nextInt(4));
  }

  /**
   * 数字指定のコンストラクタ
   *
   * @param num カードの数字
   */
  public Card(int num) {
    Random random = new Random();
    initNumber(num);
    initSuite(random.nextInt(4));
  }

  /**
   * 数字とスート指定のコンストラクタ
   *
   * @param num   カードの数字
   * @param suite スートを数字で指定
   *              (0:スペード, 1:クラブ, 2:ダイア, 3:ハート, それ以外:4の剰余)
   */
  public Card(int num, int suite) {
    initNumber(num);
    initSuite(suite);
  }

  /**
   * カードの表示と価値を数字から指定
   *
   * @param num カードの数字
   */
  private void initNumber(int num) {
    switch (num) {
      case 1:
        this.number = "A";
        this.value = 1;
        break;
      case 11:
        this.number = "J";
        this.value = 10;
        break;
      case 12:
        this.number = "Q";
        this.value = 10;
        break;
      case 13:
        this.number = "K";
        this.value = 10;
        break;
      default:
        this.number = "" + num;
        this.value = num;
        break;
    }
    this.display = this.suite + this.number;
  }

  /**
   * カードのスートを数字で指定
   *
   * @param suite スートを数字で指定
   *              (0:スペード, 1:クラブ, 2:ダイア, 3:ハート, それ以外:4の剰余)
   */
  private void initSuite(int suite) {
    switch (suite % 4) {
      case 0:
        this.suite = SPADE;
        break;
      case 1:
        this.suite = CLUB;
        break;
      case 2:
        this.suite = DIA;
        break;
      case 3:
        this.suite = HEART;
        break;
    }
    this.display = this.suite + this.number;
  }

  public String getSuite() {
    return suite;
  }

  public void setSuite(String suite) {
    this.suite = suite;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public String getDisplay() {
    return display;
  }

  public void setDisplay(String display) {
    this.display = display;
  }

  @Override
  public String toString() {
    return this.suite + this.number;
  }
}
