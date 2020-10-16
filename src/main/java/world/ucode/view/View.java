package world.ucode.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import world.ucode.Main;

public class View {
    public static BorutoChar borutoChar = new BorutoChar();
    static Cakra cakra = new Cakra();
    Stage mainStage;
    Pane newRoot;
    static Pane gameRoot;
    Pane overRoot;
    Scene newScene;
    public static Scene gameScene;
    Scene overScene;
    int x,y;

    public View(Stage stage) throws Exception {
        mainStage = stage;
        x = 1001;
        y = 562;

        newCreator();
    }

    public void newCreator() throws Exception {
        newRoot = FXMLLoader.load(getClass().getResource("/newGame.fxml"));
        newScene = new Scene(newRoot, x, y);
        mainStage.setScene(newScene);
        mainStage.show();
    }

    public void gameCreator() throws Exception {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("/gamePlay.fxml"));
        gameRoot = loader.load(getClass().getResourceAsStream("/gamePlay.fxml"));
        gameRoot.getChildren().add(borutoChar);
        gameScene = new Scene(gameRoot, 800, 600);
        Main.CtrlGame = loader.getController();
        Main.CtrlGame.update();
        mainStage.setScene(gameScene);
        mainStage.show();
    }

    public static void trainCreator() {
        gameRoot.getChildren().add(cakra);
        cakra.setCakra();
    }
}
