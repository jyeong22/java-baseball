package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        printStartMessage();
        List<Integer> computerNumber = makeRandomNumber(1, 9, 3);
        playGame(computerNumber);
        while(reStart().equals("1")){
            computerNumber = makeRandomNumber(1, 9, 3);
            playGame(computerNumber);
        }
    }

    private static void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private static List<Integer> makeRandomNumber(int startInclusive, int endInclusive, int count) {
        return Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);
    }

    private static void playGame(List<Integer> computer_number) {
        boolean check = true;
        while(check){
            List<Integer> userNumber = inputUserNumber();
            List<Integer> result = compare(computer_number, userNumber);
            printResult(result);
            if(result.get(0) == 3){
                check = false;
            }

        }
    }


    private static List<Integer> inputUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        List<Integer> userNumber = new ArrayList<>();

        isNumber(input);
        notZeroInNumber(input);
        isThreeDigits(input);
        isNotDuplicated(input, userNumber);

        return userNumber;
    }


    public static void isNotDuplicated(String input, List<Integer> userNumber) {
        for(int i = 0; i< input.length(); ++i){
            if(userNumber.contains(input.charAt(i)-'0')){
                throw new IllegalArgumentException("it should not be duplicated");
            }
            userNumber.add(input.charAt(i)-'0');
        }
    }

    public static void isThreeDigits(String input) {
        int num = Integer.parseInt(input);
        if(111>num || num > 999){
            throw new IllegalArgumentException("it should be number");
        }
    }

    public static void notZeroInNumber(String input) {
        for(int i = 0; i< input.length(); ++i){
            if(input.charAt(i)=='0'){
                throw new IllegalArgumentException("0 cannot be digit");
            }
        }
    }

    public static void isNumber(String input) {
        for(int i = 0; i< input.length(); ++i){
            if(!Character.isDigit(input.charAt(i))){
                throw new IllegalArgumentException("it should be number");
            }
        }
    }

    public static List<Integer> compare(List<Integer> computer_number, List<Integer> user_number) {
        int strike_cnt = 0;
        int ball_cnt = 0;
        for(int i = 0; i<computer_number.size();++i){
            int num = computer_number.get(i);
            if(user_number.contains(num) && user_number.get(i) == num){
                ++strike_cnt;
            }
            else if (user_number.contains(num) && user_number.get(i) != num){
                ++ball_cnt;
            }
        }
        return List.of(strike_cnt, ball_cnt);
    }

    public static void printResult(List<Integer>result) {
        int strike_cnt = result.get(0);
        int ball_cnt = result.get(1);

        if(strike_cnt == 0 && ball_cnt == 0){
            System.out.println("낫싱");
        }
        else if(strike_cnt == 0 && ball_cnt != 0){
            System.out.println(ball_cnt +"볼");
        }
        else if(strike_cnt != 0 && ball_cnt == 0){
            System.out.println(strike_cnt+"스트라이크");
        }
        else{
            System.out.println(ball_cnt +"볼 "+strike_cnt+"스트라이크");
        }
        if(strike_cnt == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }

    }



    private static String reStart() {
        System.out.println("게임을 시작하려면 1, 종료하려면 2를 입력하세요");
        return Console.readLine();
    }

}
