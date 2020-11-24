package org.minh.view;

import org.minh.PuzzleLibrary;
import org.minh.controller.ControllerImpl;
import org.minh.model.Clues;
import org.minh.model.Model;
import org.minh.model.ModelImpl;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppLauncher extends Application {

  @Override
  public void start(Stage stage) {

    List<Clues> list = PuzzleLibrary.create();
    ModelImpl model = new ModelImpl(list);

    // Controller
    ControllerImpl controller = new ControllerImpl(model);

    // View
    org.minh.view.PuzzleView puzzleView = new org.minh.view.PuzzleView(controller);

    stage.setTitle("Nonogram");

    Scene scene = new Scene(puzzleView.render(), 1000, 1000);

    stage.setScene(scene);

    model.addObserver(
        (Model m) -> {
          scene.setRoot(puzzleView.render());
        });

    stage.setMaximized(true);
    stage.show();
  }
}
