package Second_kurs;

import java.util.ArrayList;
import java.util.Arrays;

public class Game {
    ArrayList<boolean[][]> arrayList ;
    boolean[][] pole;
    public static void main(String[] args) {
        new Game();
    }
    public Game(){
        arrayList = new ArrayList<>();
        pole = new boolean[5][5];
        for (int i = 0; i < pole.length; i++) {
            for (int j = 0; j < pole[i].length; j++) {
                if(Math.round(Math.random())==1) pole[i][j] =true;
            }
        }
        check();
    }
    public void step(){
        boolean [][] array = new boolean[pole.length][pole[0].length];
        for (int i = 0; i < pole.length; i++) {
            array[i]= Arrays.copyOf(pole[i],pole[i].length);
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                int k = 0;
                int x = array.length+i;
                int y = array[i].length+j;
                if (pole[(x-1)%pole.length][(y-1)%pole[i].length])k++;
                if (pole[(x-1)%pole.length][(y)%pole[i].length])k++;
                if (pole[(x-1)%pole.length][(y+1)%pole[i].length])k++;
                if (pole[(x)%pole.length][(y-1)%pole[i].length])k++;
                if (pole[(x)%pole.length][(y+1)%pole[i].length])k++;
                if (pole[(x+1)%pole.length][(y-1)%pole[i].length])k++;
                if (pole[(x+1)%pole.length][(y)%pole[i].length])k++;
                if (pole[(x+1)%pole.length][(y+1)%pole[i].length])k++;
                if (array[i][j] && (k<2 || k>3))array[i][j]=false;
                else if (k==3)array[i][j]=true;
            }
        }
        pole=array;
        check();
    }
    public void output(){
        int k = 0;
        for (boolean[][] al : arrayList) {
            for (int i = 0; i < al.length; i++) {
                for (int j = 0; j < al[i].length; j++) {
                    if (al[i][j]) System.out.print("1  ");
                    else System.out.print("0  ");
                }
                System.out.println();
            }
            System.out.println("Шаг " + k);
            k++;
        }
    }
    public void check(){
        arrayList.add(pole);
        int k =arrayList.size()-1;
        if(Arrays.deepEquals(pole,new boolean[pole.length][pole[0].length])){
            output();
            System.out.println("Все клетки погибли ");
        }
        else if (k>0 && Arrays.deepEquals(arrayList.get(k-1),pole)) {
            output();
            System.out.println("Игра вошла в стабильную конфигурацию ");
        }
        else{
            int i =0;
            for (boolean[][] array : arrayList) {
                if (k != 0 && (i!=arrayList.size()-1) && Arrays.deepEquals(array, pole)) {
                    output();
                    System.out.println("Игра вошла в периодическую конфигурацию ");
                    System.out.println("Ранний шаг " + i);
                    break;
                }
                i++;
            }
            if(i==arrayList.size()) step();
        }
    }
}
