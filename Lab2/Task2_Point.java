package Second_kurs;

public class Task2_Point {
    double x, y;
    public Task2_Point(double x, double y){
        this.x = x;
        this.y = y;
    }
    public double get_x(){
        return x;
    }
    public double get_y(){
        return y;
    }
    public void move_point(double dx, double dy){
        x+=dx;
        y+=dy;
    }
}
