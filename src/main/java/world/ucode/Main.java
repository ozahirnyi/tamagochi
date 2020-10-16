package world.ucode;

import javafx.application.Application;
import javafx.stage.Stage;
import world.ucode.control.CtrlGame;
import world.ucode.control.CtrlNew;
import world.ucode.model.Model;
import world.ucode.view.View;

public class Main extends Application {
  static public CtrlNew CtrlNew;
  static public CtrlGame CtrlGame;
  static public View View;
  static public Model Model = new Model();

  @Override
  public void start(Stage stage) throws Exception {
    stage.setTitle("Tamagochi");
    View = new View(stage);
  }

  public static void main(String[] args) {
    launch(args);
  }
}
