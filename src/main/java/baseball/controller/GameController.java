package baseball.controller;

import baseball.model.GameNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class GameController {

    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    GameNumber gameNumber = new GameNumber();
    NumberValidator numberValidator = new NumberValidator();
    private ComputerController computerController = new ComputerController();

    public void proceedGame(){
        boolean restartValue = true;
        outputView.printStartMessage();
        while(restartValue){
            computerController.startGame(gameNumber);
            repeatGuessingAnswer();
            restartValue = askRestart();
        }
    }

    private boolean askRestart() {
        String value = inputView.inputRestart();
        return check(value);
    }

    private boolean check(String value) {
        if(value.equals("1")){
            return true;
        }
        else{
            return false;
        }
    }

    private void repeatGuessingAnswer() {
        boolean IsThreeStrike = false;
        while(!IsThreeStrike){
            setUserNumber();
            IsThreeStrike = computerController.compareUserAndComputer(gameNumber);
        }
    }



    private void setUserNumber() {
        gameNumber.setInputNumber(inputView.inputNumber());
        List<Integer> userNumber = numberValidator.validateNumber(gameNumber.getInputNumber());
        gameNumber.setUserNumber(userNumber);
    }


}
