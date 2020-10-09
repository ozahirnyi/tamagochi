package world.ucode.model;

import world.ucode.Main;
import world.ucode.view.View;

class GameLogicData {
    static public int health = 50;
    static public int happiness = 50;
    static public int hunger = 50;
    static public int thirst = 50;
    static public int cleanliness = 50;
    static public double progressBar = 50;
}

public class Model {
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

//    public void trainPressed() {
////        GameLogicData.progressBar += 5;
//        Main.Ctrl.progressBar.setProgress(Main.Ctrl.progressBar.getProgress() + 0.1);
//    }
//
//    public void feedPressed() {
////        GameLogicData.progressBar -= 5;
//        Main.Ctrl.progressBar.setProgress(Main.Ctrl.progressBar.getProgress() - 0.1);
////        Main.Ctrl.progressBar.setProgress(GameLogicData.progressBar);
//    }

    public void waterPressed() {
        System.out.println("Water Pressed!");
    }

    public void medicPressed() {
        System.out.println("Medic Pressed!");
    }

    public void cleanPressed() {
        System.out.println("Clean Pressed!");
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
