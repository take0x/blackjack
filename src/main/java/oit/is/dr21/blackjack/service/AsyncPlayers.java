package oit.is.dr21.blackjack.service;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import oit.is.dr21.blackjack.model.Room;

@Service
public class AsyncPlayers {

  private final Logger logger = LoggerFactory.getLogger(AsyncPlayers.class);

  @Async
  public void asyncShowPlayersList(SseEmitter emitter, Room room) {
    try {
      while (true) {// 無限ループ
        // DBが更新されていなければ0.5s休み
        if (!room.getUpdated()) {
          TimeUnit.MILLISECONDS.sleep(500);
          continue;
        }
        emitter.send(room.getPlayers());
        TimeUnit.MILLISECONDS.sleep(1000);
        room.setUpdated(false);
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
