package java_collection_framework.bai_tap.luyen_tap_su_dung_arraylist_linkedlist_trong_collection_framework;

public class Product implements Comparable<Product>{
    private int id;
    private String name;
    private double price;

    public Product(int id, String name,double price) {
        this.id = id;
        this.name = name;
        this.price=price;
    }
    public Product(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return "id = "+id+" name = "+name+" price = "+price;
    }
//Sắp xếp theo thứ tự tăng dần theo giá
    @Override
    public int compareTo(Product o) {
        double checkSort=this.price-o.price;
        if (checkSort>0){
            return 1;
        }
        else if(checkSort<0){
            return -1;
        }
        return 0;
    }

}
