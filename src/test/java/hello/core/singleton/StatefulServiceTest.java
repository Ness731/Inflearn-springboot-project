package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.assertj.core.api.Assertions.assertThat;

public class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService bean1 = ac.getBean(StatefulService.class);
        StatefulService bean2 = ac.getBean(StatefulService.class);
        bean1.order("bean1", 1000);
        bean2.order("bean2", 2000);

        assertThat(bean1.getPrice()).isEqualTo(2000); //bean2로 인해 공유 필드의 값이 변경됨
    }

    @Configuration
    public static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}
