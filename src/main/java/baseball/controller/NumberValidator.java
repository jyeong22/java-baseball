package baseball.controller;

import java.util.ArrayList;
import java.util.List;

public class NumberValidator {
    private int numberLength = 3;
    private char startInclusive = '1';
    private char endInclusive = '9';

    private String notNumberErrorMessage = "숫자가 아닙니다.";
    private String numberLengthErrorMessage = "세자리 숫자가 아닙니다.";
    private String notBetween1to9ErrorMessage = "1부터 9사이의 숫자로 이루어져 있지 않습니다.";
    private String  isInDuplicateErrorMessage= "중복된 숫자가 있습니다.";

    public List<Integer> validateNumber(String number){
        if(!IsNumber(number)){
            throw new IllegalArgumentException(notNumberErrorMessage);
        }
        if(!IsThreeNumber(number)){
            throw new IllegalArgumentException(numberLengthErrorMessage);
        }
        if(!IsBetween1to9(number)){
            throw new IllegalArgumentException(notBetween1to9ErrorMessage);
        }
        if(!IsNotDuplicated(number)){
            throw new IllegalArgumentException(isInDuplicateErrorMessage);
        }
        return makeNumberList(number);
    }



    private boolean IsNumber(String number) {
        try{
            Integer.parseInt(number);
            return true;
        }
        catch(NumberFormatException ex){
            return false;
        }
    }

    private boolean IsThreeNumber(String number) {
        return number.length() == numberLength;

    }
    private boolean IsBetween1to9(String number) {
        for(int i = 0; i<number.length();++i){
            if(number.charAt(i)<startInclusive || number.charAt(i)>endInclusive){
                return false;
            }
        }
        return true;
    }

    private boolean IsNotDuplicated(String number) {
        boolean [] numArray = new boolean[10];
        for (int i = 0; i < number.length(); ++i) {
            int num = number.charAt(i) - '0';
            if(numArray[num]){
                return false;
            }
            numArray[num] = true;
        }
        return true;
    }

    private List<Integer> makeNumberList(String number) {
        List<Integer>userNumber = new ArrayList<>();
        for (int i = 0; i < number.length(); ++i) {
            int num = number.charAt(i) - '0';
            userNumber.add(num);
        }
        return userNumber;
    }
}
