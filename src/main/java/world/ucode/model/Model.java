package world.ucode.model;

import world.ucode.Main;
import world.ucode.view.View;

import java.util.ArrayDeque;


public class Model {
  private final Database database;
  public static ArrayDeque<String> lvls = new ArrayDeque<>();
  public static double health = 0.5;
  public static double happiness = 0.5;
  public static double hunger = 0.5;
  public static double thirst = 0.5;
  public static double cleanliness = 0.5;
  public static double progressBar = 0.5;
  public static double currentX;
  public static double currentY;

  public Model() {
    this.database = new Database();
    lvlsCreator();
  }

  private void lvlsCreator() {
    lvls.push("HOKAGE");
    lvls.push("JONIN");
    lvls.push("CHUNIN");
    lvls.push("GENIN");
    lvls.push("STUDENT");
  }

  public void canBorutoMove(char key) {
    if (key == 'W' && View.borutoChar.getTranslateY() >= 333) {
      if (View.borutoChar.stayStatus) View.borutoChar.borutoRuns();
      currentY = View.borutoChar.getTranslateY() - 7;
      View.borutoChar.setTranslateY(currentY);
    } else if (key == 'S' && View.borutoChar.getTranslateY() <= 388) {
      if (View.borutoChar.stayStatus) View.borutoChar.borutoRuns();
      currentY = View.borutoChar.getTranslateY() + 7;
      View.borutoChar.setTranslateY(currentY);
    } else if (key == 'D' && View.borutoChar.getTranslateX() <= 760) {
      if (View.borutoChar.stayStatus) View.borutoChar.borutoRuns();
      currentX = View.borutoChar.getTranslateX() + 13;
      View.borutoChar.setScaleX(1);
      View.borutoChar.setTranslateX(currentX);
    } else if (key == 'A' && View.borutoChar.getTranslateX() >= 0) {
      if (View.borutoChar.stayStatus) View.borutoChar.borutoRuns();
      currentX = View.borutoChar.getTranslateX() - 13;
      View.borutoChar.setScaleX(-1);
      View.borutoChar.setTranslateX(currentX);
    }
  }

  public void trainPressed() {
    if (progressBar <= 1)
      progressBar += 0.1;
  }

  public void checkLvl() {
    if (lvlUp() && !lvls.getFirst().equals("KAGE")) {
      lvls.addLast(lvls.getFirst());
      lvls.removeFirst();
      Main.CtrlGame.currentLvl.setText(lvls.getFirst());
      progressBar = 0.1;
      Main.CtrlGame.progressBar.setProgress(0.1);
    }
    else if (lvlDown() && !lvls.getFirst().equals("STUDENT")) {
      lvls.addFirst(lvls.getLast());
      lvls.removeLast();
      Main.CtrlGame.currentLvl.setText(lvls.getFirst());
      progressBar = 0.99;
      Main.CtrlGame.progressBar.setProgress(0.99);
    }
  }

  private boolean lvlDown() {
    return progressBar == 0;
  }

  private boolean lvlUp() {
    return progressBar >= 1;
  }

  public void feedPressed() {
    if (hunger <= 1)
      hunger += 0.1;
  }

  public void waterPressed() {
    if (thirst <= 1)
      thirst += 0.1;
  }

  public void medicPressed() {
    if (health <= 1)
      health += 0.1;
  }

  public void cleanPressed() {
    if (cleanliness <= 1)
      cleanliness += 0.1;
  }

  public int newInputData(String data) {
    if (database.newGame(data)) return 1;
    else return 0;
  }

  public int loadInputData(String data) {
    if (database.loadGame(data)) return 1;
    else return 0;
  }
}
