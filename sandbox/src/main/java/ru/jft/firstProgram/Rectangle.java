package ru.jft.firstProgram;

/**
 * Created by Home on 15.04.2016.
 */
public class Rectangle {

  private double a;
  private double b;

  public double getA() {
    return a;
  }

  public double getB() {
    return b;
  }

  public void setA(double a) {
    this.a = a;
  }

  public void setB(double b) {
    this.b = b;
  }

  public double area(){
    return (getA()+getB())*2;
  }

  Rectangle(double a, double b){
    setA(a);
    setB(b);
  }

}
