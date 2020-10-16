package world.ucode.control;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.KeyCode;
import world.ucode.Main;
import world.ucode.view.View;

public class CtrlGame {
  public double progressBarValue = 0.001;
//  @FXML private ProgressBar progressBar;
//  @FXML private Button settingsButton;
//  @FXML private Button trainButton;
//  @FXML private Button feedButton;
//  @FXML private Button waterButton;
//  @FXML private Button medicButton;
//  @FXML private Button cleanButton;
//  @FXML private ProgressBar hungerBar;
//  @FXML private ProgressBar healthBar;
//  @FXML private ProgressBar happinessBar;
//  @FXML private ProgressBar thirstBar;
//  @FXML private ProgressBar cleanBar;

    public ProgressBar progressBar;
    public Button settingsButton;
    public Button trainButton;
    public Button feedButton;
    public Button waterButton;
    public Button medicButton;
    public Button cleanButton;
    public ProgressBar hungerBar;
    public ProgressBar healthBar;
    public ProgressBar happinessBar;
    public ProgressBar thirstBar;
    public ProgressBar cleanBar;

  @FXML
  public void initialize() throws Exception {}

  public void gamePlayKeyPressed() throws Exception {
    View.gameScene.setOnKeyPressed(
        event -> {
          KeyCode keyCode = event.getCode();
          if ((keyCode.equals(keyCode.W))) {
            System.out.println("YA TUT");
            progressBar.setProgress(progressBar.getProgress() + 0.001);
            Main.Model.canBorutoMove('W');
          } else if ((keyCode.equals(keyCode.S))) Main.Model.canBorutoMove('S');
          else if ((keyCode.equals(keyCode.A))) Main.Model.canBorutoMove('A');
          else if ((keyCode.equals(keyCode.D))) Main.Model.canBorutoMove('D');
        });
  }

//  public void setProgressBar(double value) {
//    progressBar.setProgress(progressBar.getProgress() + value);
//  }

  public void gamePlayKeyReleased() throws Exception {
    View.gameScene.setOnKeyReleased(
        keyEvent -> {
          KeyCode keyCode = keyEvent.getCode();
          if (keyCode.equals(keyCode.W)
              || keyCode.equals(keyCode.A)
              || keyCode.equals(keyCode.S)
              || keyCode.equals(keyCode.D))
            if (!View.borutoChar.stayStatus) View.borutoChar.borutoStand();
        });
  }

  public static void update() {
    AnimationTimer update =
        new AnimationTimer() {
          @Override
          public void handle(long l) {
            try {
              Main.CtrlGame.gamePlayKeyPressed();
              Main.CtrlGame.gamePlayKeyReleased();
            } catch (Exception e) {
              e.printStackTrace();
            }
          }
        };
    update.start();
  }

  public void setTrainButton() throws Exception {
//    progressBar.setProgress(progressBar.getProgress() + 0.1);
    //        progressBar.setProgress(progressBar.getProgress() + 0.1);
    //        Model.trainPressed();
  }

  public void setFeedButton() throws Exception {
    //        progressBar.setProgress(progressBar.getProgress() - 0.1);
    //        Main.Model.feedPressed();
  }

  public void setWaterButton() throws Exception {
    //        Main.Model.waterPressed();
  }

  public void setMedicButton() throws Exception {
    //        Main.Model.medicPressed();
  }

  public void setCleanButton() throws Exception {
    //        Main.Model.cleanPressed();
  }

  public void settingsPressed() {
    System.out.println("Settings pressed!");
  }
}
