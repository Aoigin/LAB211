import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BinarySearch {

    public static void bubbleSort(int[] a) {
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
    /*
    Binary search là thuật toán chia đôi mảng để tìm kiếm
    */
    public static List<Integer> binarySearch(int[] a, int target, int left, int right) {
        //***chú ý: Trả về là LIST là một interface trong java.util
        //nếu dùng sai sang ArrayList thì nó vẫn đúng 
        //nhưng sẽ chỉ đc giới hạn trong array list thôi
        //array list là con của list 
        //cách tối ưu là sử dụng list
        int findFirst = findBound(a, target, left, right,  true);
        if (findFirst == -1)return new ArrayList<>();
        int findLast = findBound(a, target, left, right, false);
        
        List<Integer> myList = new ArrayList<>(); // khai báo list mới và khởi tạo
                                                  // bằng một đối tượng array list 
        for (int i = findFirst; i <= findLast; i++) {
            myList.add(i);
        }
        return myList;
    }

    private static int findBound(int[] a, int target, int left, int right, boolean findFirst) {
        int result = -1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if (a[mid] == target) {
                result = mid;
                if (findFirst) {
                    right = mid -1;
                } else {
                    left = mid+1;
                }
            }
            else if (a[mid] < target) {//chuyển từ if thành else if
                                       //nếu vẫn để if thì đoạn code sẽ chia làm 2 khối
                                       //2 khối sẽ hoạt động riêng biệt 
                                       //result đã có nhưng vẫn phải chạy tiếp 
                                       //if thứ hai gây ra hậu quả 
                                       //ko in đúng kết quả
                left = mid + 1;
            }
            else right = mid - 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();

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
                System.out.println("Invalid value. Please try again.");
                sc.nextLine();
            }
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rd.nextInt(2 * n + 1) - n;
//khoảng -n đến n
//ví dụ: nextInt(101)-50
//thì random số dương trong khoảng từ 0 đến 100
//NHƯNG vì -50 bên ngoài nên phải DỊCH TRÁI 50 số
//nên nó mới dịch từ -50 đến 50 có tổng cộng là 101 số
        }

        bubbleSort(arr);
        System.out.print("Sorted array: ");
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

        //index cần tìm
        List<Integer> index = binarySearch(arr, x, 0, n - 1);
        if (!index.isEmpty()) {
            System.out.println("Found " + x + " at index: " + index);
        } else {
            System.out.println("Cannot found!!!");
        }

    }
}
