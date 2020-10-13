package world.ucode.view;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import world.ucode.model.Model;

import java.util.ArrayDeque;

public class BorutoChar extends Pane {
  public boolean stayStatus = false;
  private final ArrayDeque<ImageView> stand = new ArrayDeque<>();
  private final ArrayDeque<ImageView> run = new ArrayDeque<>();
  private final Timeline standLine;
  private final Timeline runLine;

  public BorutoChar() {
    this.setTranslateX(100);
    this.setTranslateY(345);
    setImageViews();
    standLine = timeLineCreator(stand, 500);
    runLine = timeLineCreator(run, 200);
    borutoStand();
  }

  private void setImageViews() {
    for (int i = 0; i < 4; i++) {
      ImageView imageViewRun =
          new ImageView(
              new Image(
                  this.getClass()
                      .getResourceAsStream("/chars/boruto/borutoRuns/borutoRuns" + i + ".png")));
      imageViewRun.setFitHeight(80);
      imageViewRun.setFitWidth(100);
      run.push(imageViewRun);
    }
    for (int i = 0; i < 5; i++) {
      ImageView imageViewStand =
          new ImageView(
              new Image(
                  this.getClass().getResourceAsStream("/chars/boruto/borutoStand" + i + ".png")));
      imageViewStand.setFitHeight(100);
      imageViewStand.setFitWidth(50);
      stand.push(imageViewStand);
    }
  }

  public Timeline timeLineCreator(ArrayDeque<ImageView> arrayDeque, int duration) {
    Timeline timeline = new Timeline();

    timeline
        .getKeyFrames()
        .add(
            new KeyFrame(
                Duration.millis(duration),
                actionEvent -> {
                  if (!Model.scale) setScaleX(-1);
                  else setScaleX(1);
                  getChildren().remove(arrayDeque.getFirst());
                  arrayDeque.addLast(arrayDeque.getFirst());
                  arrayDeque.removeFirst();
                  getChildren().add(arrayDeque.getFirst());
                }));

    timeline.setCycleCount(Timeline.INDEFINITE);
    return timeline;
  }

  public void borutoRuns() {
    stayStatus = false;
    standLine.stop();
    getChildren().remove(stand.getFirst());
    getChildren().add(run.getFirst());
    runLine.play();
  }

  public void borutoStand() {
    stayStatus = true;
    runLine.stop();
    getChildren().remove(run.getFirst());
    getChildren().add(stand.getFirst());
    standLine.play();
  }
}
