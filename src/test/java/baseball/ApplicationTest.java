package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest {

    @Test
    @DisplayName("입력받은 문자열이 number인지 테스트")
    void isNumberTest(){
        String input = "iamnotnumber";
        assertThatThrownBy(()->{Application.isNumber(input);}).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("number에 0이 포함되어 있지 않은지 테스트")
    void notZeroInNumber(){
        String input = "012";
        assertThatThrownBy(()->{Application.notZeroInNumber(input);}).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("3자리 수인지 테스트")
    void isThreeDigits(){
        String input = "1234";
        assertThatThrownBy(()->{Application.isThreeDigits(input);}).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복된 값이 없는지 테스트")
    void isNotDuplicated(){
        String input = "122";
        List<Integer> userNumber = new ArrayList<>();
        assertThatThrownBy(()->{Application.isNotDuplicated(input, userNumber);}).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("볼, 스트라이크 개수 출력")
    void printStrikeAndBall(){
        List<Integer> computer_number = List.of(1, 2, 3);
        List<Integer> user_number = List.of(1,2,5);
        assertThat(Application.compare(computer_number, user_number)).isEqualTo(List.of(2, 0));
    }

}
