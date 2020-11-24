package org.minh.controller;

import org.minh.model.Clues;
import org.minh.model.ModelImpl;
import java.util.Random;

public class ControllerImpl implements Controller {

  private ModelImpl model;

  public ControllerImpl(ModelImpl model) {
    this.model = model;
  }

  @Override
  public Clues getClues() {
    return model.getCurrentPuzzle().getClue();
  }

  @Override
  public boolean isSolved() {
    return this.model.isSolved();
  }

  @Override
  public boolean isShaded(int row, int col) {
    return this.model.isShaded(row, col);
  }

  @Override
  public boolean isEliminated(int row, int col) {
    return this.model.isEliminated(row, col);
  }

  @Override
  public void toggleShaded(int row, int col) {
    this.model.toggleCellShaded(row, col);
  }

  @Override
  public void toggleEliminated(int row, int col) {
    this.model.toggleCellEliminated(row, col);
  }

  @Override
  public void nextPuzzle() {
    this.model.setPuzzleIndex(model.getPuzzleIndex() + 1);
  }

  @Override
  public void prevPuzzle() {
    this.model.setPuzzleIndex(model.getPuzzleIndex() - 1);
  }

  @Override
  public void randPuzzle() {
    Random random = new Random();
    int rand = random.nextInt(getPuzzleCount() + 1);
    while (rand == this.model.getPuzzleIndex()
        || rand <= 0
        || rand >= this.model.getPuzzleCount()) {
      rand = random.nextInt(getPuzzleCount() + 1);
    }
    this.model.setPuzzleIndex(rand);
  }

  @Override
  public void clearBoard() {
    this.model.clear();
  }

  @Override
  public int getPuzzleIndex() {
    return this.model.getPuzzleIndex();
  }

  @Override
  public int getPuzzleCount() {
    return this.model.getPuzzleCount();
  }
}
