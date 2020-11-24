package org.minh.view;

import org.minh.controller.ControllerImpl;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ClueHorizontalView implements FXComponent {

  private ControllerImpl controller;

  public ClueHorizontalView(ControllerImpl controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {
    GridPane grid = new GridPane();
    grid.setHgap(3);
    grid.setVgap(1.5);

    for (int row = 0; row < controller.getClues().getColCluesLength(); row++) {
      for (int col = 0; col < controller.getClues().getWidth(); col++) {
        StackPane stackPane = new StackPane();

        Rectangle rectangle = new Rectangle(35, 35);
        rectangle.setFill(Color.WHEAT);

        String num = controller.getClues().getColClues(col)[row] + "";
        if (num.equals("0")) {
          num = "";
        }

        Label title = new Label(num);
        title.setTextFill(Color.web("#000000"));
        title.setStyle("-fx-font-size: 18px");

        stackPane.getChildren().addAll(rectangle);
        stackPane.getChildren().add(title);
        grid.add(stackPane, col, row, 1, 1);
      }
    }

    grid.setAlignment(Pos.CENTER);
    return grid;
  }
}
