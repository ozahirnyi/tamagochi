package world.ucode.control;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;
import javafx.util.Duration;
import world.ucode.Main;
import world.ucode.model.Model;
import world.ucode.view.View;

public class CtrlGame {
  public Text currentLvl;
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

  public void gamePlayKeyPressed() throws Exception {
    View.gameScene.setOnKeyPressed(
        event -> {
          KeyCode keyCode = event.getCode();
          if ((keyCode.equals(keyCode.W))) Main.Model.canBorutoMove('W');
          else if ((keyCode.equals(keyCode.S))) Main.Model.canBorutoMove('S');
          else if ((keyCode.equals(keyCode.A))) Main.Model.canBorutoMove('A');
          else if ((keyCode.equals(keyCode.D))) Main.Model.canBorutoMove('D');
        });
  }

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

  public void update() {
    Timeline progressTimeline =
        new Timeline(
            new KeyFrame(
                Duration.seconds(300),
                p -> {
                  if (Model.progressBar > 0) Model.progressBar -= 0.1;
                }));

    Timeline barsTimeline =
        new Timeline(
            new KeyFrame(
                Duration.seconds(30),
                b -> {
                  if (Model.thirst > 0) Model.thirst -= 0.1;
                  if (Model.hunger > 0) Model.hunger -= 0.1;
                  if (Model.health > 0) Model.health -= 0.1;
                  if (Model.happiness >= 0 && Model.happiness <= 1) {
                    if ((Model.thirst + Model.cleanliness + Model.health + Model.hunger) / 4
                        < 0.5) Model.happiness -= 0.1;
                    else Model.happiness += 0.1;
                  }
                  if (Model.cleanliness > 0) Model.cleanliness -= 0.1;
                }));

    AnimationTimer update =
        new AnimationTimer() {
          @Override
          public void handle(long l) {
            try {
              checkBars();
              Main.Model.checkLvl();
              Main.CtrlGame.gamePlayKeyPressed();
              Main.CtrlGame.gamePlayKeyReleased();
            } catch (Exception e) {
              e.printStackTrace();
            }
          }
        };
    progressTimeline.setCycleCount(Animation.INDEFINITE);
    progressTimeline.play();
    barsTimeline.setCycleCount(Animation.INDEFINITE);
    barsTimeline.play();
    update.start();
  }

  private void checkBars() {
//    if (progressBar.getProgress() < Model.progressBar)
//      progressBar.setProgress(progressBar.getProgress() + 0.003);
//    else if (progressBar.getProgress() > Model.progressBar)
//      progressBar.setProgress(progressBar.getProgress() - 0.003);
      changeBars(progressBar, Model.progressBar);
      changeBars(happinessBar, Model.happiness);
      changeBars(healthBar, Model.health);
      changeBars(hungerBar, Model.hunger);
      changeBars(thirstBar, Model.thirst);
      changeBars(cleanBar, Model.cleanliness);
  }

  private void changeBars(ProgressBar bar, double modelBar) {
      if (bar.getProgress() < modelBar)
          bar.setProgress(bar.getProgress() + 0.003);
      else if (bar.getProgress() > modelBar)
          bar.setProgress(bar.getProgress() - 0.003);
  }

  public void setTrainButton() throws Exception {
    Main.Model.trainPressed();
  }

  public void setFeedButton() throws Exception {
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

  public void settingsPressed() {
    System.out.println("Settings pressed!");
  }

  public void barIncrease(ProgressBar bar, double value) {
    for (double buf = 0; buf < value; buf += 0.0001) bar.setProgress(bar.getProgress() + buf);
  }
}
