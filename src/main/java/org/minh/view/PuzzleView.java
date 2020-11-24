package org.minh.view;

import org.minh.controller.ControllerImpl;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class PuzzleView implements FXComponent {

  private ControllerImpl controller;

  public PuzzleView(ControllerImpl controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {
    org.minh.view.BoardView board = new org.minh.view.BoardView(controller);
    ClueHorizontalView horizontalClues = new ClueHorizontalView(controller);
    ClueVerticalView verticalClues = new ClueVerticalView(controller);
    ControllerView controllerView = new ControllerView(controller);

    GridPane grid = new GridPane();
    grid.setAlignment(Pos.CENTER);
    grid.setVgap(2);
    grid.setHgap(2);
    grid.add(horizontalClues.render(), 1, 0, 1, 1);
    grid.add(verticalClues.render(), 0, 1, 1, 1);
    grid.add(board.render(), 1, 1, 1, 1);

    BorderPane borderPane = new BorderPane();
    borderPane.setCenter(grid);
    borderPane.setRight(controllerView.render());
    borderPane.setPadding(new Insets(10, 200, 10, 10));

    return borderPane;
  }
}
