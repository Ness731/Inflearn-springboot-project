package hello.core.singleton;

import hello.core.member.Grade;
import hello.core.member.Member;

public class SingletonService {
    // 1. static 영역에 객체를 딱 1개만 생성해둔다.
    private static final SingletonService instance = new SingletonService();

    // 2
    public static SingletonService getInstance() {
        return instance;
    }

    public SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}
