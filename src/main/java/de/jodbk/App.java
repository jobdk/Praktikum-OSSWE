package de.jodbk;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 */
public class App {

    /**
     * main method
     * Transforms given String to uppercase
     *
     * @param args unused
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.next();
        System.out.println(input.toUpperCase(Locale.getDefault()));

    }
}
