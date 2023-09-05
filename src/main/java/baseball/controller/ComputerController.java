package baseball.controller;

import baseball.model.GameNumber;
import baseball.view.OutputView;

import java.util.List;

public class ComputerController {

    RandomUtility randomUtility = new RandomUtility();
    private int strikeCount;
    private int ballCount;
    OutputView outputView= new OutputView();

    public void startGame(GameNumber gameNumber){
        gameNumber.setComputerNumber(randomUtility.generateNumbers());
    }

    public boolean compareUserAndComputer(GameNumber gameNumber) {
        List<Integer> computerNumber = gameNumber.getComputerNumber();
        List<Integer> userNumber = gameNumber.getUserNumber();
        compare(computerNumber, userNumber);
        return IsThreeStrike();

    }

    private void compare(List<Integer> computerNumber, List<Integer> userNumber) {
        init();
        check(computerNumber, userNumber);
        provideHint();
    }

    private void provideHint() {
        System.out.println("strike 개수: "+strikeCount+" ball 개수: "+ballCount);
    }

    private boolean IsThreeStrike() {
        if(strikeCount == 3){
            outputView.printEndMessage();
        }
        return strikeCount == 3;
    }

    private void check(List<Integer> computerNumber, List<Integer> userNumber) {
        for(int i = 0; i<computerNumber.size();++i){
            if(IsSame(computerNumber.get(i), userNumber.get(i))){
                ++strikeCount;
            }
            else if (!IsSame(computerNumber.get(i), userNumber.get(i))
                && IsInclude(computerNumber, userNumber.get(i))){
                ++ballCount;
            }

        }
    }
    private boolean IsSame(int i, int j){
        return i==j;
    }

    private boolean IsInclude(List<Integer>computerNumber, int i){
        return computerNumber.contains(i);
    }

    private void init() {
        strikeCount = 0;
        ballCount= 0;
    }
}
