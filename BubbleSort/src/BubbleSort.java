
import java.util.*;

public class BubbleSort {

    /*
    Bubble sort là thuật toán sắp xếp tuần tự, duyệt các phần tử từ đầu mảng
    tới cuối mảng. Phần tử nào nhỏ hơn thì đứng trước, phần tử nào lớn hơn thì đứng sau. 
    */
    public void BubbleSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
       }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        StringBuilder sb = new StringBuilder();

        int n = 0;

        while (true) {
            System.out.println("Enter number of array: ");
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
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = rd.nextInt(2 * n + 1) - n;
        }

        //display unsort
        System.out.print("Unsorted array: [");
        //Cách 1: System.out.println(Arrays.toString(a));
        for (int i = 0; i < n; i++) {
            sb.append(a[i]);
            if (i < n - 1) {
                sb.append(",");
            } else {
                sb.append("]");
            }
        }
        System.out.println(sb.toString());

        //display sort
        System.out.print("Sorted array: ");
        BubbleSort sorter = new BubbleSort();
        sorter.BubbleSort(a);
        System.out.println(Arrays.toString(a));

    }

}
