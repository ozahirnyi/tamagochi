package world.ucode.control;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import world.ucode.Main;
import world.ucode.view.View;

public class Ctrl {
    public Scene gamePlay;
    public Button newGame;
    public Button loadGame;
    public Button settingsButton;
    public ProgressBar statusBar;
    public TextField loadInput;
    public TextField newInput;

    public void gamePlayKeyPressed() throws Exception {
    View.gameScene.setOnKeyPressed(
        event -> {
          KeyCode keyCode = event.getCode();
          if ((keyCode.equals(keyCode.W)) && Main.Model.canBorutoMove('W')) {
            View.borutoChar.setTranslateY(View.borutoChar.getTranslateY() - 5);
          }
          else if ((keyCode.equals(keyCode.S)) && Main.Model.canBorutoMove('S')) {
              View.borutoChar.setTranslateY(View.borutoChar.getTranslateY() + 5);
          }
          else if ((keyCode.equals(keyCode.A)) && Main.Model.canBorutoMove('A')) {
              View.borutoChar.setTranslateX(View.borutoChar.getTranslateX() - 10);
          }
          else if ((keyCode.equals(keyCode.D)) && Main.Model.canBorutoMove('D')) {
              View.borutoChar.setTranslateX(View.borutoChar.getTranslateX() + 10);
          }
        });
    }

    public void newGamePressed() throws Exception {
        if (newInputParse(newInput.getText()) == 1) {
            Main.View.gameCreator();
        } else System.out.println("newGame: Error");
    }

    public void loadGamePressed() throws Exception {
        if (loadInputParse(loadInput.getText()) == 1) {
            Main.View.gameCreator();
        } else System.out.println("newGame: Error");
    }

    public int newInputParse(String data) {
        if (Main.Model.newInputData(data) == 1)
            return 1;
        else return 0;
    }

    public int loadInputParse(String data) {
        if (Main.Model.loadInputData(data) == 1)
            return 1;
        else return 0;
    }

    public void settingsPressed() {
        System.out.println("Settings pressed!");
    }
}
