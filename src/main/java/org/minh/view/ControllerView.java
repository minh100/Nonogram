package org.minh.view;

import org.minh.controller.ControllerImpl;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class ControllerView implements FXComponent {

  private ControllerImpl controller;

  public ControllerView(ControllerImpl controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {
    GridPane gridPane = new GridPane();
    gridPane.setAlignment(Pos.CENTER_RIGHT);
    gridPane.setHgap(15);

    Button prev = new Button("Prev");
    prev.setStyle("-fx-font-size: 14px");
    prev.setOnMouseClicked(
        new EventHandler<MouseEvent>() {
          @Override
          public void handle(MouseEvent mouseEvent) {
            if (mouseEvent.getButton() == MouseButton.PRIMARY) {
              controller.prevPuzzle();
            }
          }
        });

    Button next = new Button("Next");
    next.setStyle("-fx-font-size: 14px");
    next.setOnMouseClicked(
        new EventHandler<MouseEvent>() {
          @Override
          public void handle(MouseEvent mouseEvent) {
            if (mouseEvent.getButton() == MouseButton.PRIMARY) {
              controller.nextPuzzle();
            }
          }
        });

    Button clear = new Button("Clear");
    clear.setStyle("-fx-font-size: 14px");
    clear.setOnMouseClicked(
        new EventHandler<MouseEvent>() {
          @Override
          public void handle(MouseEvent mouseEvent) {
            if (mouseEvent.getButton() == MouseButton.PRIMARY) {
              controller.clearBoard();
            }
          }
        });

    Button random = new Button("Random");
    random.setStyle("-fx-font-size: 14px");
    random.setOnMouseClicked(
        new EventHandler<MouseEvent>() {
          @Override
          public void handle(MouseEvent mouseEvent) {
            if (mouseEvent.getButton() == MouseButton.PRIMARY) {
              controller.randPuzzle();
            }
          }
        });

    String currIndex =
        "Puzzle: " + (controller.getPuzzleIndex() + 1) + "/" + controller.getPuzzleCount();
    Label label = new Label(currIndex);
    label.setStyle("-fx-font-size: 18px");

    gridPane.add(prev, 0, 10, 1, 1);
    gridPane.add(next, 4, 10, 1, 1);
    gridPane.add(label, 2, 0, 1, 1);
    gridPane.add(clear, 0, 11, 1, 1);
    gridPane.add(random, 4, 11, 1, 1);

    return gridPane;
  }
}
