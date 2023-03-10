package hello.core;

import hello.core.member.Grade;
import hello.core.member.MemberService;
import hello.core.member.Member;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class MemberApp {
    public static void main(String[] args) {
        //AppConfig appConfig = new AppConfig(); //appConfig를 통해 의존성 주입
        // MemberService memberService = appConfig.memberService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA",Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("member = " + member.getName()); //memberA
        System.out.println("findMember = " + findMember.getName()); //memberA
    }
}
