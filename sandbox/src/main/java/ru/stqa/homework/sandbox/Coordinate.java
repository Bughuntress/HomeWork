package ru.stqa.homework.sandbox;

/**
 * Created by Zakhidat on 18.02.2017.
 */
public class Coordinate {
    public static void main(String[] args){
      Point p1 = new Point(8,2);
      Point p2 = new Point(22,3);
    System.out.println("Расстояние между координатами x, равные (" + p1.x +";"+p1.y+") и координатой у, равной ("+ p2.x+";"+p2.y+") равно "+distance(p1, p2));

  }
  public static double distance(Point p1, Point p2){
    return Math.sqrt(Math.sqrt(p2.x-p1.x)+Math.sqrt(p2.y-p1.y));
  }
}
