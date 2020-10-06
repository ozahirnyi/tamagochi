package world.ucode;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import world.ucode.control.NewGameCtrl;
import world.ucode.model.NewGameModel;
import world.ucode.view.NewGameView;

public class Main extends Application {
  static public NewGameCtrl newGameCtrl = new NewGameCtrl();
  static public NewGameModel newGameModel = new NewGameModel();
  static public NewGameView newGameView = new NewGameView();

  @Override
  public void start(Stage stage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("/newGame.fxml"));

    Scene scene = new Scene(root, 1001, 562);
    
    stage.setTitle("FXML Welcome");
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
