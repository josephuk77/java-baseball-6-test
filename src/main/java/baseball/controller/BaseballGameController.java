package baseball.controller;


import baseball.model.BaseballGameModel;
import baseball.view.BaseballGameView;
import java.util.List;

public class BaseballGameController {
    private BaseballGameModel model;
    private BaseballGameView view;

    public BaseballGameController(BaseballGameModel model, BaseballGameView view) {
        this.model = model;
        this.view = view;
    }

    public void startGame() {
        view.printMessage("숫자 야구 게임을 시작합니다.\n");

        while (!model.isGameOver()) {
            List<Integer> userNumbers = view.getUserInput();
            String result = model.checkGuess(userNumbers);
            view.printMessage(result+"\n");

            if (result.equals("3스트라이크")) {
                view.printMessage("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                int choice = view.askForRestartOrExit();
                if (choice == 1) {
                    model.restartGame();
                    view.printMessage("숫자 야구 게임을 다시 시작합니다.\n");
                } else {
                    view.printMessage("게임을 종료합니다.");
                    break;
                }
            }
        }
    }
}

