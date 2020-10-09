package world.ucode.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import world.ucode.Main;

public class View {
    public static borutoChar borutoChar;
    Stage mainStage;
    Pane newRoot;
    Pane gameRoot;
    Pane overRoot;
    Scene newScene;
    public static Scene gameScene;
    Scene overScene;
    int x,y;

    public View(Stage stage) throws Exception {
        mainStage = stage;
        x = 1001;
        y = 562;

        newCreator();
    }

    public void newCreator() throws Exception {
        newRoot = FXMLLoader.load(getClass().getResource("/newGame.fxml"));
        newScene = new Scene(newRoot, x, y);
        mainStage.setScene(newScene);
        mainStage.show();
    }

    public void gameCreator() throws Exception {
        borutoChar = new borutoChar();
        gameRoot = FXMLLoader.load(getClass().getResource("/gamePlay.fxml"));
        gameRoot.getChildren().add(borutoChar);
        gameScene = new Scene(gameRoot, 800, 600);
        Main.Ctrl.gamePlayKeyPressed();
        mainStage.setScene(gameScene);
        mainStage.show();
    }
}
