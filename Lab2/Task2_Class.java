package Second_kurs;

public class Task2_Class {
    String [] data;
    String line;
    public Task2_Class(String  line) {
        this.line=line;
        this.data=line.split(" ");
    }
    public String person_surname(){
        return data[0];
    }
    public String person(){
        return data[1];
    }
    public String gender(){
        return data[2];
    }
    public String birthday(){
        return data[3];
    }
}
