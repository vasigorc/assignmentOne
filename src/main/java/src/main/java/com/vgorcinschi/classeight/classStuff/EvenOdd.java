/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.main.java.com.vgorcinschi.classeight.classStuff;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import static src.main.java.com.vgorcinschi.classeight.util.NumberFormatter.validateDoubleValue;

/**
 *
 * @author v_gorcin
 */
public class EvenOdd {
    private final Scanner sc = new Scanner(System.in);
    private Map<Boolean, List<Integer>> evenOdds;

    public EvenOdd() {
    }
    
    public void printOdd(int odd){
        pull(odd);
        System.out.println(evenOdds.get(true));
    }
    
    public void getOddInput(){
        int upperLimit = validateDoubleValue(()-> "upper limit of odd numbers", 2, sc).intValue();
        printOdd(upperLimit);
    }
    
    public void getEvenInput(){
        int upperLimit = validateDoubleValue(()-> "upper limit of even numbers", 2, sc).intValue();
        printEven(upperLimit);
    }
    
    public void printEven(int even){
        pull(even);
        System.out.println(evenOdds.get(false));
    }
    
    public void pull(int number){
        evenOdds = IntStream.rangeClosed(1, number).boxed().collect(Collectors.partitioningBy(i -> i%2!=0));
    }
}
