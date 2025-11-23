import Shape.Circle;
import Shape.Rectangle;
import Shape.Triangle;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author LE THI BICH NGAN
 */
public class Main {

    static Scanner sc = new Scanner(System.in);

    public static double input(String message) {
        double n = 0.0;
        while (true) {
            System.out.println(message);
            try {
                n = sc.nextDouble();
                if (n <= 0) {
                    System.out.println("Value cannot be negative.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Value should be a digit.");
                sc.nextLine();
            }
        }
        return n;
    }

    public static void main(String[] args) {
        Rectangle hcn = new Rectangle();
        Circle tron = new Circle();
        Triangle tgiac = new Triangle();

        System.out.println("=====Calculator Shape Program=====");
        hcn.setWidth(input("Please input side width of Rectangle: "));
        hcn.setLength(input("Please input length of Rectangle: "));
        tron.setRadius(input("Please input radius of Circle: "));

        while (true) {
            tgiac.setSideA(input("Please input side A of Triangle: "));
            tgiac.setSideB(input("Please input side B of Triangle: "));
            tgiac.setSideC(input("Please input side C of Triangle: "));

            if (!tgiac.isValidate()) {
                System.out.println("Invalid triangle sides. "
                        + "The sum of any two sides must be greater than the remaining side.");
                continue;
            }
            break;
        }
        System.out.println("=====Result=====");
        hcn.printResult();
        tron.printResult();
        tgiac.printResult();
    }

}
