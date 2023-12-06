package baseball.view;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGameView {
    public void printMessage(String message) {
        System.out.printf(message);
    }

    public List<Integer> getUserInput() {
        List<Integer> userNumbers = new ArrayList<>();
        boolean isValidInput = false;

        while (!isValidInput) {
            try {
                printMessage("숫자를 입력해주세요 : ");
                String userInput = Console.readLine();
                if (userInput.length() != 3) {
                    throw new IllegalArgumentException("3자리 숫자를 입력하세요.\n");
                }

                for (char digitChar : userInput.toCharArray()) {
                    int digit = Character.getNumericValue(digitChar);
                    if (digit < 1 || digit > 9) {
                        throw new IllegalArgumentException("1부터 9까지의 숫자만 입력하세요.\n");
                    }
                    userNumbers.add(digit);
                }

                if (userNumbers.get(0) == userNumbers.get(1) ||
                        userNumbers.get(0) == userNumbers.get(2) ||
                        userNumbers.get(1) == userNumbers.get(2)) {
                    throw new IllegalArgumentException("서로 다른 3자리 숫자를 입력하세요.\n");
                }

                isValidInput = true;
            } catch (IllegalArgumentException e) {
                printMessage(e.getMessage());
                userNumbers.clear();
                // 아래 라인을 추가하여 예외를 발생시킵니다.
                throw e;
            }
        }

        return userNumbers;
    }


    public int askForRestartOrExit() {
        int choice = -1;

        while (choice != 1 && choice != 2) {
            try {
                printMessage("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
                choice = Integer.parseInt(Console.readLine());
                if (choice != 1 && choice != 2) {
                    throw new IllegalArgumentException("1 또는 2를 입력하세요.\n");
                }
            } catch (IllegalArgumentException e) {
                printMessage(e.getMessage());
            }
        }

        return choice;
    }
}
