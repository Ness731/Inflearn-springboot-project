package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean(name = "memberService") // Bean 이름 수동 지정
    public MemberService memberService() { // Bean 이름 자동 지정 시 메서드 이름과 동일
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public void example() {

    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }

    //리팩터링 전 : 기존에는 직접 new 연산자로 구현체 객체를 생성하여 생성자에 넘겨주었다.
    //리팩터링 후 : 구현체 객체를 생성하는 작업을 별도의 메서드로 분리한다.
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        //구현체를 수정하더라도 사용 영역에는 영향을 미치지 않는다.
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
