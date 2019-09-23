package Second_kurs;

import java.util.Vector;

public class Task1 {
    static int k;
    static int sum=0;
    static double min,max;
    static double integral;
    public static void main(String[] args) {
        sixth();
    }
    public static void first(){
        Task1_Function p1 = (x) -> 2*Math.sin(x)+1;
        Task1_Function p2 = (x) -> Math.pow((x/Math.PI)-1,2);
        Task1_Function p3 = (x) -> -Math.pow(x/Math.PI,2)-2*x+5*Math.PI;
        Task1_Function p4 = (x) -> Math.pow(Math.cos(x),2)/2+1;
        y(p1,-2*Math.PI,2*Math.PI,Math.PI/6);
        System.out.println();
        y(p2,-2*Math.PI,2*Math.PI,Math.PI/6);
        System.out.println();
        y(p3,-2*Math.PI,2*Math.PI,Math.PI/6);
        System.out.println();
        y(p4,-2*Math.PI,2*Math.PI,Math.PI/6);
    }
    public static void y(Task1_Function p, double a, double b, double dx){
        k=0;
        integral=0;
        for (double i = a; i <= b; i+=dx) {
            if (p.func(i)<0)k++;
            System.out.printf("%7.2f",p.func(i));
            if(i!=b)integral+=dx*p.func(i+dx/2);
        }
        sum+=k;
    }
    public static void second_a(){
        Task1_Function [] array = {(x) -> 2*Math.sin(x)+1,(x) -> Math.pow((x/Math.PI)-1,2),(x) -> -Math.pow(x/Math.PI,2)-2*x+5*Math.PI,(x) -> Math.pow(Math.cos(x),2)/2+1};
        for (int i = 0; i < array.length; i++) {
            y(array[i],-2*Math.PI,2*Math.PI,Math.PI/6);
            System.out.println("\nКоличество отрицательных значений: "+k);
        }
        System.out.println("Итого: "+sum);
    }
    public static void second_b(int n){
        Task1_Function [] array = {(x) -> 2*Math.sin(x)+1,(x) -> Math.pow((x/Math.PI)-1,2),(x) -> -Math.pow(x/Math.PI,2)-2*x+5*Math.PI,(x) -> Math.pow(Math.cos(x),2)/2+1};
        double [] x =new double[n];
        for (int i = 0; i < x.length; i++) {
            x[i] =Math.random()*20-10;
        }
        for (int i = 0; i < array.length; i++) {
            y1(array[i],x);
        }
    }
    public static void y1(Task1_Function p, double [] x){
        min = p.func(x[0]);
        max = p.func(x[0]);
        for (int i = 0; i < x.length; i++) {
            if (p.func(x[i])>max) max = p.func(x[i]);
            else if (p.func(x[i])<min) min = p.func(x[i]);
            System.out.printf("%7.2f",p.func(x[i]));
        }
        System.out.println("\n Максимальное значение: "+ max + " Минимальное значение: "+ min);
    }
    public static void fourth(){
        Task1_Function[] array = {(x) -> x*Math.sin(x)-0.5, (x) -> Math.log(x*x-3*x+2)/Math.log(10), (x) -> Math.log(x*x-3*x+2)/Math.log(10), (x) -> 0.5*Math.tan((2/3)*(x+Math.PI/4))-1 };
        double [] a = {0,0,2.1,Math.PI};
        double [] b = {Math.PI,0.9,5,2*Math.PI};
        for (int i = 0; i < array.length; i++) {
            y2(array[i],a[i],b[i]);
        }
    }
    public static void y2(Task1_Function p, double a, double b){
        while (b-a>0.0001){
            if (Math.abs(p.func(a))>Math.abs(p.func(b))) a=(b+a)/2;
            else b=(b+a)/2;
        }
        if (Math.abs(p.func(a))<0.0001) System.out.println("Корент уравнения: " + a);
        else System.out.println("Корень уравнения: "+b);
    }
    public static void fifth(){
        Task1_Function[] array = {(x) -> 2*Math.sin(x)+1,(x) -> -Math.pow(x/Math.PI,2)-2*x+5*Math.PI,(x) -> Math.pow(Math.cos(x),2)/2+1};
        for (int i = 0; i < array.length; i++) {
            y(array[i],-Math.PI,Math.PI,Math.PI/6);
            System.out.println("\nИнтеграл равен: "+integral);
        }
    }
    public static void sixth(){
        int f=0,p=0,w=0;
        Vector<String> vector = new Vector<>();
        vector.add("Hello");
        vector.add("World");
        vector.add("Java");
        vector.add("Programming");
        vector.add("Wednesday");
        vector.add("LeveL");
        for (int i = 0; i < vector.size(); i++) {
            if (five_letters(vector.get(i)))f++;
            if (palindrom(vector.get(i)))p++;
            if (letter_W(vector.get(i)))w++;
        }
        System.out.println("Количество пятибуквенных слов: "+f);
        System.out.println("Количество палиндромов: "+p);
        System.out.println("Количество слов начинающихся на W: "+w);
    }
    public static boolean five_letters(String str){
        return str.length() == 5;
    }
    public static boolean palindrom(String line){
        boolean k = true;
        for (int i = 0; i < line.length()/2; i++) {
            if (line.charAt(i)!=line.charAt(line.length()-1-i)) {
                k = false;
                break;
            }
        }
        return k;
    }
    public static boolean letter_W(String str){
        return str.charAt(0)=='W';
    }
}
