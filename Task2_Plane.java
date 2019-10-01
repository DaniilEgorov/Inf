package Second_kurs;

import java.util.ArrayList;

public class Task2_Plane {
    ArrayList <Task2_Point> array;
    public Task2_Plane(){
        array = new ArrayList<>();
    }
    public void add_point(double x, double y){
        if (array.isEmpty())array.add(new Task2_Point(x,y));
        else {
            int i = 0;
            while (i<array.size()){
                if (array.get(i).get_x()==x && array.get(i).get_y()==y){
                    System.out.print("Точка уже задана  ");
                    output_point(i);
                    break;
                }
                i++;
            }
            if(i==array.size())array.add(i,new Task2_Point(x,y));
        }
    }
    public void output_point(int i){
        System.out.print("x = "+array.get(i).get_x());
        System.out.println("  y = "+array.get(i).get_y());
    }
    public int get_index(double x, double y){
        if (array.isEmpty()){
            System.out.println("Ломаная отсутствует");
            return -1;
        }
        else for (int i = 0; i < array.size(); i++) {
            if (array.get(i).get_x()==x && array.get(i).get_y()==y)return i;
        }
        System.out.println("Точка отсутсвтует");
        return -1;
    }
    public double distance(int i, int j){
        double t= Math.pow(array.get(i).get_x()-array.get(j).get_x(),2);
        double p= Math.pow(array.get(i).get_y()-array.get(j).get_y(),2);
        return Math.pow(t+p,0.5);
    }
    public double way(int i, int j){
        double s= 0;
        for (int k = i; k < j; k++) {
            double t= Math.pow(array.get(i).get_x()-array.get(j).get_x(),2);
            double p= Math.pow(array.get(i).get_y()-array.get(j).get_y(),2);
            s+=Math.pow(t+p,0.5);
        }
        return s;
    }
}
