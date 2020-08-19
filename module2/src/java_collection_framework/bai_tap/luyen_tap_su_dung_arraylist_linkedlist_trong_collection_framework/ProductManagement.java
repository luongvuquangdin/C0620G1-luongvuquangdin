package java_collection_framework.bai_tap.luyen_tap_su_dung_arraylist_linkedlist_trong_collection_framework;

import java.util.ArrayList;
import java.util.List;

public class ProductManagement{
    //Tạo một ArrayList để lưu trữ các product
    private List<Product> products;

    //Constructor
    public ProductManagement(ArrayList product){
       this.products=product;
    }
    public ProductManagement(){
        this.products=new ArrayList<>();
    }

    //Thêm một product
    public void add(int id,String nameProduct,double price){
        for (int i=0;i<products.size();i++){
            if (products.get(i).getId()==id){
                System.out.println("Id: "+id+" already");
                return;
            }
        }
        products.add(new Product(id,nameProduct,price));
    }


    //sửa tên product theo id
    public void edit(int id,String nameEdit){
        if (products.size() == 0) {
            System.out.println("Product Null");
            return;
        }
        for (int i=0;i<products.size();i++){
            if(products.get(i).getId()==id){
                products.get(i).setName(nameEdit);
                System.out.println("Name of id: "+id+" was edited");
                return;
            }
        }
        System.out.println("No id: "+id);
    }
    //sửa giá product theo id
    public void edit(int id,double price){
        if (products.size()==0) {
            System.out.println("Product Null");
            return;
        }
        for (int i=0;i<products.size();i++){
            if(products.get(i).getId()==id){
                products.get(i).setPrice(price);
                System.out.println("Price of id: "+id+" was edited");
                return;
            }
        }
        System.out.println("No id: "+id);
    }

    //sửa tên và giá product theo id
    public void edit(int id,String name,double price){
        if (products.size()==0) {
            System.out.println("Product Null");
            return;
        }
        for (int i=0;i<products.size();i++){
            if(products.get(i).getId()==id){
                products.get(i).setPrice(price);
                products.get(i).setName(name);
                System.out.println("Price and name of id: "+id+" was edited");
                return;
            }
        }
        System.out.println("No id: "+id);
    }

    //Xóa product theo id
    public void delete(int id){
        if (products.size() == 0) {
            System.out.println("Product Null");
            return;
        }
        for (int i=0;i<products.size();i++){
            if(products.get(i).getId()==id){
                products.remove(i);
                System.out.println("this id: "+id+" was deleted");
                return;
            }
        }
        System.out.println("No id: "+id);
    }


    //Hiển thị danh sách product theo id
    public void display(){
        if (products.size()==0){
            System.out.println("Product Null");
        }else {
            for (int i=0;i<products.size();i++){
                Product product=products.get(i);
                System.out.println(product);
            }
        }
    }

    public List<Product> getProducts() {
        return products;
    }

}
