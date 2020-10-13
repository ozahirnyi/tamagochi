package world.ucode.control;

import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import world.ucode.Main;
import world.ucode.model.Model;
import world.ucode.view.View;

public class Ctrl {
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

    public void gamePlayKeyReleased() throws Exception {
        View.gameScene.setOnKeyReleased(keyEvent -> {
            KeyCode keyCode = keyEvent.getCode();
            if (keyCode.equals(keyCode.W) || keyCode.equals(keyCode.A)
                    || keyCode.equals(keyCode.S) || keyCode.equals(keyCode.D))
                if (!View.borutoChar.stayStatus) View.borutoChar.borutoStand();
        });
    }

    public void setTrainButton() throws Exception {
        progressBar.setProgress(progressBar.getProgress() + 0.1);
        Model.trainPressed();
    }

    public void setFeedButton() throws Exception {
        progressBar.setProgress(progressBar.getProgress() - 0.1);
        Main.Model.feedPressed();
    }

    public void setWaterButton() throws Exception {
        Main.Model.waterPressed();
    }

    public void setMedicButton() throws Exception {
        Main.Model.medicPressed();
    }

    public void setCleanButton() throws Exception {
        Main.Model.cleanPressed();
    }

    public void newGamePressed() throws Exception {
        if (newInputParse(newInput.getText()) == 1) {
            Main.View.gameCreator();
        } else System.out.println("newGame: Error");
    }

    public void loadGamePressed() throws Exception {
        if (loadInputParse(loadInput.getText()) == 1) {
            Main.View.gameCreator();
        } else System.out.println("loadGame: Error");
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
