package oit.is.dr21.blackjack.service;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import oit.is.dr21.blackjack.model.Room;

@Service
public class AsyncRoom {
  private final Logger logger = LoggerFactory.getLogger(AsyncPlayers.class);
  private Boolean preEnableEntry = true;

  @Async
  public void asyncEnableEntry(SseEmitter emitter, Room room) {
    try {
      while (true) {// 無限ループ
        // DBが更新されていなければ0.5s休み
        if (room.getEnableEntry() == preEnableEntry) {
          TimeUnit.MILLISECONDS.sleep(500);
          continue;
        }
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(room);
        emitter.send(rooms);
        TimeUnit.MILLISECONDS.sleep(1000);
        preEnableEntry = room.getEnableEntry();
      }
    } catch (Exception e) {
      // 例外の名前とメッセージだけ表示する
      logger.warn("Exception:" + e.getClass().getName() + ":" + e.getMessage());
    } finally {
      emitter.complete();
    }
    System.out.println("asyncShowPlayersList complete");
  }
}
