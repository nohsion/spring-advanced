package hello.advanced.app.v3;

import hello.common.trace.TraceStatus;
import hello.common.trace.logtrace.LogTrace;
import hello.common.util.AdvancedConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV3 {

    private final LogTrace trace;

    private static final String EXCEPTION_ITEM = "ex";

    public void save(String itemId) {

        TraceStatus status = null;
        try {
            status = trace.begin("OrderRepository.save()");
            // 저장 로직
            if (itemId.equals(EXCEPTION_ITEM)) {
                throw new IllegalStateException(AdvancedConstant.EXCEPTION_MESSAGE);
            }
            sleep(1000);

            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }

    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
