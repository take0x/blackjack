package oit.is.dr21.blackjack.model;

import java.util.Random;

public class Card {
  private String number;
  private int value;

  /*
   * 引数無しのコンストラクタ
   * 数字をランダムで指定される
   */
  public Card() {
    Random random = new Random();
    initCard(random.nextInt(13) + 1);
  }

  /*
   * 数字指定のコンストラクタ
   *
   * @param num カードの数字
   */
  public Card(int num) {
    initCard(num);
  }

  /*
   * カードの表示と価値を数字から指定
   * 
   * @param num カードの数字
   */
  private void initCard(int num) {
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

  @Override
  public String toString() {
    return this.number;
  }
}
