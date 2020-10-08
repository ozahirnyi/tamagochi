package world.ucode.view;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import java.util.ArrayDeque;

public class borutoChar extends Pane {
    private final ArrayDeque<ImageView> stand = new ArrayDeque<ImageView>();
    private final Timeline standLine = new Timeline();

    public borutoChar() {
        this.setTranslateX(100);
        this.setTranslateY(345);
        setImageViews();
        getChildren().add(stand.getFirst());
        borutoStand();
    }

    private void setImageViews() {
        for (int i = 0; i < 5; i++) {
            ImageView imageView = new ImageView(new Image(this.getClass().getResourceAsStream("/chars/boruto/borutoStand" + i + ".png")));
            imageView.setFitHeight(100);
            imageView.setFitWidth(50);
            stand.push(imageView);
        }
    }

    public void borutoStand() {
    standLine
        .getKeyFrames()
        .add(
            new KeyFrame(
                Duration.millis(500),
                new EventHandler<ActionEvent>() {
                  @Override
                  public void handle(ActionEvent actionEvent) {
                    getChildren().remove(stand.getFirst());
                    stand.addLast(stand.getFirst());
                    stand.removeFirst();
                    getChildren().add(stand.getFirst());
                  }
                }));
        standLine.setCycleCount(Timeline.INDEFINITE);
        standLine.play();
    }
}
