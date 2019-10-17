package Second_kurs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        fourth(string);
    }
    //abcd111111102019
    public static void first_a(String string){
        System.out.println(Pattern.matches("abcd1{7}02019",string));
    }
    //dash123,4asd123.356adsdh87,3;keefe3vk56
    public static void first_b(String string){
        Pattern pattern = Pattern.compile("\\d*\\d");
        Matcher matcher = pattern.matcher(string);
        System.out.println(matcher.toString());
        long sum = 0 ;
        matcher.find();
        long max = Long.parseLong(string.substring(matcher.start(), matcher.end()));
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(max);
        while (matcher.find()){
            long i = Long.parseLong(string.substring(matcher.start(), matcher.end()));
            if(i>max)max=i;
            sum+=i;
            System.out.println(i);
            arrayList.add(i);
        }
        System.out.println("Сумма: "+sum);
        System.out.println("Максимальное: "+max);
        System.out.println("Индекс максимального: "+arrayList.indexOf(max));
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
            string=matcher.replaceAll("*");
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
    //#00FF7F
    public static void first_f(String string){
        System.out.println(Pattern.matches("#[a-fA-F0-9]{6}",string));
    }
    //C:\Users\danil\IdeaProjects\Daniil\src\Second_kurs\DATA.txt
    public static void first_g(String string){
        String [] str = string.split("\\u005C");
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(str).subList(0, str.length - 1));
        System.out.println(arrayList);
    }
    public static void first_h(String string){
        Pattern pattern = Pattern.compile("[ик]");
        Matcher matcher = pattern.matcher(string);
        string=matcher.replaceAll("");
        System.out.println(string);
    }
    //8172.21 USD 0.5 RUR 166 ESR 2099 USD 123.1245 USD 12.1 RUR 1235.23 EU
    public static void first_i(String string){
        String [] s = string.split(" ");
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> cur1 = new ArrayList<>(),cur2 = new ArrayList<>(),cur3 = new ArrayList<>();
        System.out.print("Конвертировать все цены в (USD|RUR|EU): ");
        ArrayList<String> currencies= new ArrayList<>();
        currencies.add("USD");
        currencies.add("RUR");
        currencies.add("EU");
        String str = scanner.next();
        double k,l;
        currencies.remove(str);
        cur1.add(str);
        cur2.add(currencies.get(0));
        cur3.add(currencies.get(1));
        System.out.print("Чему равен 1 "+currencies.get(0)+" в "+str+":");
        k = scanner.nextDouble();
        System.out.print("Чему равен 1 "+currencies.get(1)+" в "+str+":");
        l = scanner.nextDouble();
        StringBuilder string_new = new StringBuilder();
        for (int i = 1; i < s.length; i++) {
            if (s[i].equals(str)){
                double a = Double.parseDouble(s[i-1]);
                if ((a*100)%1==0){
                    cur1.add(String.valueOf(a));
                    string_new.append(String.format("%.2f %s ", a, str));
                }
            }
            else if (s[i].equals(currencies.get(0))){
                double a = Double.parseDouble(s[i-1]);
                if ((a*100)%1==0){
                    cur2.add(String.valueOf(a));
                    string_new.append(String.format("%.2f %s ", a*k, str));
                }
            }
            else if (s[i].equals(currencies.get(1))){
                double a = Double.parseDouble(s[i-1]);
                if ((a*100)%1==0){
                    cur3.add(String.valueOf(a));
                    string_new.append(String.format("%.2f %s ", a*l, str));
                }
            }
        }
        System.out.println(string_new);
        System.out.println(cur1);
        System.out.println(cur2);
        System.out.println(cur3);
    }
    //01:23:45:67:89:Az
    public static void third(String string){
        System.out.println(Pattern.matches("([a-fA-F0-9]{2}:){5}[a-fA-F0-9]{2}",string));
    }
    //https://ru.wikipedia.org:2347/wiki/URL#rrrf
    public static void fourth(String string){
        System.out.println(Pattern.matches("(https?://)?([a-zA-Z0-9])(([a-zA-Z0-9-])+\\.)+([a-z]{2,6})(:\\d+)?((/[a-zA-Z0-9]+)?)+/?(#[a-zA-Z0-9]+)?",string));
    }
    // 01.01.2001 29/02/2000 13/1/2900
    public static void sixth(String string){
        Pattern pattern = Pattern.compile("(0[1-9]|[12]\\d|3[01])/([0][1-9]|1[0-2])/((1[6-9]|[2-9]\\d)\\d{2})");
        Matcher matcher = pattern.matcher(string);
        matcher.find();
        int day = Integer.parseInt(matcher.group(1));
        int mouth = Integer.parseInt(matcher.group(2));
        int year = Integer.parseInt(matcher.group(3));
        if(mouth==1|mouth==3|mouth==5|mouth==7|mouth==8|mouth==10|mouth==12) System.out.println(true);
        else if ((mouth==4|mouth==6|mouth==9|mouth==11) && day<=30) System.out.println(true);
        else if (mouth==2){
            if (day<=28) System.out.println(true);
            else if(day>29) System.out.println(false);
            else if (year%400==0) System.out.println(true);
            else if(year%100==0) System.out.println(false);
            else if(year%4==0)System.out.println(true);
            else System.out.println(false);
        }
        else System.out.println(false);
    }
    //sabina-milashka@mail.ru pavel-durov@vkontakte.ru
    public static void seventh(String string){
        System.out.println(Pattern.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}",string));
    }
    //160.95.0.0 139.17.54.23
    public static void eighth(String string){
        System.out.println(Pattern.matches(
                "(((2((5[0-5])|([0-4]\\d)))|(1?\\d?\\d))\\.){3}((2((5[0-5])|([0-4]\\d)))|(1?\\d?\\d))"
                ,string));
    }
    //TQDasdf_aw31 asdd2r323_ FWADWD_123
    public static void ninth(String string){
        Pattern pattern = Pattern.compile("[\\w_]{8,}");
        Matcher matcher = pattern.matcher(string);
        if(!matcher.find()) System.out.println(false);
        else {
            boolean up=false,low=false,dig=false;
            for (int i = matcher.start(); i < matcher.end(); i++) {
                char c = string.charAt(i);
                if(Character.isUpperCase(c))up=true;
                else if(Character.isLowerCase(c))low=true;
                else if(Character.isDigit(c))dig=true;
            }
            System.out.println(up&low&dig);
        }
    }
    public static void tenth(String string){
        System.out.println(Pattern.matches("[1-9]\\d{5}",string));
    }
    //(3+5)-9*4
    public static void twelfth(String string){
        Pattern pattern = Pattern.compile("\\d[^+]");
        Matcher matcher = pattern.matcher(string);
        System.out.println(matcher.find());
    }
    public static void thirteenth(String string){
        Pattern pattern = Pattern.compile("\\(");
        Pattern pattern1 = Pattern.compile("\\)");
        Matcher matcher = pattern.matcher(string);
        int k=0,l=0;
        while (matcher.find())k++;
        matcher = pattern1.matcher(string);
        while (matcher.find())l++;
        System.out.println(k==l);
    }
}
