package org.minh.model;

import java.util.ArrayList;
import java.util.List;

public class ModelImpl implements Model {

  private List<ModelObserver> modelObserverList;
  private int currentIndex;
  private List<org.minh.model.Puzzle> puzzleList;

  public ModelImpl(List<Clues> clues) {
    this.currentIndex = 0;
    this.modelObserverList = new ArrayList<>();
    this.puzzleList = new ArrayList<>();
    for (Clues c : clues) {
      org.minh.model.Puzzle p = new org.minh.model.Puzzle(c);
      puzzleList.add(p);
    }
  }

  // Model
  @Override
  public int getPuzzleCount() {
    return this.puzzleList.size();
  }

  @Override
  public int getPuzzleIndex() {
    return this.currentIndex;
  }

  @Override
  public void setPuzzleIndex(int index) {
    if (index >= 0 && index < getPuzzleCount()) {
      this.currentIndex = index;
      notifyObservers();
    }
  }

  @Override
  public void addObserver(ModelObserver observer) {
    modelObserverList.add(observer);
  }

  @Override
  public void removeObserver(ModelObserver observer) {
    modelObserverList.remove(observer);
  }

  // Board
  @Override
  public boolean isSolved() {
    return this.puzzleList.get(currentIndex).isSolved();
  }

  @Override
  public boolean isShaded(int row, int col) {
    return this.puzzleList.get(currentIndex).getBoard().isShaded(row, col);
  }

  @Override
  public boolean isEliminated(int row, int col) {
    return this.puzzleList.get(currentIndex).getBoard().isEliminated(row, col);
  }

  @Override
  public boolean isSpace(int row, int col) {
    return this.puzzleList.get(currentIndex).getBoard().isSpace(row, col);
  }

  @Override
  public void toggleCellShaded(int row, int col) {
    this.puzzleList.get(currentIndex).getBoard().toggleCellShaded(row, col);
    notifyObservers();
  }

  @Override
  public void toggleCellEliminated(int row, int col) {
    this.puzzleList.get(currentIndex).getBoard().toggleCellEliminated(row, col);
    notifyObservers();
  }

  @Override
  public void clear() {
    this.puzzleList.get(currentIndex).getBoard().clear();
    notifyObservers();
  }

  // Clues
  @Override
  public int getWidth() {
    return this.puzzleList.get(currentIndex).getClue().getWidth();
  }

  @Override
  public int getHeight() {
    return this.puzzleList.get(currentIndex).getClue().getHeight();
  }

  @Override
  public int[] getRowClues(int index) {
    return this.puzzleList.get(currentIndex).getClue().getRowClues(index);
  }

  @Override
  public int[] getColClues(int index) {
    return this.puzzleList.get(currentIndex).getClue().getColClues(index);
  }

  @Override
  public int getRowCluesLength() {
    return this.puzzleList.get(currentIndex).getClue().getRowCluesLength();
  }

  @Override
  public int getColCluesLength() {
    return this.puzzleList.get(currentIndex).getClue().getColCluesLength();
  }

  public org.minh.model.Puzzle getCurrentPuzzle() {
    return this.puzzleList.get(currentIndex);
  }

  private void notifyObservers() {
    for (ModelObserver mo : this.modelObserverList) {
      mo.update(this);
    }
  }
}


