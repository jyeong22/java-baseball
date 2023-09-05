package baseball.model;

import java.util.List;

public class GameNumber {
    private String inputNumber;
    private List<Integer> computerNumber;
    private List<Integer> userNumber;

    public void setInputNumber(String inputNumber){
        this.inputNumber = inputNumber;
    }
    public void setComputerNumber(List<Integer> computerNumber){
        this.computerNumber = computerNumber;
    }
    public void setUserNumber(List<Integer> userNumber){
        this.userNumber = userNumber;
    }

    public String getInputNumber(){
        return inputNumber;
    }
    public List<Integer> getComputerNumber(){
        return computerNumber;
    }

    public List<Integer> getUserNumber(){
        return userNumber;
    }
}
