package Second_kurs;

import java.util.Scanner;
import java.util.Stack;

public class Task2 {
    public static void main(String[] args) {
        Scanner number = new Scanner(System.in);
        int n = number.nextInt();
        first_a(n);
    }
    public static void first_a(int n){
        Stack<Byte> stack = new Stack<>();
        int k = 0, s = n;
        while (s!=0){
            k++;
            s=(int)Math.floor(s/10);
        }
        while (k!=0){
            k--;
            stack.push((byte)(Math.floor(n/Math.pow(10,k))%10));
        }
        while (!stack.empty()){
            System.out.print(stack.pop());
        }
        
    }
}
