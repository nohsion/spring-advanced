package hello.advanced.app.v4;

import hello.common.trace.logtrace.LogTrace;
import hello.common.trace.template.AbstractTemplate;
import hello.common.util.AdvancedConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static hello.common.util.ThreadUtils.*;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV4 {

    private final LogTrace trace;

    private static final String EXCEPTION_ITEM = "ex";

    public void save(String itemId) {

        AbstractTemplate<Void> template = new AbstractTemplate<>(trace) {
            @Override
            protected Void call() {
                // 저장 로직
                if (itemId.equals(EXCEPTION_ITEM)) {
                    throw new IllegalStateException(AdvancedConstant.EXCEPTION_MESSAGE);
                }
                sleep(1000);
                return null;
            }
        };
        template.execute("OrderRepository.save()");
    }
}
