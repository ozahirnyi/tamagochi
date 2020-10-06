package world.ucode;

import javafx.application.Application;
import javafx.stage.Stage;
import world.ucode.control.NewGameCtrl;
import world.ucode.model.NewGameModel;
import world.ucode.view.NewGameView;

public class Main extends Application {
  static public NewGameCtrl newGameCtrl = new NewGameCtrl();
  static public NewGameModel newGameModel = new NewGameModel();
  static public NewGameView newGameView;

  @Override
  public void start(Stage stage) throws Exception {
    stage.setTitle("Tamagochi");
    newGameView = new NewGameView(stage);
  }

  public static void main(String[] args) {
    launch(args);
  }
}
