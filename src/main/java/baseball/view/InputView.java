package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private String inputNumberMessage = "숫자를 입력해주세요: ";
    private String inputRestartMessage = "게임을 새로 시작하려면 1, 종료하려면 2를 입력해주세요";

    public String inputNumber(){
        System.out.print(inputNumberMessage);
        return Console.readLine();
    }

    public String inputRestart(){
        System.out.println(inputRestartMessage);
        return Console.readLine();
    }

}
