package world.ucode.model;

import world.ucode.view.View;

class GameLogicData {
    static int health = 50;
    static int happiness = 50;
    static int hunger = 50;
    static int thirst = 50;
    static int cleanliness = 50;
    static int progressBar = 50;
}

public class Model {
    GameLogicData gameLogicData = new GameLogicData();

    public void canBorutoMove(char key) {
        if (key == 'W' && View.borutoChar.getTranslateY() >= 333)
            View.borutoChar.setTranslateY(View.borutoChar.getTranslateY() - 5);
        else if (key == 'S' && View.borutoChar.getTranslateY() <= 388)
            View.borutoChar.setTranslateY(View.borutoChar.getTranslateY() + 5);
        else if (key == 'D' && View.borutoChar.getTranslateX() <= 760)
            View.borutoChar.setTranslateX(View.borutoChar.getTranslateX() + 10);
        else if (key == 'A' && View.borutoChar.getTranslateX() >= 0)
            View.borutoChar.setTranslateX(View.borutoChar.getTranslateX() - 10);
    }

    public void trainPressed() {

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
