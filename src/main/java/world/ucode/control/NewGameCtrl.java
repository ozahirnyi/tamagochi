package world.ucode.control;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import world.ucode.Main;

public class NewGameCtrl {
    public Button newGame;
    public Button loadGame;
    public TextField loadInput;
    public TextField newInput;

    public void newGamePressed() {
        newInputParse(newInput.getText());
    }

    public void loadGamePressed() {
        loadInputParse(loadInput.getText());
    }

    public void newInputParse(String data) {
        Main.newGameModel.newInputData(data);
    }

    public void loadInputParse(String data) {
        Main.newGameModel.loadInputData(data);
    }
}
