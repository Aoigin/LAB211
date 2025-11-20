
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
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
    static Random rd = new Random();
    static int step = 1;
    
    /*
    Quick sort hoạt động:
    - Cho một mảng bất kì. Ta khai báo 3 biến: i,j và pivot
    - Pivot ta sẽ đặt ở cuối, j nằm ở vị trí đầu tiên (0) và i nằm ở trước j (null)
    - Bắt đầu, ta sẽ duyệt từ đầu mảng đến cuối mảng, so sánh giá trị ở pivot với
    từng giá trị j. Khi j >= pivot thì giữ nguyên, không làm gì, j++ đến duyệt 
    phần tử tiếp theo. Nếu j < pivot thì ta sẽ tăng i lên (i++), sau đó swap giá trị
    ở vị trí i và vị trí j cho nhau
    - Sau đó tiếp tục, duyệt tiếp cho đến khi j chạy đến đúng vị trí của pivot.
    Lúc này, ta tăng biến i lên (i++), ta swap giá trị ở vị trí i và vị trí pivot.
    Sau khi swap xong, ta thấy pivot về giữa, giá trị bên trái pivot thì nhỏ hơn pivot,
    giá trị bên phải pivot thì lớn hơn pivot.
    - Đến đây chưa phải là hết vì ta thấy các phần tử vẫn chưa được sắp xếp hoàn toàn.
    Ta lấy pivot làm trung tâm và tách 2 bên trái và phải thành 2 mảng nhỏ.
    Bên trái lấy từ 0 đến pivot - 1, bên phải lấy từ pivot + 1 đến length - 1.
    Ta tiếp tục duyệt cùng với 3 biến kia và chia đôi thành mảng nhỏ cho đến khi 
    sắp xếp hoàn tất thì ta gọi đệ quy để sắp lại vào mảng chính
    */
    //core
    private static void QuickSort(int[] a, int start, int end, String side) {
        //base case
        if (end <= start) {
            return;
        }
        
        System.out.printf("\n[%s] Quick sort range [%d,%d] %s:",
                side.toUpperCase(),a[start],a[end],Arrays.toString(a));
        
        int pivot = partition(a, start, end);
        QuickSort(a, start, pivot - 1, "left of "+ a[pivot]); //left
        QuickSort(a, pivot + 1, end, "right of "+ a[pivot]); //right
    }

    private static int partition(int[] a, int start, int end) {
        int pivot = a[end];
        int i = start - 1;
        System.out.println("\nPartition with pivot = " + pivot + " (index " + end + ") ");
        for (int j = start; j <= end - 1; j++) {
            System.out.printf("Comparing a[%d] = %d with pivot = %d\n",j,a[j],pivot);
            if (a[j] < pivot) {
                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                System.out.println("Step " + (step++) + ": Swap a[" + i + "]="+ a[i]+ 
                        " and"+ " a[" + j + "]="+a[j]+ " -> " + Arrays.toString(a));
            }
        }
        //cho pivot ra giữa
        i++;
        int temp = a[i];
        a[i] = a[end];
        a[end] = temp;
        System.out.println("Move pivot " +a[end]+" to position " + i + " ("+ a[i] + ")"
                + " -> " + Arrays.toString(a));
        
        return i;
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
        QuickSort(a, 0, a.length - 1, "root");
        System.out.println(Arrays.toString(a));

    }

}
