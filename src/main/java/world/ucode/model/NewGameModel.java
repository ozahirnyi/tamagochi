package world.ucode.model;

public class NewGameModel {
    public int newInputData(String data) {
        if (data.equals("Grisha"))
            return 1;
        else return 0;
    }

    public int loadInputData(String data) {
        if (data.equals("Oleg"))
            return 1;
        else return 0;
    }
}
