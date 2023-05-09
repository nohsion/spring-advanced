package hello.advanced;

import hello.common.trace.hellotrace.HelloTraceV1;
import hello.common.trace.hellotrace.HelloTraceV2;
import hello.common.trace.logtrace.LogTrace;
import hello.common.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TraceConfig {

    @Bean
    public HelloTraceV1 helloTraceV1() {
        return new HelloTraceV1();
    }

    @Bean
    public HelloTraceV2 helloTraceV2() {
        return new HelloTraceV2();
    }

    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }
}
