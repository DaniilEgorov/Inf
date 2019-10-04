package Second_kurs;

public class Iterator_2 {
    public static void main(String[] args) {
        Task2_Plane plane = new Task2_Plane();
        plane.add_point(1,1);
        plane.add_point(-3,2);
        plane.add_point(4,5);
        plane.add_point(0,2);
        plane.add_point(-2,-4);
        for(Task2_Point p : plane){
            System.out.println("x = "+p.get_x()+"  y = "+p.get_y());
        }
    }
}
