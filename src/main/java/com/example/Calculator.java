package com.example;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class Calculator
{
    /**
     * Simple math with just plus and minus.
     * Only zero or positive integers.
     * Input is always well formed (do not have to validate)
     * <p>Example input</p>
     * <ul>
     *     <li>500</li>
     *     <li>1+2</li>
     *     <li>43-9</li>
     *     <li>42+42-42-12</li>
     * </ul>
     * @param in
     * @return
     */
    public int calculate(String in) {
        // Get the operators
        String tokens[] = in.split("\\+|-");

        int result = Integer.parseInt(tokens[0]);

        if (tokens.length == 1) {
            // Only one number
            return result;
        }

        // Index from which the next operator search should begin
        int operandIndex = 0;
        int indexPlus;
        int indexMinus;

        for (int i = 1; i < tokens.length; i++) {
            // The next operand
            int operand = Integer.parseInt(tokens[i]);

            // Assume plus
            Operator operator = Operator.PLUS;

            // Index of the next plus
            indexPlus = in.indexOf('+', operandIndex);
            // Index of the next minus
            indexMinus = in.indexOf('-', operandIndex);

            if (indexPlus > -1 && indexMinus > -1) {
                // There is both a plus and a minus
                if (indexMinus < indexPlus) {
                    // The minus comes first
                    operator = Operator.MINUS;
                }
            } else if (indexMinus > -1) {
                // There is only a minus
                operator = Operator.MINUS;
            }

            if (operator == Operator.PLUS) {
                result += operand;
                operandIndex = indexPlus + 1;
            } else {
                result -= operand;
                operandIndex = indexMinus + 1;
            }
        }

        return result;
    }

    enum Operator {
        PLUS, MINUS
    }
}
