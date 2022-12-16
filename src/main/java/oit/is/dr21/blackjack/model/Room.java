package oit.is.dr21.blackjack.model;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class Room {
  int roomId = 21;
  Dealer dealer = new Dealer();
  ArrayList<Player> players = new ArrayList<>();
  Boolean updated = false;
  Boolean enableEntry = true;

  public void addPlayer(Player player) {
    for (Player p : this.players) {
      if ((p.getName()).equals(player.getName())) {
        return;
      }
    }
    players.add(player);
    judgeLimit();
    this.updated = true;
  }

  public Player getPlayerByName(String name) {
    for (Player p : this.players) {
      if ((p.getName()).equals(name)) {
        return p;
      }
    }
    return null;
  }

  public void judgeLimit() {
    if (players.size() >= 4) {
      this.enableEntry = false;
    } else {
      this.enableEntry = true;
    }
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

  public Boolean getUpdated() {
    return updated;
  }

  public void setUpdated(Boolean updated) {
    this.updated = updated;
  }

  public Boolean getEnableEntry() {
    return enableEntry;
  }

  public void setEnableEntry(Boolean enableEntry) {
    this.enableEntry = enableEntry;
  }

}
