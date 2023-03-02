package hello.core.singleton;

public class StatefulService {
    private int price;

    public void order(String name, int price) {
        System.out.println("name = " + name);
        System.out.println("price = " + price);
        this.price = price; // 싱글톤 객체로 인해 공유 변수 값의 충돌이 발생할 수 있는 로직
    }

    public int getPrice() {
        return price;
    }
}
