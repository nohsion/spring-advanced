package hello.advanced.trace.threadlocal;

import hello.advanced.trace.threadlocal.code.ThreadLocalService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static hello.common.util.ThreadUtils.sleep;

@Slf4j
public class ThreadLocalServiceTest {

    private ThreadLocalService service = new ThreadLocalService();

    @Test
    @DisplayName("쓰레드로컬 - 동시성 문제 발생X")
    void threadLocal() {
        log.info("main start");
        Runnable userA = () -> {
            service.logic("userA");
        };

        Runnable userB = () -> {
            service.logic("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("ThreadA");
        Thread threadB = new Thread(userB);
        threadB.setName("ThreadB");

        threadA.start();
        sleep(100);
        threadB.start();
        sleep(2000); // 메인 쓰레드 종료 대기
        log.info("main exit");
    }
}
