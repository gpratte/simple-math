package com.example;

import static org.junit.Assert.assertTrue;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple Calculator.
 */
public class CalculatorTest
{
    Calculator calculator = new Calculator();

    @Test
    public void testOneNumber() {
        int result = calculator.calculate("42");
        Assert.assertEquals("number should be 42", 42, result);
    }

    @Test
    public void testAddTwoNumbers() {
        int result = calculator.calculate("42+1");
        Assert.assertEquals("number should be 43", 43, result);
    }

    @Test
    public void testSubtractTwoNumbers() {
        int result = calculator.calculate("42-1");
        Assert.assertEquals("number should be 41", 41, result);
    }

    @Test
    public void testComplicatedNumbers() {
        int result = calculator.calculate("1+2+3+5+8-8-5-3");
        Assert.assertEquals("number should be 3", 3, result);
    }

    @Test
    public void testComplicatedNumbersAgain() {
        int result = calculator.calculate("0-0+0+123-23");
        Assert.assertEquals("number should be 100", 100, result);
    }

}
