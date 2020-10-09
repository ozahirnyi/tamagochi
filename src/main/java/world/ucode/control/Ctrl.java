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
    public Button trainButton;
    public Button feedButton;
    public Button waterButton;
    public Button medicButton;
    public Button cleanButton;
    public ProgressBar progressBar;
    public ProgressBar hungerBar;
    public ProgressBar healthBar;
    public ProgressBar happinessBar;
    public ProgressBar thirstBar;
    public ProgressBar cleanBar;
    public TextField loadInput;
    public TextField newInput;

    public void gamePlayKeyPressed() throws Exception {
    View.gameScene.setOnKeyPressed(
        event -> {
          KeyCode keyCode = event.getCode();
          if ((keyCode.equals(keyCode.W)))
              Main.Model.canBorutoMove('W');
          else if ((keyCode.equals(keyCode.S)))
              Main.Model.canBorutoMove('S');
          else if ((keyCode.equals(keyCode.A)))
              Main.Model.canBorutoMove('A');
          else if ((keyCode.equals(keyCode.D)))
              Main.Model.canBorutoMove('D');
        });
    }

    public void setTrainButton() throws Exception {
        Main.Model.trainPressed();
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
