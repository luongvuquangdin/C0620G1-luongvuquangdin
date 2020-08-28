package io_binary_file_serialization.bai_tap.quan_ly;

import java_collection_framework.thuc_hanh.sap_xep_voi_comparator_va_comparable.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Management {
    Product product;
    //Source file
    File file;
    //Save Object Product
    List<Product> list;


    public Management(String file) {
        this.list = new ArrayList<>();
        this.file = new File(file);
        if (this.file.isFile()) {
            System.out.println(file + " Already exist : " + this.file.getAbsolutePath());
        } else {
            try {
                this.file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //get data in file for list
    private void getFile() {
        if (this.file.length() == 0) {
            return;
        }
        ObjectInputStream oOS = null;
        try {
            oOS = new ObjectInputStream(new FileInputStream(this.file));
            this.list = (List<Product>) oOS.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (oOS != null) {
                try {
                    oOS.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void add() {
        this.getFile();
        this.product = new Product();
        product.input();
        list.add(this.product);
        ObjectOutputStream oIS = null;
        try {
            oIS = new ObjectOutputStream(new FileOutputStream(this.file));
            oIS.writeObject(this.list);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oIS != null) {
                try {
                    oIS.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    //display
    public void display() {
        this.getFile();
        if (this.list.size() == 0) {
            System.out.println("File Null");
            return;
        }
        ObjectInputStream oOS = null;
        try {
            oOS = new ObjectInputStream(new FileInputStream(this.file));
            this.list = (List<Product>) oOS.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (oOS != null) {
                try {
                    oOS.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        for (Product product : this.list) {
            System.out.println(product);
        }
    }

    //Search
    public boolean Search(String name) {
        this.getFile();
        for (Product product : this.list) {
            if (product.getName().equals(name)) {
                System.out.println(product);
                return true;
            }
        }
        System.out.println(name + " doesn't exist");
        return false;

    }
}
