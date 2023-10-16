package baseball.controller;

import java.util.ArrayList;
import java.util.List;

public class HintCalculator {
    public static List<Integer> countStrikeAndBall(List<Integer> computer, List<Integer> user) {
        int strikeCount = 0;
        int ballCount= 0;
        for(int i = 0; i<user.size();++i){
            if(isStrike(computer.get(i), user.get(i))){
                ++strikeCount;
            }
            else if(isBall(computer, user.get(i))){
                ++ballCount;
            }
        }
        return List.of(strikeCount, ballCount);
    }

    private static boolean isStrike(int computerNum, int userNum){
        return computerNum == userNum;
    }

    private static boolean isBall(List<Integer> computer, int userNum) {
        return computer.contains(userNum);
    }
}
