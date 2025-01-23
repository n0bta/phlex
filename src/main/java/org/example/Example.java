package org.example;

import java.io.IOException;
import java.util.List;

public class Example {
    public static void main(String[] args) throws IOException {
        List<PhlexCase> a = Phlex.getCases(2002, Phlex.MONTHS[7]);
        for (PhlexCase b : a) {
            System.out.println(b.toString());
        }
    }
}
