package org.minh.model;

public class BoardImpl implements org.minh.model.Board {

  private Clues clue;
  private int array[][];

  public BoardImpl(Clues clues) {
    this.clue = clues;
    this.array = new int[clue.getHeight()][clue.getWidth()];
  }

  @Override
  public boolean isShaded(int row, int col) {
    if (row < 0 || row >= clue.getHeight() || col < 0 || col >= clue.getWidth()) {
      throw new RuntimeException();
    } else {
      return this.array[row][col] == 1;
    }
  }

  @Override
  public boolean isEliminated(int row, int col) {

    if (row < 0 || row >= clue.getHeight() || col < 0 || col >= clue.getWidth()) {
      throw new RuntimeException();
    } else {
      return this.array[row][col] == 2;
    }
  }

  @Override
  public boolean isSpace(int row, int col) {
    if (row < 0 || row >= clue.getHeight() || col < 0 || col >= clue.getWidth()) {
      throw new RuntimeException();
    }
    return this.array[row][col] == 0;
  }

  @Override
  public void toggleCellShaded(int row, int col) {
    if (row < 0 || row >= clue.getHeight() || col < 0 || col >= clue.getWidth()) {
      throw new RuntimeException();
    } else {
      if (isSpace(row, col)) {
        this.array[row][col] = 1;
      } else if (isShaded(row, col)) {
        this.array[row][col] = 0;
      }
    }
  }

  @Override
  public void toggleCellEliminated(int row, int col) {

    if (row < 0 || row >= clue.getHeight() || col < 0 || col >= clue.getWidth()) {
      throw new RuntimeException();
    } else {
      if (isSpace(row, col)) {
        this.array[row][col] = 2;
      } else if (isEliminated(row, col)) {
        this.array[row][col] = 0;
      }
    }
  }

  @Override
  public void clear() {
    for (int row = 0; row < clue.getHeight(); row++) {
      for (int col = 0; col < clue.getWidth(); col++) {
        this.array[row][col] = 0;
      }
    }
  }
}
