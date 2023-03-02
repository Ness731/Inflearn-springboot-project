package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class singletonContainerTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    @Test
    @DisplayName("스프링 컨테이너는 싱글톤 방식이다")
    void singletonContainer() {
        MemberRepository bean1 = ac.getBean(MemberRepository.class);
        MemberRepository bean2 = ac.getBean(MemberRepository.class);
        System.out.println("bean1 = " + bean1);
        System.out.println("bean2 = " + bean2);
        assertThat(bean1).isEqualTo(bean2);
    }
}
