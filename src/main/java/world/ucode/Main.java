package world.ucode;

import javafx.application.Application;
import javafx.stage.Stage;
import world.ucode.control.Ctrl;
import world.ucode.model.Model;
import world.ucode.view.View;

public class Main extends Application {
  static public Ctrl Ctrl = new Ctrl();
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
