package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.homework.sandbox.Point;

/**
 * Created by Zakhidat on 20.02.2017.
 */
public class PointTest {
  //Тесты проходят
  @Test
  public void distance(){
    Point p1 = new  Point(11.22, 1.99);
    Point p2 = new Point( 22.0, 999.0);
    Assert.assertEquals(Point.distance(p1, p2),997.068276749391);

  }
  @Test
  public void distance1(){
    Point p1 = new  Point(1, 2);
    Point p2 = new Point (2, 1);
    //assert Point.distance(p1,p2)==1306.59;
    Assert.assertEquals(Point.distance(p1, p2),1.4142135623730951);

  }
  @Test
  public void distance2() {
    Point p1 = new Point(22, 22);
    Point p2 = new Point(22, 22);
    //assert Point.distance(p1,p2)==1306.59;
    Assert.assertEquals(Point.distance(p1, p2), 0.0);
  }

    @Test
    public void distance3(){
      Point p1 = new  Point(22, 22);
      Point p2 = new Point (-22, 22);
      //assert Point.distance(p1,p2)==1306.59;
      Assert.assertEquals(Point.distance(p1, p2),44.0);

  }
  @Test
  public void distance4(){
    Point p1 = new  Point(0, 0);
    Point p2 = new Point (1, 0);
    //assert Point.distance(p1,p2)==1306.59;
    Assert.assertEquals(Point.distance(p1, p2),1.0);

  }
  //Тест падает
  @Test
  public void distance5(){
    Point p1 = new  Point(0, 0);
    Point p2 = new Point (1, 0);
    //assert Point.distance(p1,p2)==1306.59;
    Assert.assertEquals(Point.distance(p1, p2),1);

  }
}
