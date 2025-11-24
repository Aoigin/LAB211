import validate.Check;
import convert.Convert;
import java.util.Scanner;

public class main {

    public static Scanner sc = new Scanner(System.in);

    public static int getChoice(Scanner sc, String type) {
        System.out.println(type + " : ");
        System.out.println("1. Binary");
        System.out.println("2. Decimal");
        System.out.println("3. Hexadecimal");
        int maxChoice;
        if (type == "INPUT") {
            System.out.println("4. Exit");
            maxChoice = 4;
        } else {
            System.out.println("4. Go back");
            maxChoice = 4;
        }

        int t;
        while (true) {
            System.out.print("Choose a choice: ");
            try {
                t = sc.nextInt();
                if (t > maxChoice || t < 1) {
                    System.out.println("Try again w number from 1 to " + maxChoice);
                    continue;
                }
                sc.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Try again w number from 1 to " + maxChoice);
                sc.nextLine();
            }
        }
        return t;
    }

    public static String checkNumber(int input) {
        String num = "";
        while (true) {
            System.out.print("NUMBER: ");
            num = sc.nextLine().toUpperCase().replaceAll("\\s+", "");
            if (num.isEmpty()) {
                System.out.println("Input cannot be empty!");
                continue;
            }
            if (input == 1 && !Check.checkInputBinary(num)) {
                System.out.println("Invalid number. Please enter 0 or 1.");
                continue;
            }
            if (input == 2 && !Check.checkInputDecimal(num)) {
                System.out.println("Invalid number. Please enter from 0 to 9.");
                continue;
            }
            if (input == 3 && !Check.checkInputHexadecimal(num)) {
                System.out.println("Invalid number. Please enter 0 - 9 or A - F.");
                continue;
            }
            break;
        }
        return num;
    }

    public static String printOutput(int input, int output, String num) {
        String result = "";
        long decimalValue = 0;
        try {
            switch (input) {
                case 1:
                    decimalValue = Convert.BinaryToDecimal(num);
                    break;
                case 2:
                    decimalValue = Long.parseLong(num);
                    break;
                case 3:
                    decimalValue = Convert.HexadecimalToDecimal(num);
                    break;
                default:
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid format number!!!");
            sc.nextLine();
        }

        switch (output) {
            case 1:
                result = Convert.DecimalToBinary(decimalValue);
                break;
            case 2:
                result = String.valueOf(decimalValue);
                break;
            case 3:
                result = Convert.DecimalToHexa(decimalValue);
                break;
            default:
                break;
        }
        return result;
    }

    public static void main(String[] args) {

        while (true) {
            int input = getChoice(sc, "INPUT");
            if (input == 4) {
                System.out.println("Exit...");
                break;
            }
            int output;
            while (true) {
                output = getChoice(sc, "OUTPUT");
                if (output == 4) {
                    break;
                }
                if (input == output) {
                    System.out.println("Input and output bases cannot be the same. Please choose again.");
                
                } else {
                    break;
                }
            }
            if (output == 4) {
                continue;
            }
            String num = checkNumber(input);
            
            String result = null;
            if (input == output) {
                result = num;
            } else {
                result = printOutput(input, output, num);
                System.out.println("OUTPUT: " + result);
            }
        }

    }

}
