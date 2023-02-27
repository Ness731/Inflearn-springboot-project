package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    private MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;
    public OrderServiceImpl(MemberRepository memoryMemberRepository, DiscountPolicy fixDiscountPolicy) {
        this.memberRepository = memoryMemberRepository;
        this.discountPolicy = fixDiscountPolicy;
    }



    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        //1. 주문 생성 요청 -> 회원 정보 조회
        Member member = memberRepository.findById(memberId);
        //2. 할인 정책 적용
        int discountPrice = discountPolicy.discount(member, itemPrice);
        //3. 주문 객체 생성 후 반환 (원래는 DB에 저장)
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
