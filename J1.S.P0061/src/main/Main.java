package main;

import entity.Circle;
import entity.Shape;

/**
 *
 * @author Quang
 */
public class Main {

    public static void main(String[] args) {
        Shape shape = new Circle(
                validate.Validate.getDouble(
                        "Please input radius of Circle: ",
                        "Number must be positive number.",
                        "Invalid input. Please enter positive number.",
                        0.0001, Double.MAX_VALUE
                )
        );
        
        shape.printResult();
    }
}
