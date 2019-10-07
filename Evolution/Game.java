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
        pole = new boolean[4][4];
        for (int i = 0; i < pole.length; i++) {
            for (int j = 0; j < pole[i].length; j++) {
                if(Math.round(Math.random())==1) pole[i][j] =true;
            }
        }
        output();
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
        output();
    }
    public void output(){
        for (int i = 0; i < pole.length; i++) {
            for (int j = 0; j < pole[i].length; j++) {
                if(pole[i][j]) System.out.print("1  ");
                else System.out.print("0  ");
            }
            System.out.println();
        }
        check();
    }
    public void check(){
        int i=0;
        int k =arrayList.size()-1;
        if (k>0 && Arrays.deepEquals(arrayList.get(k),pole)) {
            System.out.println("Игра вошла в стабильную конфигурацию на "+arrayList.size()+" шаге");
        }
        else if(Arrays.deepEquals(pole,new boolean[pole.length][pole.length])){
            System.out.println("Все клетки погибли на "+arrayList.size()+" шаге");
        }
        else{
            for ( i = 0; i < arrayList.size(); i++) {
                boolean [][] array =Arrays.copyOf(arrayList.get(i),arrayList.get(i).length);
                if (k!=0 && Arrays.deepEquals(array,pole)) {
                    System.out.println("Игра вошла в периодическую конфигурацию на "+arrayList.size()+" шаге");
                    System.out.println("Ранний шаг "+i);
                    break;
                }
            }
        }
        if (i==arrayList.size()){
            System.out.println("Шаг "+i);
            arrayList.add(pole);
            step();
        }
    }
}
