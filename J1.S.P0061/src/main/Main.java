package main;

import entity.Circle;
import entity.Rectangle;
import entity.Shape;
import entity.Triangle;

/**
 *
 * @author Quang
 */
public class Main {

    public static void main(String[] args) {
        Shape rectangle = new Rectangle();
        Shape circle = new Circle();
        Shape triangle = new Triangle();
        
        rectangle.input();
        circle.input();
        triangle.input();
        
        rectangle.printResult();
        circle.printResult();
        triangle.printResult();
    }
}
