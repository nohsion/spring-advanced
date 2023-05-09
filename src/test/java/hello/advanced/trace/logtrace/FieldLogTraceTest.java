package hello.advanced.trace.logtrace;

import hello.common.trace.TraceStatus;
import hello.common.trace.logtrace.FieldLogTrace;
import hello.common.util.AdvancedConstant;
import org.junit.jupiter.api.Test;

class FieldLogTraceTest {

    FieldLogTrace trace = new FieldLogTrace();

    @Test
    void begin_end_level2() {
        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.begin("hello2");

        trace.end(status2);
        trace.end(status1);
    }

    @Test
    void begin_exception_level2() {
        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.begin("hello2");

        trace.exception(status2, new IllegalStateException(AdvancedConstant.EXCEPTION_MESSAGE));
        trace.exception(status1, new IllegalStateException(AdvancedConstant.EXCEPTION_MESSAGE));
    }

}