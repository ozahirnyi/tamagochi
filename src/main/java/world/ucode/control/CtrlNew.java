package world.ucode.control;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import world.ucode.Main;

public class CtrlNew {
    public Button newGame;
    public Button loadGame;
    public TextField loadInput;
    public TextField newInput;

    public void newGamePressed() throws Exception {
        if (newInputParse(newInput.getText()) == 1) {
            Main.View.gameCreator();
        } else System.out.println("newGame: Error");
    }

    public void loadGamePressed() throws Exception {
        if (loadInputParse(loadInput.getText()) == 1) {
            Main.View.gameCreator();
        } else System.out.println("loadGame: Error");
    }

    public int newInputParse(String data) {
        if (Main.Model.newInputData(data) == 1)
            return 1;
        else return 0;
    }

    public int loadInputParse(String data) {
        if (Main.Model.loadInputData(data) == 1)
            return 1;
        else return 0;
    }
}
