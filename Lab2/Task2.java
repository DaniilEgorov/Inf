package Second_kurs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        fourth();
    }
    public static void first_a(){
        int n =9874;
        Stack<Byte> stack = new Stack<>();
        int k = 0, s = n;
        while (n!=0){
            stack.push((byte) (n % 10));
            n /= 10;
        }
        while (!stack.empty()){
            System.out.print(stack.pop());
        }
        System.out.println();
        n=s;
        while (s != 0) {
            k++;
            s /= 10;
        }
        while (k!=0){
            k--;
            stack.push((byte) ((n / Math.pow(10, k)) % 10));
        }
        while (!stack.empty()){
            System.out.print(stack.pop());
        }
    }
    public static void first_b(){
        int n = 9874;
        ArrayDeque<Byte> deque = new ArrayDeque<>();
        int k = 0, s = n;
        while (s!=0){
            k++;
            s /= 10;
        }
        while (k!=0){
            k--;
            deque.push((byte) ((n / Math.pow(10, k)) % 10));
        }
        while (deque.peek()!=null){
            System.out.print(deque.pop());
        }
        System.out.println();
        while (n!=0){
            deque.push((byte)(n%10));
            n /= 10;
        }
        while (deque.peek()!=null){
            System.out.print(deque.pop());
        }
    }
    public static void second_stack(){
        try {
            BufferedReader bf = new BufferedReader( new FileReader("Data2.txt"));
            String line;
            int k = 0;
            Task2_Class[] ts = new Task2_Class[5];
            Stack<String>  stack = new Stack<>();
            Stack<String>  stack_odl = new Stack<>();
            while ((line=bf.readLine())!=null){
                ts[k] = new Task2_Class(line);
                stack.push(line);
                k++;
            }
            for (int i = ts.length-1; i > -1; i--) {
                if (output(ts[i])) System.out.println(stack.pop());
                else stack_odl.push(stack.pop());
            }
            while (!stack_odl.empty()){
                System.out.println(stack_odl.pop());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static boolean output (Task2_Class ts) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        try {
            Date now = dateFormat.parse("27.09.2019");
                Date date = dateFormat.parse(ts.birthday());
                int age = (int)((now.getTime() - date.getTime())/24 / 60 / 60 / 1000 /365);
            return age<40;
        } catch (ParseException e) {
            e.printStackTrace();
        }
    return false;
    }
    public static void second_queue(){
        try {
            BufferedReader bf = new BufferedReader( new FileReader("Data2.txt"));
            String line;
            int k = 0;
            Task2_Class[] ts = new Task2_Class[5];
            ArrayDeque<String>  deque = new ArrayDeque<>();
            while ((line=bf.readLine())!=null){
                ts[k] = new Task2_Class(line);
                deque.push(line);
                k++;
            }
            k=0;
            for (int i = ts.length-1; i > -1; i--) {
                if (output(ts[i])) System.out.println(deque.pop());
                else deque.push(deque.pop());
            }
            while(deque.peek()!=null){
                System.out.println(deque.pop());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void third(){
        Scanner line = new Scanner(System.in);
        String str = line.nextLine();
        Stack<Character> stack = new Stack<>();
        boolean p = false;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)=='['|| str.charAt(i)=='{'|| str.charAt(i)=='('){
                stack.push(str.charAt(i));
            }
            else if (stack.empty())break;
            else if ((stack.peek()=='('&& str.charAt(i)==')' )||(stack.peek()=='['&& str.charAt(i)==']') || (stack.peek()=='{'&& str.charAt(i)=='}'))stack.pop();
            else break;
            p=true;
        }
        if (!stack.empty())p=false;
        if (p) System.out.println("Баланс скобок не нарушен");
        else System.out.println("Баланс скобок нарушен");
    }
    public static void fourth(){
        String f ="m(M(3,m(6,9)),M(5,4))";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < f.length(); i++) {
            if (f.charAt(i)==')'){
                int k = stack.pop();
                int l = stack.pop();
                stack.pop();
                if(stack.pop()=='M')
                    if (l>k) stack.push((char)l);
                    else stack.push((char)k);
                else if (l<k) stack.push((char)l);
                else stack.push((char)k);
            }
            else if(f.charAt(i)!=',') stack.push(f.charAt(i));
        }
        System.out.println(stack.pop());
    }
    public static void fifth(){
        try {
            BufferedReader bf = new BufferedReader( new FileReader("Data2_0.txt"));
            String line ;
            ArrayList<String> array = new ArrayList<>();
            ArrayList<String> check = new ArrayList<>();
            while ((line=bf.readLine())!=null){
                array.add(line);
            }
            array.sort((o1, o2) -> {
                if (o1.length() != o2.length())
                    return o1.length() - o2.length();
                else
                    return o1.compareTo(o2);
            });
            System.out.println(array);
            Collections.sort(array);
            System.out.println(array);
            array.sort((o1, o2) -> {
                int k = 0, l = 0;
                for (int i = 0; i < o1.length(); i++) if (Character.isUpperCase(o1.charAt(i))) k++;
                for (int i = 0; i < o2.length(); i++) if (Character.isUpperCase(o2.charAt(i))) l++;
                if (k != l)
                    return k-l;
                else
                    return o1.compareTo(o2);
            });
            System.out.println(array);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void sixth(){
        Task2_Plane plane = new Task2_Plane();
        plane.add_point(1,1);
        plane.add_point(-3,2);
        plane.add_point(4,5);
        plane.add_point(4,5);
        plane.add_point(0,2);
        plane.add_point(-2,-4);
        plane.add_point(-2,-4);
        System.out.println(plane.distance(2,4));
    }
}
