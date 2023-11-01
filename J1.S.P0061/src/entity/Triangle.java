package entity;

import validate.Validate;

/**
 *
 * @author Quang
 */
public class Triangle extends Shape {

    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle() {
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public void setSideC(double sideC) {
        this.sideC = sideC;
    }

    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public double getArea() {
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

    @Override
    public void printResult() {
        System.out.println("-----Triangle-----");
        System.out.printf("Side A: %s\n"
                + "Side B: %s\n"
                + "Side C: %s\n"
                + "Area: %s\n"
                + "Perimeter: %s\n", sideA, sideB, sideC,
                getArea(), getPerimeter());
    }

    @Override
    public void input() {
        while (true) {
            sideA = Validate.getDouble("Enter side A of Triangle:", "Wrong",
                    "Enter again: ", 0, Double.MAX_VALUE);
            sideB = Validate.getDouble("Enter side B of Triangle:", "Wrong",
                    "Enter again: ", 0, Double.MAX_VALUE);
            sideC = Validate.getDouble("Enter side C of Triangle:", "Wrong",
                    "Enter again: ", 0, Double.MAX_VALUE);
            if (sideA + sideB > sideC
                    && sideA + sideC > sideB
                    && sideB + sideC > sideA) {
                break;
            } else {
                System.out.println("It not be triangle");
            }
        }
    }
}
