package world.ucode.view;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import java.util.ArrayDeque;

public class borutoChar {
    private final ArrayDeque<ImageView> imageViews;

    public borutoChar(ArrayDeque<ImageView> imageViews) {
        this.imageViews = imageViews;
        setImageViews();
    }

    private void setImageViews() {
        for (int i = 0; i < 5; i++) {
            ImageView imageView = new ImageView(new Image("chars/borutoStand/borutoStand" + i));
            imageViews.push(imageView);
        }
    }
}
