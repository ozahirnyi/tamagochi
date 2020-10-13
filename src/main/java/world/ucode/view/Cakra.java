package world.ucode.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Cakra extends Pane {
    static ImageView cakra = new ImageView(new Image(
            View.class.getResourceAsStream("/train/cakra.png")));

    Cakra() {
        setCakra();
        this.getChildren().add(cakra);
    }

    public void setCakra() {
        double random = Math.random() * 300;

        this.setTranslateX(100 + random);
        this.setTranslateY(150);
    }
}
