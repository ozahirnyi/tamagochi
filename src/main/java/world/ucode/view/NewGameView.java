package world.ucode.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NewGameView {
    Parent root;
    Scene scene;

    public NewGameView(Stage stage) throws Exception {
        root = FXMLLoader.load(getClass().getResource("/newGame.fxml"));
        scene = new Scene(root, 1001, 562);

        stage.setScene(scene);
        stage.show();
    }
}
