package io.renren.modules.car;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(final String[] args) {

    // create scanner for data input
    final Scanner input = new Scanner(System.in);

    // TODO read row and column for the starting point
    final int startRow = input.nextInt();
    final int startCol = input.nextInt();

    // TODO read maze data as rows
    final List<String> rawData = new ArrayList<>();
    rawData.add("**********");
    rawData.add("*.....****");
    rawData.add("*.***...**");
    rawData.add("*.***.****");
    rawData.add("*.**....**");
    rawData.add("*.**.**.**");
    rawData.add("*....**...");
    rawData.add("***.******");
    rawData.add("*........*");
    rawData.add("**********");

    // attempt to solve the maze and print the result
    final Maze maze = new Maze(rawData);
    maze.print(System.out);
    final boolean result = maze.solve(startRow, startCol);
    maze.print(System.out);
    System.out.println();
    System.out.println(result ? "We're so out of here!" : "Bummer, we're stuck...");
  }
}
