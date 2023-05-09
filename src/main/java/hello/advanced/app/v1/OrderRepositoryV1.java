package hello.advanced.app.v1;

import hello.common.trace.TraceStatus;
import hello.common.trace.hellotrace.HelloTraceV1;
import hello.common.util.ThreadUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV1 {

    private final HelloTraceV1 trace;

    private static final String EXCEPTION_ITEM = "ex";

    public void save(String itemId) {

        TraceStatus status = null;
        try {
            status = trace.begin("OrderRepository.save()");
            // 저장 로직
            if (itemId.equals(EXCEPTION_ITEM)) {
                throw new IllegalStateException("예외 발생");
            }
            ThreadUtils.sleep(1000);

            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }

    }

}
