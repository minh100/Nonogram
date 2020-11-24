package org.minh.model;

public class Puzzle {

  private org.minh.model.BoardImpl board;
  private Clues clue;

  public Puzzle(Clues clue) {
    this.clue = clue;
    this.board = new org.minh.model.BoardImpl(clue);
  }

  public boolean isSolved() {
    for (int row = 0; row < this.clue.getHeight(); row++) {
      int count = 0;
      for (int col = 0; col < this.clue.getWidth(); col++) {
        if (this.board.isShaded(row, col)) {
          count++;
        }
      }
      int amt[] = this.clue.getRowClues(row);
      int sum = 0;
      for (int i : amt) {
        sum += i;
      }

      if (sum != count) {
        return false;
      }
    }

    for (int col = 0; col < this.clue.getWidth(); col++) {
      int count = 0;
      for (int row = 0; row < this.clue.getHeight(); row++) {
        if (this.board.isShaded(row, col)) {
          count++;
        }
      }

      int amt[] = this.clue.getColClues(col);
      int sum = 0;
      for (int i : amt) {
        sum += i;
      }

      if (sum != count) {
        return false;
      }
    }

    return true;
  }

  public org.minh.model.Board getBoard() {
    return board;
  }

  public Clues getClue() {
    return clue;
  }
}