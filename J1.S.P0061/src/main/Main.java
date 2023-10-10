package main;

import logic.Circle;

/**
 *
 * @author Quang
 */
public class Main {

    public static void main(String[] args) {
        Circle circle = new Circle(
                validate.Validate.getDouble(
                        "Please input radius of Circle: ",
                        "Number must be positive number.",
                        "Invalid input. Please enter positive number.",
                        0.0001, Double.MAX_VALUE
                )
        );
        
        circle.printResult();
    }
}
