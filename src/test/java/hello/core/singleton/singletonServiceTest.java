package hello.core.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class singletonServiceTest {
    @Test
    @DisplayName("싱글톤 객체는 참조값이 같아야 한다.")
    public void singletonTest() {
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();
        assertThat(singletonService1).isEqualTo(singletonService2);
    }
}