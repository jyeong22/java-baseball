package baseball.controller;

public class NumberValidator {

    public static String validate(String number){
        if (isEmpty(number)) {
            throw new IllegalArgumentException("빈 칸을 입력하였습니다.");
        }
        else if (!isThreeCharacter(number) || !isNumber(number)){
            throw new IllegalArgumentException("세자리 숫자가 아닙니다.");
        }
        else if(!isInRange(number)){
            throw new IllegalArgumentException("1부터 9사이의 숫자로 이루어있지 않습니다.");
        }
        else if(!isNotDuplicated(number)){
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
        return number;
    }

    private static boolean isNotDuplicated(String number) {
        return number.chars().count() == number.chars().distinct().count();
    }

    private static boolean isInRange(String number) {
        return number.chars().allMatch(num -> num>='1' && num<='9');
    }

    private static boolean isNumber(String number) {
        return number.chars().allMatch(Character::isDigit);
    }

    private static boolean isThreeCharacter(String number) {
        return number.length() == 3;
    }

    private static boolean isEmpty(String number) {
        return number.isBlank();
    }
}
