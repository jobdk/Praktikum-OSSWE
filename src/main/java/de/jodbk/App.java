package de.jodbk;

import java.util.Locale;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.next();
        System.out.println(input.toUpperCase(Locale.getDefault()));

    }
}
