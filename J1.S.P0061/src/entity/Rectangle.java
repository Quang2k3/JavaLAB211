package entity;

import validate.Validate;

/**
 *
 * @author Quang
 */
public class Rectangle extends Shape {

    private double width;
    private double length;

    public Rectangle() {
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + length);
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public void printResult() {
        System.out.println("Width: " + width);
        System.out.println("Length: " + length);
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
    }

    @Override
    public void input() {
        while (true) {            
            width = Validate.getDouble("Please input size width of Rectangle: ", 
                    "Wrong", "Enter again: ", 0, Double.MAX_VALUE);
            length = Validate.getDouble("Please input length of Rectangle: ", 
                    "Wrong", "Enter again: ", 0, Double.MAX_VALUE);
            if (width > length) {
                System.out.println("Width cannot greater than length.");
            } else {
                break;
            }
        }
    }
}
