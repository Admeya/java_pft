package ru.jft.firstProgram;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Home on 15.04.2016.
 */
public class TestSquare {

  @Test
  public void testArea(){
    Square s = new Square(5);

    Assert.assertEquals(s.area(),25.0);
  }
}
