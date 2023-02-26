package hello.core.member;

public class MemberServiceImpl implements MemberService {
    //TODO : OCP, DIP를 준수하기 위해 순수 자바 코드를 Spring으로 리팩터링
    //순수 자바 코드 : 인터페이스가 아닌 그 구현체에 의존
    MemberRepository memberRepository = new MemoryMemberRepository();
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
