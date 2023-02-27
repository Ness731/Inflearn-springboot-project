package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {
    private int discountPercent = 10;
    @Override
    public int discount(Member member, int price) {
        //vip면 10% 할인, 아니면 없음
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100; //할인율을 적용한 금액
        } else {
            return 0;
        }
    }
}
