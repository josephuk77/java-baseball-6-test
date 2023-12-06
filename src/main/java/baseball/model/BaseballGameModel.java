package baseball.model;
import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseballGameModel {
    private List<Integer> computerNumbers;
    private int attempts;

    public BaseballGameModel() {
        // 생성자에서 컴퓨터 숫자 초기화
        computerNumbers = generateComputerNumbers();
        attempts = 0;
    }

    private List<Integer> generateComputerNumbers() {
        // 컴퓨터의 서로 다른 3개의 숫자 생성
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    public String checkGuess(List<Integer> userNumbers) {
        // 사용자 입력과 컴퓨터 숫자를 비교하여 결과를 반환
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            int userDigit = userNumbers.get(i);
            int computerDigit = computerNumbers.get(i);

            if (userDigit == computerDigit) {
                strikes++;
            } else if (computerNumbers.contains(userDigit)) {
                balls++;
            }
        }

        if (strikes == 3) {
            return "3스트라이크";
        } else if (strikes > 0 || balls > 0) {
            return balls + "볼 " + strikes + "스트라이크" ;
        } else {
            return "낫싱";
        }
    }

    // 게임 종료 여부 확인 메서드
    public boolean isGameOver() {
        return attempts >= 9; // 최대 9번 시도까지 가능하도록 설정
    }

    public void restartGame() {
        // 게임 재시작을 처리하는 메서드
        computerNumbers = generateComputerNumbers();
        attempts = 0;
    }

    public int getAttempts() {
        return attempts;
    }
}
