package oit.is.dr21.blackjack.model;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class Room {
  int roomId = 21;
  Dealer dealer = new Dealer();
  ArrayList<Player> players = new ArrayList<>();

  public void addPlayer(Player player) {
    for (Player p : this.players) {
      if ((p.getName()).equals(player.getName())) {
        return;
      }
    }
    players.add(player);
  }

  public int getRoomId() {
    return roomId;
  }

  public void setRoomId(int roomId) {
    this.roomId = roomId;
  }

  public Dealer getDealer() {
    return dealer;
  }

  public void setDealer(Dealer dealer) {
    this.dealer = dealer;
  }

  public ArrayList<Player> getPlayers() {
    return players;
  }

  public void setPlayers(ArrayList<Player> players) {
    this.players = players;
  }

}
