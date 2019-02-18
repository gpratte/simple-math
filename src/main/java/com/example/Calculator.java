package com.example;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Simple math with just plus and minus.
 */
public class Calculator {
    /**
     * Only zero or positive integers.
     * Input is always well formed (do not have to validate)
     * <p>Example input</p>
     * <ul>
     * <li>500</li>
     * <li>1+2</li>
     * <li>43-9</li>
     * <li>42+42-42-12</li>
     * </ul>
     *
     * @param in the string to calculate
     * @return the calculation
     */
    public int calculate(String in) {
        // Get the operands
        String operands[] = in.split("\\+|-");

        // Get the operators
        String operators[] = in.split("\\d+");

        // result starts with the first opererand
        int result = Integer.parseInt(operands[0]);

        if (operands.length == 1) {
            // Only one number
            return result;
        }

        // The operators array may have an empty string for the first cell
        int operatorIndex = 0;
        if ("".equals(operators[0])) {
            // skip the empty string from the beginning
            operatorIndex++;
        }

        for (int i = 1; i < operands.length; i++) {
            // The next operand
            int operand = Integer.parseInt(operands[i]);

            switch (operators[operatorIndex++]) {
                case "+":
                    result += operand;
                    break;
                case "-":
                    result -= operand;
                    break;
            }
        }

        return result;
    }
}
