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
        Shape[] shapes = new Shape[3];
        shapes[0] = new Rectangle();
        shapes[1] = new Circle();
        shapes[2] = new Triangle();

        for (Shape shape : shapes) {
            shape.input();
            shape.printResult();
        }
    }
}
