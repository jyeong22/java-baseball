package baseball.view;

import baseball.controller.HintCalculator;
import baseball.model.ComputerNumber;

import java.util.List;

public class OutputView {
    public static void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printHint(List<Integer> strikeAndBallCount) {
        int strikeCount = strikeAndBallCount.get(0);
        int ballCount = strikeAndBallCount.get(1);
        if(strikeCount == 0 && ballCount == 0){
            System.out.println("낫싱");
        }
        else if(strikeCount == 0){
            System.out.println(ballCount+"볼");
        }
        else if (ballCount == 0) {
            System.out.println(strikeCount+"스트라이크");
        }
        else{
            System.out.println(ballCount+"볼 "+strikeCount+"스트라이크");
        }
    }

    public static void printEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
