package baseball.view;

public class OutputView {
    private String startMessage = "숫자 야구 게임을 시작합니다.";
    private String endMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void printStartMessage(){
        System.out.println(startMessage);
    }

    public void printNumberHint(String hintMessage){
        System.out.println(hintMessage);
    }

    public void printEndMessage(){
        System.out.println(endMessage);
    }

}
