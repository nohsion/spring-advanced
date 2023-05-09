package hello.advanced.trace.logtrace;

import hello.common.trace.TraceStatus;
import hello.common.trace.logtrace.ThreadLocalLogTrace;
import hello.common.util.AdvancedConstant;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class ThreadLocalLogTraceTest {

    ThreadLocalLogTrace trace = new ThreadLocalLogTrace();

    @Test
    void begin_end_level2() {
        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.begin("hello2");
        trace.end(status2);
        trace.end(status1);
    }

    @Test
    void begin_end_exception_level2() {
        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.begin("hello2");
        trace.exception(status2, new IllegalStateException(AdvancedConstant.EXCEPTION_MESSAGE));
        trace.exception(status1, new IllegalStateException(AdvancedConstant.EXCEPTION_MESSAGE));
    }
}