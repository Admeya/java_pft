package ru.jft.secondProgram;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Home on 15.04.2016.
 */


public class TestPoint {

  @Test
  public void testDistance_function() {

    Point one = new Point(2, 4);
    Point two = new Point(1, 4);

    PointImpl dist = new PointImpl();
    double d1 = dist.distance(one, two);

    Assert.assertEquals(d1, 1.0);
  }

  @Test
  public void testDistance_function_negative() {

    Point one = new Point(2, 4);
    Point two = new Point(1, 4);

    PointImpl dist = new PointImpl();
    double d1 = dist.distance(one, two);

    Assert.assertEquals(d1,1);
  }

  @Test
  public void testDistance_method() {

    Point one = new Point(2, 4);
    Point two = new Point(1, 4);

    double d = one.distance(two);

    Assert.assertEquals(d,1.0);
  }

  @Test
  public void testDistance_negative() {

    Point one = new Point(2, 4);
    Point two = new Point(1, 4);

    double d = one.distance(two);

    Assert.assertEquals(d,2);
  }

}



