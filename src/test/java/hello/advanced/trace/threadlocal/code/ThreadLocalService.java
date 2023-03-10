package hello.advanced.trace.threadlocal.code;

import lombok.extern.slf4j.Slf4j;

import static hello.advanced.util.ThreadUtils.*;

@Slf4j
public class ThreadLocalService {

    private ThreadLocal<String> nameStore = new ThreadLocal<>();

    public String logic(String name) {
        log.info("์ ์ฅ name={} -> nameStore={}", name, nameStore.get());
        nameStore.set(name);
        sleep(1000);
        log.info("์กฐํ nameStore={}", nameStore.get());

        return nameStore.get();
    }
}
