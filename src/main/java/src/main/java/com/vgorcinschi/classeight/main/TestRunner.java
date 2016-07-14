/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.main.java.com.vgorcinschi.classeight.main;

import java.util.Scanner;
import static src.main.java.com.vgorcinschi.classeight.util.StringValidator.stringValidator;
import static org.apache.commons.lang3.StringUtils.containsAny;

/**
 *
 * @author v_gorcin
 */
public class TestRunner {

    private static double hoursWorked;
    private static String clientPackage;

    public static void main(String[] args) {
//        EvenOdd e = new EvenOdd();
//        e.getOddInput();
    }

    public static void getInputs() {
        try (Scanner sc = new Scanner(System.in)) {
            clientPackage = stringValidator((s) -> {
                return s.length() == 1
                        && containsAny(s.toUpperCase(), "A", "B", "C");
            }, () -> "The package needs to be exactly "
                    + "one character long. Only values A,B or C are allowed", () -> "client package (plan)", sc);
        } catch (Exception e) {
        }
    }
}
