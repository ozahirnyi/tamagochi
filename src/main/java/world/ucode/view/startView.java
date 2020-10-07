package world.ucode.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import world.ucode.Main;

public class startView {
    Stage mainStage;
    Parent newRoot;
    Parent gameRoot;
    Parent overRoot;
    Scene newScene;
    Scene gameScene;
    Scene overScene;
    int x,y;

    public startView(Stage stage) throws Exception {
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
        gameRoot = FXMLLoader.load(getClass().getResource("/gamePlay.fxml"));
        gameScene = new Scene(gameRoot, 800, 600);
        mainStage.setScene(gameScene);
        mainStage.show();
    }
}
