package ru.jft.secondProgram;

import java.util.Scanner;

/**
 * Created by Home on 09.04.2016.
 */
public class PointImpl {

  public static double distance(Point p1, Point p2) {
    return Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2));
  }

  public static void main(String[] args) {

    int x1, y1, x2, y2;

    Scanner sc = new Scanner(System.in);
    System.out.println("Введите координаты первой точки:");
    System.out.print("x1 = ");
    x1 = Integer.parseInt(sc.nextLine());
    System.out.print("y1 = ");
    y1 = Integer.parseInt(sc.nextLine());

    System.out.println("Введите координаты второй точки:");
    System.out.print("x2 = ");
    x2 = Integer.parseInt(sc.nextLine());
    System.out.print("y2 = ");
    y2 = Integer.parseInt(sc.nextLine());


    Point p1 = new Point(x1, y1);
    Point p2 = new Point(x2, y2);

    System.out.println("Вы ввели координаты:");
    System.out.println("x1 = " + p1.x + " y1 = " + p1.y);
    System.out.println("x2 = " + p2.x + " y2 = " + p2.y);
    System.out.println();
    System.out.println("Расстояние между двумя точками на плоскости с использованием функции distance(p1, p2): " + distance(p1, p2));
    System.out.println("Расстояние между двумя точками на плоскости с использованием метода p1.distance(p2): " + p1.distance(p2));

  }
}
