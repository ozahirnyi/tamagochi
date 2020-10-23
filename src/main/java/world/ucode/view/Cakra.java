package world.ucode.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class Cakra extends Pane {
    public int tokenValue = 5;
    static ImageView cakraToken = new ImageView(new Image(
            View.class.getResourceAsStream("/train/cakra.png")));
    public Text tokenCount = new Text();


    Cakra() {
        setCakraToken();
        this.getChildren().add(cakraToken);
        this.getChildren().add(tokenCount);
    }

    public void setCakraToken() {
        this.setScaleY(0.77);
        this.setScaleX(0.77);
        this.setTranslateX(10);
        this.setTranslateY(15);

        setTokenValue(tokenValue);
        this.tokenCount.setScaleX(1.5);
        this.tokenCount.setScaleY(1.5);
        this.tokenCount.setTranslateX(80);
        this.tokenCount.setTranslateY(38);
    }

    public void setTokenValue(int value) {
        this.tokenValue = value;
        System.out.println("CURRENT TOKEN: " + this.tokenValue);
        this.tokenCount.setText("x " + tokenValue);
    }
}
