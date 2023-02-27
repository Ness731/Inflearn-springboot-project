package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class orderTest {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        //given
        Long memberId = 1L;
        String memberName = "memberA";
        Member member = new Member(memberId, memberName, Grade.VIP);
        memberService.join(member);

        //when
        //주문 객체를 생성하면 자동으로 할인율을 계산
        Order order = orderService.createOrder(member.getId(), "itemA", 1000);

        //then
        //생성된 주문 객체의 할인율이 고정할인금액과 일치하는지 비교
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
