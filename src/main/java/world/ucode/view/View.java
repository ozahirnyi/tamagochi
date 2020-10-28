package world.ucode.view;

import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import world.ucode.Main;

import java.net.URL;

public class View {
    public static BorutoChar borutoChar = new BorutoChar();
    public static Cakra cakraToken = new Cakra();
    private MediaPlayer newMedia;
    private MediaPlayer overMedia;
    Stage mainStage;
    Pane newRoot;
    static public Pane gameRoot;
    Pane overRoot;
    Scene newScene;
    public static Scene gameScene;
    Scene overScene;

    public View(Stage stage) throws Exception {
        mainStage = stage;

        newCreator();
    }

    public void newGameOn() {
        overMedia.stop();
        newMedia.play();
        Main.CtrlGame.obnulyator();
        mainStage.setHeight(562);
        mainStage.setWidth(1001);
        mainStage.setScene(newScene);
        mainStage.show();
    }

    public void gamePlayOn() {
        Main.CtrlGame.barsTimeline.play();
        mainStage.setHeight(650);
        mainStage.setWidth(800);
        mainStage.setScene(gameScene);
        mainStage.show();
    }

    public void newCreator() throws Exception {
        URL filePath = View.class.getResource("/music/newGame.mp3");
        Media hit = new Media(filePath.toString());
        MediaPlayer mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.setCycleCount(Timeline.INDEFINITE);
        mediaPlayer.play();
        newMedia = mediaPlayer;

        newRoot = FXMLLoader.load(getClass().getResource("/newGame.fxml"));
        newScene = new Scene(newRoot, 1001, 562);
        mainStage.setScene(newScene);
        mainStage.show();
    }

    public void gameCreator() throws Exception {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("/gamePlay.fxml"));
        gameRoot = loader.load(getClass().getResourceAsStream("/gamePlay.fxml"));
        gameRoot.getChildren().add(borutoChar);
        gameRoot.getChildren().add(cakraToken);
        gameScene = new Scene(gameRoot, 800, 600);
        Main.CtrlGame = loader.getController();
        Main.CtrlGame.update();
        mainStage.setScene(gameScene);
        mainStage.show();
    }

    public void overCreator() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        URL filePath = View.class.getResource("/music/gameOver.mp3");
        Media hit = new Media(filePath.toString());
        MediaPlayer mediaPlayer = new MediaPlayer(hit);

        newMedia.stop();
        mediaPlayer.setCycleCount(Timeline.INDEFINITE);
        mediaPlayer.play();
        overMedia = mediaPlayer;

        loader.setLocation(getClass().getResource("/gameOver.fxml"));
        overRoot = loader.load(getClass().getResourceAsStream("/gameOver.fxml"));
        overScene = new Scene(overRoot, 800, 529);
        mainStage.setHeight(529);
        mainStage.setScene(overScene);
    }
}
