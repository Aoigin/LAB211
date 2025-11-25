
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);


    /*
    Bubble sort là thuật toán sắp xếp tuần tự, duyệt các phần tử từ đầu mảng
    tới cuối mảng. Phần tử nào nhỏ hơn thì đứng trước, phần tử nào lớn hơn thì đứng sau. 
     */
    public static void BubbleSort(ArrayList<Integer> a) {
        for (int i = 0; i < a.size() - 1; i++) {
            for (int j = 0; j < a.size() - i - 1; j++) {
                if (a.get(j) > a.get(j + 1)) {
                    int temp = a.get(j);
                    a.set(j, a.get(j + 1));
                    a.set(j+1, temp);
                }
            }
        }
    }

    public static int getChoice() {
        int n = 0;
        while (true) {
            System.out.print("Please choosing a choice: ");
            try {
                n = sc.nextInt();
                if (n < 1 || n > 4) {
                    System.out.println("Enter number between 1 to 4. Try Again.");
                    continue;
                }
                sc.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Choice must be digit");
                sc.nextLine();
            }
        }
        return n;
    }

    public static int getNum() {
        int n = 0;
        while (true) {
            System.out.println("Enter length of array: ");
            try {
                n = sc.nextInt();
                if (n <= 0) {
                    System.out.println("Please enter a positive decimal number.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid value. Please try again with a positive decimal number.");
                sc.nextLine();
            }
        }
        return n;
    }

    public static void main(String[] args) {
        ArrayList<Integer> b = new ArrayList<>();
        while (true) {
            System.out.println("=====Sort Array Program=====");
            System.out.println("1. Add element");
            System.out.println("2. Sort ascending");
            System.out.println("3. Sort descending");
            System.out.println("4. Exit");
            int choice = getChoice();

            switch (choice) {
                case 1:
                    int num = getNum();
                    for (int i = 0; i < num; i++) {
                        System.out.println("Enter number " + (i + 1) + " : ");
                        int value = sc.nextInt();
                        b.add(value);
                    }
                    break;
                case 2:
                    if(b.isEmpty()){
                        System.out.println("The list is empty!");
                        continue;
                    }
                    BubbleSort(b);
                    for (int i = 0; i < b.size()-1; i++) {
                        System.out.print(b.get(i) + " -> ");
                    }
                    System.out.print(b.get(b.size()-1));
                    System.out.println();
                    break;
                case 3:
                    if(b.isEmpty()){
                        System.out.println("The list is empty!");
                        continue;
                    }
                    BubbleSort(b);
                    Collections.reverse(b);
                    for (int i = 0; i < b.size()-1; i++) {
                        System.out.print(b.get(i) + " -> ");
                    }
                    System.out.print(b.get(b.size()-1));
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Exit...");
                    return;
                default:
                    break;
            }
        }
    }

}
