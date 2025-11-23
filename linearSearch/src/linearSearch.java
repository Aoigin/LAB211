/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LE THI BICH NGAN
 */

import java.util.*;

public class linearSearch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        
        int n = 0;
        while (true) {
            System.out.println("Enter number of array: ");
            try {
                n = sc.nextInt();
                if (n <= 0) {
                    System.out.println("Please enter positive decimal number.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid value. Please try again.");
                sc.nextLine(); 
            }
        }
        
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(2*n+1)-n;
        }
        
        System.out.print("The array: ");
        System.out.println(Arrays.toString(arr));
        
        int x = 0;
        while (true) {
            System.out.println("Enter number to search: ");
            try {
                x = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid value. Please try again.");
                sc.nextLine(); 
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(i);
            }
        }
        if (sb.length()!=0) {
            System.out.println("Found "+x+" at index: "+sb.toString());
        }else System.out.println("Cannot found!");
        
        
    }
}
