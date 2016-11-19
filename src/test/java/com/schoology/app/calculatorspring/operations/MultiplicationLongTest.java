package com.schoology.app.calculatorspring.operations;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by User on 19.11.2016.
 */
@RunWith(value = Parameterized.class)
public class MultiplicationLongTest {

    private static List<String> inputData;
    private static String expectation;
    private static final MultiplicationLong multiplicationLong = new MultiplicationLong();

    public MultiplicationLongTest(List<String> inputData, String expectation) {
        this.inputData = inputData;
        this.expectation = expectation;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getData() {
        List<String> a = new ArrayList<>();
        a.add("9223372036854775807");
        a.add("13");
        List<String> b = new ArrayList<>();
        b.add("7976931348623157");
        b.add("-1");
        b.add("0");
        List<String> c = new ArrayList<>();
        c.add("7976931348623157");
        c.add("-7976931348623157");
        List<String> d = new ArrayList<>();
        d.add("-3");
        d.add("-3");
        return Arrays.asList(new Object[][]{
                {a, "2.8"},
                {b, "-2.6"},
                {c, "0"},
                {d, "0E-16"},
        });
    }
    @Test
    public void testCount() throws Exception {
        final String actual = multiplicationLong.count(inputData);
        Assert.assertEquals("test results", expectation, actual);
    }
}