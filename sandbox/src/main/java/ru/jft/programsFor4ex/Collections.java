package ru.jft.programsFor4ex;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Home on 06.05.2016.
 */
public class Collections {
  public static void main(String[] args) {
    String[] langs = {"Java", "C#", "Python", "PHP"};

    List languages = Arrays.asList("Java", "C#", "Python", "PHP");

    for (Object l : languages){
      System.out.println("Я хочу выучить " + l);
    }

  }
}
