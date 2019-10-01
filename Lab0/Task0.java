package Second_kurs;

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;

public class Task0 {
    static int N=0;
    static String line;
    static char p;
    static int l;
    static int n;
    static  ArrayList<Character> symbols ;
    static double H;
    static double S;
    static String separator = "--------------------------------------------------------------------------------------------------------------------------------";
    public static void main(String[] args) {
        try {
            System.out.printf("%s%n%-3s|%-57s|%-11s|%35s%n%s%n",separator,"№","слово","","Количество информации",separator);
            System.out.printf("%4s|%-57s|%11s|%-10s |%13s |%9s     |%7s%n","","",""," кол-во","байт, размер","бит,","бит,");
            System.out.printf("%4s|%-57s|%10s |%9s  |%13s |%11s   |%11s%n%s%n","","","палиндром","символов","в программе","по Хартли","по Шеннону",separator);
            BufferedReader text = new BufferedReader (new FileReader("DATA.txt"));
            while ((line = text.readLine())!=null) {
                N++;
                palindrome();
                letters();
                numbers();
                hartley();
                shannon();
                formation();
            /*int k=0 ;
            StringBuilder new_line ;
            while (!line.equals("")){
                new_line = new StringBuilder();
                String [] new_array = line.split(String.valueOf(line.charAt(0)));
                for (int i = 0; i < new_array.length; i++) {
                    if (!new_array[i].equals("")) new_line.append(new_array[i]);
                }
                line = String.valueOf(new_line);
                k++;
            }
            System.out.println(k);*/
            }
            System.out.printf("%4s|%-57s|%-11s|%-11s|%14s|%14s|%-14s","","ИТОГО","","","","","");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void palindrome(){
        boolean k = true;
        for (int i = 0; i < line.length()/2; i++) {
            if (line.charAt(i)!=line.charAt(line.length()-1-i)) {
                k = false;
                break;
            }
        }
        if (k)p='+';
        else p='-';
    }
    public static void letters(){
        l=line.length();
    }
    public static void numbers(){
        byte [] utfbyte = line.getBytes();
        n = utfbyte.length;
    }
    public static void hartley(){
        symbols = new ArrayList<>();
        for (int i = 0; i < line.length(); i++) {
            if(!symbols.contains(line.charAt(i))) symbols.add(line.charAt(i));
        }
        H = line.length()*Math.log(symbols.size())/Math.log(2);
    }
    public static void shannon(){
        double k;
        S = 0;
        for (int i = 0; i < symbols.size(); i++) {
            k=0;
            for (int j = 0; j < line.length(); j++) {
                if (symbols.get(i)==line.charAt(j))k++;
            }
            S-=(k/line.length())*Math.log(k/line.length())/Math.log(2);
        }
    }
    public static void formation(){
        System.out.printf(Locale.ENGLISH,"%-4d|%-57s|%-11s|%-11d|%14d|%14.2f|%-14.9f%n%s%n",N,line,p,l,n,H,S,separator);
    }
}
