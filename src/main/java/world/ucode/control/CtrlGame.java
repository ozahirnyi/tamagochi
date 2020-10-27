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
                    if ((keyCode.equals(KeyCode.W))) Main.Model.canBorutoMove('W');
                    else if ((keyCode.equals(KeyCode.S))) Main.Model.canBorutoMove('S');
                    else if ((keyCode.equals(KeyCode.A))) Main.Model.canBorutoMove('A');
                    else if ((keyCode.equals(KeyCode.D))) Main.Model.canBorutoMove('D');
                });
    }

    public void gamePlayKeyReleased() throws Exception {
        View.gameScene.setOnKeyReleased(
                keyEvent -> {
                    KeyCode keyCode = keyEvent.getCode();
                    if (keyCode.equals(KeyCode.W)
                            || keyCode.equals(KeyCode.A)
                            || keyCode.equals(KeyCode.S)
                            || keyCode.equals(KeyCode.D))
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
                                Duration.seconds(3),
                                b -> {
                                    if (Model.thirst > 0) Model.thirst -= 0.1;
                                    if (Model.hunger > 0) Model.hunger -= 0.1;
                                    if (Model.health > 0) {
                                        if ((Model.thirst + Model.cleanliness
                                                + Model.hunger + Model.happiness) / 4 < 0.5) Model.health -= 0.1;
                                        else Model.health += 0.1;
                                    }
                                    if (Model.happiness >= 0 && Model.happiness <= 1) {
                                        if ((Model.thirst + Model.cleanliness
                                                + Model.health + Model.hunger) / 4 < 0.5) Model.happiness -= 0.1;
                                        else Model.happiness += 0.1;
                                    }
                                    if (Model.cleanliness > 0) Model.cleanliness -= 0.1;
                                    else if (Model.health <= 0) {
                                        try {
                                            Main.View.overCreator();
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
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
        View.cakraToken.setTokenValue(View.cakraToken.tokenValue += 5);
        Main.Model.trainPressed();
    }

    public void setFeedButton() throws Exception {
        if (View.cakraToken.tokenValue > 0) {
            View.cakraToken.setTokenValue(View.cakraToken.tokenValue -= 1);
            Main.Model.feedPressed();
        }
    }

    public void setWaterButton() throws Exception {
        if (View.cakraToken.tokenValue > 0) {
            View.cakraToken.setTokenValue(View.cakraToken.tokenValue -= 1);
            Main.Model.waterPressed();
        }
    }

    public void setMedicButton() throws Exception {
        if (View.cakraToken.tokenValue > 0) {
            View.cakraToken.setTokenValue(View.cakraToken.tokenValue -= 3);
            Main.Model.medicPressed();
        }
    }

    public void setCleanButton() throws Exception {
        if (View.cakraToken.tokenValue > 0) {
            View.cakraToken.setTokenValue(View.cakraToken.tokenValue -= 1);
            Main.Model.cleanPressed();
        }
    }

    public void settingsPressed() {
        System.out.println("Settings pressed!");
    }

    public void obnulyator() {
//        happinessBar.setProgress(0.5);
//        progressBar.setProgress(0.01);
//        cleanBar.setProgress(0.5);
//        healthBar.setProgress(0.5);
//        hungerBar.setProgress(0.5);
//        thirstBar.setProgress(0.5);
        Model.health = 0.5;
        Model.happiness = 0.5;
        Model.hunger = 0.5;
        Model.cleanliness = 0.5;
        Model.thirst = 0.5;
    }
}
