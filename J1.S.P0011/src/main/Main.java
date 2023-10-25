package main;

import constant.Constant;
import logic.Function;
import validate.Validate;

/**
 *
 * @author Quang
 */
public class Main {

    public static void main(String[] args) {
        Function function = new Function();
        int input;
        int output;
        String data = "";
        System.out.println("==== Convert System ====");
        System.out.println("Choose the base number input: ");
        System.out.println("1. Binary");
        System.out.println("2. Decimal");
        System.out.println("3. Hexadecimal");
        input = Validate.getInt(
                "Out of range, try again!",
                "Input value must digit, try again!",
                1, 3
        );

        System.out.println("Choose the base number out: ");

        output = Validate.getInt(
                "Out of range, try again!",
                "Input value must digit, try again!",
                1, 3
        );

        switch (input) {
            case 1:
                data = Validate.getString(
                        "Enter number binary: ", 
                        "Must be enter 0 or 1", 
                        Constant.BINARY_VALID
                );
                break;
            case 2:
                data = Validate.getString(
                        "Enter number decimal: ", 
                        "Must be enter 0-9", 
                        Constant.DECIMAL_VALID
                );
                break;
            case 3:
                data = Validate.getString(
                        "Enter number hexadecimal: ", 
                        "Must be enter 0-9 A-F", 
                        Constant.HEXADECIMAL_VALID
                );
                break;
        }
        System.out.println(function.convert(input, output, data));
    }
}