package world.ucode.model;

import javafx.animation.AnimationTimer;
import world.ucode.view.View;

class GameLogicData {
  public static AnimationTimer update;
  public static int health = 50;
  public static int happiness = 50;
  public static int hunger = 50;
  public static int thirst = 50;
  public static int cleanliness = 50;
  public static double progressBar = 50;
}

public class Model {
  public static boolean scale = true;
  private static final AnimationTimer update =
      new AnimationTimer() {
        @Override
        public void handle(long now) {
          if (!View.borutoChar.stayStatus) View.borutoChar.borutoStand();
        }
      };

  public void canBorutoMove(char key) {
    if (key == 'W' && View.borutoChar.getTranslateY() >= 333) {
      if (View.borutoChar.stayStatus) View.borutoChar.borutoRuns();
      View.borutoChar.setTranslateY(View.borutoChar.getTranslateY() - 7);
    } else if (key == 'S' && View.borutoChar.getTranslateY() <= 388) {
      if (View.borutoChar.stayStatus) View.borutoChar.borutoRuns();
      View.borutoChar.setTranslateY(View.borutoChar.getTranslateY() + 7);
    } else if (key == 'D' && View.borutoChar.getTranslateX() <= 760) {
      if (View.borutoChar.stayStatus) View.borutoChar.borutoRuns();
      View.borutoChar.setTranslateX(View.borutoChar.getTranslateX() + 13);
      scale = true;
    } else if (key == 'A' && View.borutoChar.getTranslateX() >= 0) {
      if (View.borutoChar.stayStatus) View.borutoChar.borutoRuns();
      View.borutoChar.setTranslateX(View.borutoChar.getTranslateX() - 13);
      scale = false;
    } else if (!View.borutoChar.stayStatus) View.borutoChar.borutoStand();
  }

  public static void trainPressed() {
    GameLogicData.progressBar += 5;
  }

  public void feedPressed() {
    GameLogicData.progressBar -= 5;
  }

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
    if (data.equals("Grisha")) return 1;
    else return 0;
  }

  public int loadInputData(String data) {
    if (data.equals("Oleg")) return 0;
    else return 1;
  }
}
