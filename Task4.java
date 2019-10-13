package Second_kurs;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task4 {
    //abcd111111102019
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        first_e(string);
    }
    //dasd123,4asd123.356adsdh87,3;kjdfg3vk56
    public static void first_a(String string){
        System.out.println(Pattern.matches("abcd1{7}02019",string));
    }
    public static void first_b(String string){
        Pattern pattern = Pattern.compile("\\d*\\d");
        Matcher matcher = pattern.matcher(string);
        long sum = 0 ;
        matcher.find();
        long max = Long.parseLong(string.substring(matcher.start(), matcher.end()));
        matcher.reset();
        ArrayList<Long> arrayList = new ArrayList<>();
        while (matcher.find()){
            long i = Long.parseLong(string.substring(matcher.start(), matcher.end()));
            if(i>max)max=i;
            sum+=i;
            System.out.println(i);
            arrayList.add(i);
        }
        System.out.println(sum);
        System.out.println(max);
        System.out.println(arrayList.indexOf(max));
    }
    public static void first_c(String string){
        Pattern pattern = Pattern.compile("\\d*([.,]\\d*|\\d)");
        Matcher matcher = pattern.matcher(string);
        ArrayList<String> arrayList = new ArrayList<>();
        while (matcher.find()){
            String i = string.substring(matcher.start(), matcher.end());
            arrayList.add(i);
        }
        System.out.println(arrayList);
    }
    public static void first_d(String string){
        Pattern pattern = Pattern.compile("\\w{10,}");
        Matcher matcher = pattern.matcher(string);
        String string1=string;
        StringBuffer string2 = new StringBuffer(string);
        while (matcher.find()){
            string=string.replace(string.substring(matcher.start(), matcher.end()),"*");
            matcher = pattern.matcher(string);
        }
        System.out.println(string);
        matcher = pattern.matcher(string1);
        while (matcher.find()){
            string1=string1.replace(string1.substring(matcher.start(), matcher.end()),String.valueOf(string1.charAt(matcher.start())));
            matcher = pattern.matcher(string1);
        }
        System.out.println(string1);
        matcher = pattern.matcher(string2);
        while (matcher.find()){
            char str = string2.charAt(matcher.start());
            int k = matcher.start();
            while (k!=matcher.end()){
                string2.setCharAt(k,str);
                k++;
            }
        }
        System.out.println(string2);
    }
    //6F9619FF-8B86-D011-B42D-00CF4FC964FF
    public static void first_e(String string){
        System.out.println(Pattern.matches("[a-fA-F0-9]{8}-([a-fA-F0-9]{4}-){3}[a-fA-F0-9]{12}",string));
    }
}
