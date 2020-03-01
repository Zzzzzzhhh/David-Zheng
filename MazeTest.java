package edu.luc.cs.cs271.mazesolver;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

public class MazeTest {

  public static void main(String[] args) {
    MazeTest mazeTest = new MazeTest();
    mazeTest.testMazeGeta();
  }

  @Test
  public void testMazeGeta() {
    final String[] data = {"***", "*..", "***"};
    final Maze sut = new Maze(data);
    assertEquals(Maze.EMPTY, sut.get(1, 1));
    assertEquals(Maze.WALL, sut.get(0, 0));
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void testMazeGetb() {
    final String[] data = {"***", "*..", "***"};
    final Maze sut = new Maze(data);
    sut.get(3, 4);
  }

  @Test
  public void testMaze1x1a() {
    final String[] data = {"*"};
    final Maze sut = new Maze(data);
    assertFalse(sut.solve(0, 0));
  }

  @Test
  public void testMaze1x1b() {
    final String[] data = {"."};
    final Maze sut = new Maze(data);
    assertTrue(sut.solve(0, 0));
  }

  @Test
  public void testMaze3x3a() {
    final String[] data = {"***", "*.*", "***"};
    final Maze sut = new Maze(data);
    assertFalse(sut.solve(1, 1));
  }

  @Test
  public void testMaze3x3b() {
    final String[] data = {"***", "*..", "***"};
    final Maze sut = new Maze(data);
    assertTrue(sut.solve(1, 1));
    assertEquals(Maze.VISITED, sut.get(1, 2));
  }

  // TODO add at least four tests:
  // one for maze1 and and one for a copy of maze1 but with the exit blocked
  // one for your own maze2,
  // which should have at least two exits and size 10x10 or larger,
  // and and one for a copy of maze2 but with all exits blocked


  @Test
  public void maze1(){
    final  String[] data = {"**********", "*.....****", "*.***...**","*.***.****","*.**....**","*.**.**.**","*....**...","***.******","*........*","**********"};
    final  Maze sut = new Maze(data);
    File file = new File("maze1.txt");
    if (!file.exists()){
      try {
        file.createNewFile();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    try {
      sut.print(new PrintStream(new FileOutputStream(file)));
      sut.solve(1,1);

      System.out.println("------------------------");
      sut.print(new PrintStream(new FileOutputStream(file,true)));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

  }

  @Test
  public void maze2(){
    final  String[] data = {"**********", "*.....****", "*.***...**","*.***.****","*.**....**","*.**.**.**","*....**..*","***.******","*........*","**********"};
    final  Maze sut = new Maze(data);
    File file = new File("maze2.txt");
    if (!file.exists()){
      try {
        file.createNewFile();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    try {
      sut.print(new PrintStream(new FileOutputStream(file)));
      sut.solve(1,1);

      System.out.println("------------------------");
      sut.print(new PrintStream(new FileOutputStream(file,true)));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

  }


  @Test
  public void maze3(){
    final  String[] data = {"**********", "*.....****", "*.*.*...**","*.***.*...","*.**....**","*.**.**.**","*....**...","***.*...**","*........*","**********"};
    final  Maze sut = new Maze(data);
    File file = new File("maze3.txt");
    if (!file.exists()){
      try {
        file.createNewFile();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    try {
      sut.print(new PrintStream(new FileOutputStream(file)));
      sut.solve(1,1);

      System.out.println("------------------------");
      sut.print(new PrintStream(new FileOutputStream(file,true)));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

  }


  @Test
  public void maze4(){
    final  String[] data = {"**********", "*.....****", "*.*.*...**","*.***.*..*","*.**....**","*.**.**.**","*....**..*","***.*...**","*........*","**********"};
    final  Maze sut = new Maze(data);
    File file = new File("maze4.txt");
    if (!file.exists()){
      try {
        file.createNewFile();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    try {
      sut.print(new PrintStream(new FileOutputStream(file)));
      sut.solve(1,1);

      System.out.println("------------------------");
      sut.print(new PrintStream(new FileOutputStream(file,true)));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

  }
}
