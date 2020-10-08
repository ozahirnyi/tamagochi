package world.ucode.model;

import world.ucode.view.View;

public class Model {
    public boolean canBorutoMove(char key) {
        if (key == 'W')
            return View.borutoChar.getTranslateY() >= 333;
        else if (key == 'S')
            return View.borutoChar.getTranslateY() <= 388;
        else if (key == 'D')
            return View.borutoChar.getTranslateX() <= 760;
        else if (key == 'A')
            return View.borutoChar.getTranslateX() >= 0;
        else return false;
    }

    public int newInputData(String data) {
        if (data.equals("Grisha"))
            return 1;
        else return 0;
    }

    public int loadInputData(String data) {
        if (data.equals("Oleg"))
            return 0;
        else return 1;
    }
}
