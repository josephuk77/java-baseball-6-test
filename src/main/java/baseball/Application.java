package baseball;

import baseball.controller.BaseballGameController;
import baseball.model.BaseballGameModel;
import baseball.view.BaseballGameView;

public class Application {
    public static void main(String[] args) {
        BaseballGameController controller = new BaseballGameController( new BaseballGameModel() , new BaseballGameView());
        controller.startGame();
    }
}
