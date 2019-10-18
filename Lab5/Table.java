package Second_kurs;

public class Table {
    String name ;
    String name_book;
    int pages;
    public Table(String name, String name_book, int pages){
        this.name=name;
        this.name_book=name_book;
        this.pages=pages;
    }
    public Table() {
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName_book(){
        return name_book;
    }
    public void setName_book(String name_book){
        this.name_book=name_book;
    }
    public int getPages(){
        return pages;
    }
    public void setPages(int pages){
        this.pages=pages;
    }
    public String toString(){
        return "author = "+ name + "\nbook = " + name_book + "\npages = "+ pages;
    }
}
