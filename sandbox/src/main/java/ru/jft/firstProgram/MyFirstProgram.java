package ru.jft.firstProgram;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("world");
    hello("user");
    hello("Irina");

    Square s = new Square(5);
    System.out.println("Площадь квадрата со стороной "+ s.getL() + " = " + s.area());

    Rectangle r = new Rectangle(4, 6);
    System.out.println("Площадь прямоугольника со сторонами " + r.getA() + " и " + r.getB() + " = " + r.area());

  }

  public static void hello (String s){
    System.out.println("Hello, " + s + "!");
  }

}