package java_collection_framework.bai_tap.luyen_tap_su_dung_arraylist_linkedlist_trong_collection_framework;

import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ProductManagement productManagement=new ProductManagement();
        productManagement.add(1,"Khanh",23);
        productManagement.add(3,"Chau",24);
        productManagement.add(2,"Cuong",25);
        productManagement.add(4,"Nam",21);
        productManagement.add(5,"Nu",22);
        productManagement.delete(5);
        productManagement.edit(3,"Bun");
        System.out.println("Danh sách sản phẩm trước khi sắp xếp là: ");
        productManagement.display();
        System.out.println("________________________________________");
        System.out.println("Danh sách sản phẩm sau khi sắp xếp tăng dần là: ");
        Collections.sort(productManagement.getProducts());
        productManagement.display();
        System.out.println("________________________________________");
        System.out.println("Danh sách sản phẩm sau khi sắp xếp giảm dần là: ");
        Collections.reverse(productManagement.getProducts());
        productManagement.display();
    }
}
