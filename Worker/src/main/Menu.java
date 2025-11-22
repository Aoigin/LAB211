package main;

import java.util.InputMismatchException;
import java.util.Scanner;
import service.Management;

public class Menu {

    public static Scanner sc = new Scanner(System.in);

    public static int menu() {
        System.out.println("===== WORKER MANAGEMENT =====");
        System.out.println("1. Add worker");
        System.out.println("2. Up salary");
        System.out.println("3. Down salary");
        System.out.println("4. Display information salary");
        System.out.println("5. Exit");
        int choice;
        while (true) {
            System.out.print("Choose a choice: ");
            try {
                choice = sc.nextInt();
                if(choice < 1 || choice > 5){
                    System.out.println("Invalid choice. Please choosing again.");
                    continue;
                }
                sc.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice. Please choosing again.");
                sc.nextLine();
            }
        }
        return choice;
    }

    public static void main(String[] args) {
        Management m = new Management();
        while(true){
            int choice = menu();
            switch(choice){
                case 1:
                    m.addWorker();
                    break;
                case 2:
                    m.increaseSalary();
                    break;
                case 3:
                    m.decreaseSalary();
                    break;
                case 4:
                    m.displayInfo();
                    break;
                case 5:
                    System.out.println("Exit...");
                    return;
                default:
                    break;
            }
        }
    }

}
