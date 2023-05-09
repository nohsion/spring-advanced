package hello.advanced.app.v2;

import hello.common.trace.TraceId;
import hello.common.trace.TraceStatus;
import hello.common.trace.hellotrace.HelloTraceV2;
import hello.common.util.AdvancedConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV2 {

    private final HelloTraceV2 trace;

    private static final String EXCEPTION_ITEM = "ex";

    public void save(TraceId traceId, String itemId) {

        TraceStatus status = null;
        try {
            status = trace.beginSync(traceId, "OrderRepository.save()");
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
