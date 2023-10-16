package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private ComputerNumber computerNumber;

    public void proceedGame(){
        boolean restartValue = true;
        printStartMessage();
        while(restartValue){
            gameStart();
            printEndMessage();
            restartValue = askRestart();
        }
    }

    private void printStartMessage() {
        OutputView.printStartMessage();
    }

    private void gameStart() {
        setComputerNumber();
        boolean isThreeStrike = false;
        while(!isThreeStrike){
            List<Integer> userNumber = inputUserNumber();
            List<Integer> integers = HintCalculator.countStrikeAndBall(computerNumber.getNumber(), userNumber);
            OutputView.printHint(integers);
            isThreeStrike = checkThreeStrike(integers);
        }
    }

    private boolean checkThreeStrike(List<Integer> integers) {
        return integers.get(0) == 3;
    }

    private void setComputerNumber() {
        computerNumber = new ComputerNumber();
    }

    private List<Integer> inputUserNumber() {
        List<Integer> userNumber = new ArrayList<>();
        String stringNumber = InputView.inputUserNumber();
        for (int i = 0; i < stringNumber.length(); ++i) {
            userNumber.add(stringNumber.charAt(i)-'0');
        }
        return userNumber;
    }

    private void printEndMessage() {
        OutputView.printEndMessage();
    }

    private boolean askRestart() {
        String num = InputView.inputRestartValue();
        if(num.equals("1")){
            return true;
        }
        else if(num.equals("2")){
            return false;
        }
        throw new IllegalArgumentException("1과 2 외의 다른 값을 입력하였습니다.");
    }

}
