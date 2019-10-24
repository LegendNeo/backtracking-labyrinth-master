package de.ur.adp.backtracking.labyrinth;


import org.junit.Test;

import java.util.Arrays;
import java.util.Random;


public class LabyrinthTest {

  private static final Random RANDOM = new Random();
  private static final char NODES[] = "ABCDEFGHIJKLM".toCharArray();

  @Test
  public void solveLabyrinth() {

    LabyrinthSolver labyrinth = new StudentsLaybrinthSolver();

    char from = 'a'; //NODES[RANDOM.nextInt(NODES.length)];
    char to = 'M'; //NODES[RANDOM.nextInt(NODES.length)];

    // all routes are valid
    char[] routeNodes = labyrinth.solve(from, to);

    System.out.printf("Route from %s to %s: %s", from, to, Arrays.toString(routeNodes));

  }

  @Test
  public void charToIntAndBack() {
    // char('A') -> int('A');
    int a = (int) 'A'; // 65

    System.out.printf("int(A) = %d%n", a); // A = 65
    System.out.printf("int(A, 0) = %d%n", a - a); // A = 0

    // Wenn bei A begonnen werden soll zu zählen (a hat somit den Wert 0), muss jeweils der Wert von A von allen
    // anderen chars abgezogen werden. Intern wird char als int gespeichert. Die Zuordnung wird über die ASCII Tabelle
    // bestimmt: http://www.asciitable.com/
    // ACHTUNG: Groß- und Kleinbuchstaben haben unterschiedliche Werte

    // char('D') -> int('D');
    int d = (int) 'D';
    System.out.printf("int(D) = %d%n", d); // D = 68
    System.out.printf("int(D, 0) = %d%n", d - a); // D = 3


    // int('A') -> char('A');
    char aAsChar = (char) (0 + a);
    System.out.printf("char(0 + 65) = %s%n", aAsChar); // 0 + 65 = A

    // int('D') -> char('D');
    char dAsChar = (char) (3 + a);
    System.out.printf("char(3 + 65) = %s%n", dAsChar); // 3 + 65 = D

  }

}