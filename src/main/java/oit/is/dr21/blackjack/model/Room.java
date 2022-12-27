package oit.is.dr21.blackjack.model;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class Room {
  int roomId = 21;
  Dealer dealer;
  ArrayList<Player> players = new ArrayList<>();
  Boolean updated = false;
  Boolean enableEntry = true;
  Boolean dealerUpdated = false;

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

  public void removePlayer(String name) {
    int removeIndex = -1;
    if (players.size() != 0) {
      for (Player p : this.players) {
        if ((p.getName()).equals(name)) {
          removeIndex = players.indexOf(p);
        }
      }
      if (removeIndex > -1) {
        players.remove(removeIndex);
        this.updated = true;
      }
    }
  }

  public Player getPlayerByName(String name) {
    if (players.size() != 0) {
      for (Player p : this.players) {
        if ((p.getName()).equals(name)) {
          return p;
        }
      }
    }
    return null;
  }

  public int checkBet(int bet) {
    if (bet <= 0) {
      return 0;
    }
    return bet;
  }

  public void judgeLimit() {
    if (players.size() >= 4) {
      this.enableEntry = false;
    } else {
      this.enableEntry = true;
    }
  }

  public Boolean checkAllStanded() {
    if (players.size() != 0) {
      for (Player p : this.players) {
        if (!p.isStand) {
          return false;
        }
      }
    }
    return true;
  }

  public void judgePlayers() {
    this.dealer.drawCards();
    for (Player p : this.players) {
      this.dealer.judge(p);
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

  public Boolean getDealerUpdated() {
    return dealerUpdated;
  }

  public void setDealerUpdated(Boolean dealerUpdated) {
    this.dealerUpdated = dealerUpdated;
  }

}
