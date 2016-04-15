package ru.jft.firstProgram;

/**
 * Created by Home on 15.04.2016.
 */
public class Square {

  private double l;

  public double getL() {
    return l;
  }

  public void setL(double l) {
    this.l = l;
  }

  public double area(){
    return this.l*this.l;
  }

  Square (double l){
    setL(l);
  }
}
