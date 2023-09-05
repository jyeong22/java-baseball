package baseball.controller;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomUtility {
    private int startInclusive = 1;
    private int endInclusive = 9;
    private int numberLength = 3;

    public List<Integer> generateNumbers() {
        List<Integer> computerNumber = new ArrayList<>();

        for (int i = 0; i < numberLength; ++i) {
            computerNumber.add(generateNumber(computerNumber));
        }
        return computerNumber;
    }

    private int generateNumber(List<Integer> computerNumber){

        while(true){
            int number = Randoms.pickNumberInRange(startInclusive, endInclusive);
            if(!IsInList(number, computerNumber)){
                return number;
            }

        }
    }

    private boolean IsInList(int number, List<Integer> computerNumber) {
        return computerNumber.contains(number);
    }
}
