package edu.luc.cs.cs271.mazesolver;

import java.io.PrintStream;
import java.util.List;

public class Maze {

  public static final char WALL = '*', EMPTY = '.', VISITED = '+', DEADEND = '-', START = '0';

  /** Representation of maze as a mutable char array. */
  private final char[][] mazeData;

  /**
   * Constructs a maze instance from a nonempty list of same-length strings. Each string represents
   * a row in the maze.
   *
   * @param rawData a nonempty list of same-length strings
   * @throws IllegalArgumentException if rawData is empty or some strings are longer than others
   */
  public Maze(final List<String> rawData) {
    this(rawData.toArray(new String[0]));
  }

  /**
   * Constructs a maze instance from a nonempty array of same-length strings. Each string represents
   * a row in the maze.
   *
   * @param rawData a nonempty array of same-length strings
   * @throws IllegalArgumentException if rawData is empty or some strings are longer than others
   */
  public Maze(final String[] rawData) {
    //  your job
    // make sure raw data is not empty
    if(rawData == null  && rawData.length == 0 ){
      throw new RuntimeException();
    }
    // initialize char array
    mazeData = new char[rawData[0].length()][rawData.length];
    // populate char array from raw data, checking consistent width in the process
    for (int i = 0; i < rawData.length; i++) {
      for (int j = 0; j < rawData[i].length(); j++) {
        mazeData[i][j] = rawData[i].charAt(j);
      }
    }

  }

  /**
   * Prints the maze to the given destination.
   *
   * @param output the output destination
   */
  public void print(final PrintStream output) {
    //  your job
    // print row by row
    for (int i = 0; i < mazeData.length; i++) {
      for (int j = 0; j < mazeData[i].length; j++) {
        System.out.print(mazeData[i][j] + "\t");
        output.print(mazeData[i][j] + "\t");
      }
      System.out.println();
      output.println();
    }
  }

  /**
   * Attempts to find a way out of this maze from the given starting position.
   *
   * @param row the row (y) index of the starting position
   * @param col the row (x) index of the starting position
   * @return whether or not there is a way out
   * @throws IllegalArgumentException if the starting position is outside the maze
   */
  public boolean solve(final int row, final int col) {
    //
    // validate arguments
    //
    //    // invoke recursive method starting at row and col
    //
    //    // mark starting position
    //
    //    // return result
    solve1(row,col);
    mazeData[row][col] = Maze.START;
    return true;
  }

  /** Looks for a way out of the maze from the current position using recursive backtracking. */
  protected boolean solve1(final int row, final int col) {
    //  your job
    // if we're not allowed to be here, then this is not a way out

    // otherwise mark this place as visited (drop a breadcrumb)

    // otherwise try each of our four neighbors (cardinal directions)


    if (mazeData[0].length -1 == col && mazeData[row][col] == Maze.EMPTY) {
      mazeData[row][col] = Maze.VISITED;
      return true;
    } else {
      if (mazeData[row][col] == Maze.EMPTY) {
        mazeData[row][col] = Maze.VISITED;
        if (solve1(row + 1, col)) {
          return true;
        } else if (solve1(row, col + 1)) {
          return true;
        } else if (solve1(row - 1, col)) {
          return true;
        } else if (solve1(row, col - 1)) {
          return true;
        } else {
          mazeData[row][col] = Maze.DEADEND;
          return false;
        }
      } else {
        return false;
      }
    }
  }

  /**
   * Returns the char at the given row and column. Mainly for testing.
   *
   * @param row the row
   * @param col the column
   * @return the char at the given row and column
   * @throws IndexOutOfBoundsException if the row or column are outside the valid range
   */
  public char get(final int row, final int col) {
    //  your job
    return mazeData[row][col];
  }
}