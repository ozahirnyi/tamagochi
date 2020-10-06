package world.ucode.control;

import world.ucode.Main;

public class NewGameCtrl {
    public void newInputParse(String data) {
        if (data != null) {
            Main.newGameModel.newInputData(data);
        }
        else {
            System.out.println("newInputParse: error");
        }
    }

    public void loadInputParse(String data) {
        if (data != null) {
            Main.newGameModel.loadInputData(data);
        }
        else {
            System.out.println("loadInputParse: error");
        }
    }
}
