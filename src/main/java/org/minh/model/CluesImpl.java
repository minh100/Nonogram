package org.minh.model;

public class CluesImpl implements Clues {

  private int[][] row;
  private int[][] col;

  public CluesImpl(int[][] rowClues, int[][] colClues) {
    if (rowClues == null || colClues == null) {
      throw new NullPointerException();
    }
    this.row = rowClues;
    this.col = colClues;
  }

  @Override
  public int getWidth() {
    return this.col.length;
  }

  @Override
  public int getHeight() {
    return this.row.length;
  }

  @Override
  public int[] getRowClues(int index) {
    return this.row[index];
  }

  @Override
  public int[] getColClues(int index) {
    return this.col[index];
  }

  @Override
  public int getRowCluesLength() {
    return this.row[0].length;
  }

  @Override
  public int getColCluesLength() {
    return this.col[0].length;
  }
}
