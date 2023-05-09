package hello.proxy.app.v1;

import hello.common.util.ThreadUtils;

public class OrderRepositoryV1Impl implements OrderRepositoryV1 {

    @Override
    public void save(String itemId) {
        // 저장 로직
        if ("ex".equals(itemId)) {
            throw new IllegalStateException("예외 발생!");
        }
        ThreadUtils.sleep(1000);
    }

}
