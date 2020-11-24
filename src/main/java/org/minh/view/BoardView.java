package org.minh.view;

import org.minh.controller.ControllerImpl;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BoardView implements FXComponent {

  private ControllerImpl controller;

  public BoardView(ControllerImpl controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {
    BorderPane borderPane = new BorderPane();
    borderPane.setPadding(new Insets(10, 10, 10, 10));
    GridPane grid = new GridPane();
    grid.setHgap(0.5);
    grid.setVgap(0.5);

    for (int row = 0; row < controller.getClues().getHeight(); row++) {
      for (int col = 0; col < controller.getClues().getWidth(); col++) {
        if (controller.isSolved()) {
          Label done = new Label("Good job you finished");
          done.setStyle("-fx-font-size: 15px");
          borderPane.setBottom(done);
        }
        Rectangle rectangle = new Rectangle(35, 35);
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(Color.WHITE);
        rectangle.setStyle("-fx-stroke-width: 2");
        int finalRow = row;
        int finalCol = col;

        rectangle.setOnMouseClicked(
            new EventHandler<MouseEvent>() {
              @Override
              public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton() == MouseButton.PRIMARY) {
                  if (controller.isEliminated(finalRow, finalCol)) {
                    controller.toggleEliminated(finalRow, finalCol);
                  }
                  controller.toggleShaded(finalRow, finalCol);

                } else if (mouseEvent.getButton() == MouseButton.SECONDARY) {
                  if (controller.isShaded(finalRow, finalCol)) {
                    controller.toggleShaded(finalRow, finalCol);
                  }
                  controller.toggleEliminated(finalRow, finalCol);
                }
              }
            });
        if (controller.isShaded(finalRow, finalCol)) {
          rectangle.setFill(Color.BLACK);
        } else if (controller.isEliminated(finalRow, finalCol)) {
          rectangle.setFill(Color.RED);
        } else {
          rectangle.setFill(Color.WHITE);
        }

        grid.add(rectangle, col, row, 1, 1);
      }
    }

    grid.setAlignment(Pos.CENTER);

    borderPane.setCenter(grid);

    return borderPane;
  }
}
