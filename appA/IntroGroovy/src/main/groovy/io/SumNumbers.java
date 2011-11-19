package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumNumbers {
    public static void main(String[] args) {
        System.out.println("Please enter numbers to sum");
        BufferedReader br = 
           new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        try {
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] inputs = line.split(" ");
        double total = 0.0;
        for (String s : inputs) {
            total += Double.parseDouble(s);
        }
        System.out.println("The sum is " + total);
    }
}
