
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static Random rd = new Random();
    static int step = 1;

    /*
    Merge sort hoạt động:
    - Merge sort khi nhận một mảng có số lượng phần tử nhất định, nó sẽ chia
    đôi mảng dần dần cho đến khi 2 mảng con bên trái và phải chỉ còn chứa 1 
    phần tử
    - So sánh lần lượt từng phần tử ở mảng bên trái vs mảng bên phải. Nếu nhỏ
    hơn thì xếp trước, lớn hơn thì xếp sau
    - Sau khi sắp xếp xong, ta sẽ ghép các mảng con với nhau, so sánh và sắp
    xếp tiếp
    - Lặp đi lặp lại quá trình này cho đến khi sắp xếp mảng con hoàn tất thì 
    xếp lại vào mảng chính
    */
    //core
    private static void MergeSort(int[] a, String side) {
        int length = a.length;

        if (length <= 1) {
            return;//base case
        }
        int mid = length / 2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[length - mid];
        int i = 0; //left
        int j = 0; //right
        for (; i < length; i++) {
            if (i < mid) {
                leftArray[i] = a[i];
            } else {
                rightArray[j] = a[i];
                j++;
            }
        }
        System.out.printf("\nStep %d: Slip %s -> left %s | right %s",
                (step++),side.toUpperCase(),Arrays.toString(leftArray), 
                Arrays.toString(rightArray));
        
        MergeSort(leftArray, "left of " + side);
        MergeSort(rightArray, "right of " + side);
        System.out.printf("\nMerging (%s): %s + %s", 
                side, Arrays.toString(leftArray), Arrays.toString(rightArray));
        merge(leftArray, rightArray, a);
        System.out.printf("\nAfter merge (%s): %s\n", side, Arrays.toString(a));
    }

    //Sắp xếp 2 phía
    private static void merge(int[] leftArray, int[] rightArray, int[] array) {
        int leftSize = array.length / 2;
        int rightSize = array.length - leftSize;
        int i = 0;
        int l = 0; // chỉ số xét bên trái (leftSize)
        int r = 0; // chỉ số xét bên phải (rightSize)
        while (l < leftSize && r < rightSize) {
            if (leftArray[l] < rightArray[r]) {
                array[i] = leftArray[l];
                i++;
                l++;
            } else {
                array[i] = rightArray[r];
                i++;
                r++;
            }

        }
        //phần còn dư bên trái
        while (l < leftSize) {
            array[i] = leftArray[l];
            i++;
            l++;
        }
        //phần còn dư bên phải
        while (r < rightSize) {
            array[i] = rightArray[r];
            i++;
            r++;
        }
    }

    public static int getArray() {
        int n = 0;
        while (true) {
            System.out.print("Enter number of array: ");
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
        StringBuilder sb = new StringBuilder();
        StringBuilder st = new StringBuilder();

        int n = getArray();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = rd.nextInt(2 * n + 1) - n;
        }

        //display unsort
        System.out.print("Unsorted array:");
        System.out.println(Arrays.toString(a));

        //display sort
        System.out.print("Sorted array:");
        MergeSort(a, "root");
        System.out.println(Arrays.toString(a));

    }
}
