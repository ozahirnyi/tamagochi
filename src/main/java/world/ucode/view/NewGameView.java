package world.ucode.view;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import world.ucode.Main;

public class NewGameView {
    public Button newGame;
    public Button loadGame;
    public TextField loadInput;
    public TextField newInput;

    public void newGamePressed() {
        Main.newGameCtrl.newInputParse(newInput.getText());
    }

    public void loadGamePressed() {
        Main.newGameCtrl.loadInputParse(loadInput.getText());
    }
}
