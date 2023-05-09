package hello.advanced.trace.threadlocal;

import hello.advanced.trace.threadlocal.code.FieldService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static hello.common.util.ThreadUtils.*;

@Slf4j
public class FieldServiceTest {

    private FieldService fieldService = new FieldService();

    @Test
    @DisplayName("동시성 문제 발생X")
    void fieldSuccess() {
        log.info("main start");
        Runnable userA = () -> {
            fieldService.logic("userA");
        };

        Runnable userB = () -> {
            fieldService.logic("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("ThreadA");
        Thread threadB = new Thread(userB);
        threadB.setName("ThreadB");

        threadA.start();
        sleep(2000); // 동시성 문제 발생 X
        threadB.start();
        sleep(3000); // 메인 쓰레드 종료 대기
        log.info("main exit");
    }

    @Test
    @DisplayName("동시성 문제 발생")
    void fieldError() {
        log.info("main start");
        Runnable userA = () -> {
            fieldService.logic("userA");
        };

        Runnable userB = () -> {
            fieldService.logic("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("ThreadA");
        Thread threadB = new Thread(userB);
        threadB.setName("ThreadB");

        threadA.start();
        sleep(100); // 동시성 문제 발생 O
        threadB.start();
        sleep(3000); // 메인 쓰레드 종료 대기
        log.info("main exit");
    }
}
