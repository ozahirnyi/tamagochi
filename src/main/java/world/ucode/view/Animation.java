package world.ucode.view;

import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import java.util.ArrayDeque;

public class Animation extends Transition {
  private final ArrayDeque<ImageView> imageView;

  public Animation(ArrayDeque<ImageView> imageView, Duration duration) {
    this.imageView = imageView;
    setCycleDuration(duration);
    setInterpolator(Interpolator.LINEAR);
  }

  @Override
  protected void interpolate(double v) {

  }
}