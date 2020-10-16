package world.ucode.model;

import world.ucode.view.View;

class GameLogicData {
  public enum lvls {STUDENT, GENIN, CHUNIN, JONIN, KAGE};
  public lvls lvl = lvls.STUDENT;
  public static int health = 50;
  public static int happiness = 50;
  public static int hunger = 50;
  public static int thirst = 50;
  public static int cleanliness = 50;
  public static double progressBar = 50;
  public static double currentX;
  public static double currentY;
}

public class Model {
  public void canBorutoMove(char key) {
    if (key == 'W' && View.borutoChar.getTranslateY() >= 333) {
      if (View.borutoChar.stayStatus) View.borutoChar.borutoRuns();
      GameLogicData.currentY = View.borutoChar.getTranslateY() - 7;
      View.borutoChar.setTranslateY(GameLogicData.currentY);
    } else if (key == 'S' && View.borutoChar.getTranslateY() <= 388) {
      if (View.borutoChar.stayStatus) View.borutoChar.borutoRuns();
      GameLogicData.currentY = View.borutoChar.getTranslateY() + 7;
      View.borutoChar.setTranslateY(GameLogicData.currentY);
    } else if (key == 'D' && View.borutoChar.getTranslateX() <= 760) {
      if (View.borutoChar.stayStatus) View.borutoChar.borutoRuns();
      GameLogicData.currentX = View.borutoChar.getTranslateX() + 13;
      View.borutoChar.setScaleX(1);
      View.borutoChar.setTranslateX(GameLogicData.currentX);
    } else if (key == 'A' && View.borutoChar.getTranslateX() >= 0) {
      if (View.borutoChar.stayStatus) View.borutoChar.borutoRuns();
      GameLogicData.currentX = View.borutoChar.getTranslateX() - 13;
      View.borutoChar.setScaleX(-1);
      View.borutoChar.setTranslateX(GameLogicData.currentX);
    }
  }

  public static void trainPressed() {
//    View.trainCreator();
    GameLogicData.progressBar += 5;
  }

//  private void checkLVL() {
//    if (lvlUP())
//      GameLogicData.lvl = GameLogicData.lvls.GENIN;
//  }
//
//  private boolean lvlDOWN() {
//    return GameLogicData.progressBar <= 0;
//  }
//
//  private boolean lvlUP() {
//    return GameLogicData.progressBar >= 100;
//  }

//  public void feedPressed() {
//    GameLogicData.progressBar -= 5;
//  }

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
