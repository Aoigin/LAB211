
public class Fibo {
    /*
    Biểu diễn dãy fibonacci bằng đệ quy.
    Đệ quy là phương pháp gọi lại hàm của chính nó.
    */
    public static long Fibonacci(int n, long[] memo) {
        if (n <= 1) {
            return n;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        
        return memo[n] = Fibonacci(n-1, memo) + Fibonacci(n-2, memo);
//        CÁCH TỐI ƯU HƠN (O(n))-nhưng lại ko sử dụng đệ quy
//        long prev = 0, cur = 1;
//        for (int i = 2; i <= n; i++) {
//            long next = prev + cur;
//            prev = cur;
//            cur = next;
//        }
//        return cur;
        //tại sao lại tối ưu hơn?
        //CÁCH KHÔNG TỐI ƯU VÌ O(2^n) : return Fibonacci(n-1) + Fibonacci(n-2);
        //return Math.round((1/Math.sqrt(5))*Math.pow((1+Math.sqrt(5))/2, n)
        //+(-1/Math.sqrt(5))*Math.pow((1-Math.sqrt(5))/2, n));
    }
    
    //CÁCH TỐI ƯU HƠN KHI MUỐN SỬ DỤNG ĐỆ QUY
    public static long fibonacci(int n){
        long[] memo = new long[n+1]; //sử dụng mảng để lưu 
        return Fibonacci(n, memo);
    }

    public static void main(String[] args) {
        System.out.println("45 fibonacci sequence: ");
        System.out.println(fibonacci(0));
        System.out.println(fibonacci(1));
        
        for (int i = 2; i < 45; i++) {
            long fibo = fibonacci(i);
            long fibo_1 = fibonacci(i-1);
            long fibo_2 = fibonacci(i-2);
            System.out.println(i + "  " + fibo + " = " + fibo_1 + "+" + fibo_2 );
        }
    }
}
