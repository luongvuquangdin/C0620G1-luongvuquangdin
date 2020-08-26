package io_binary_file_serialization.bai_tap.quan_ly;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Management {
        Product product;
        File file;
        int size=0;


    public Management(String file) {
            this.file=new File(file);
            if (this.file.isFile()){
                System.out.println(file+" Already exist : "+this.file.getAbsolutePath());
            }else {
                try {
                    this.file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    public void add(int id, String name, String manufacturer, double price) throws IOException {
        this.product=new Product(id,name,manufacturer,price);
        //mở file để ghi
        FileOutputStream outputStream=null;
        ObjectOutputStream objectOutputStream=null;
        //Ghi vào file
        try {
            outputStream=new FileOutputStream(this.file,true);
            objectOutputStream=new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(this.product);
            size++;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (outputStream!=null){
                outputStream.close();
            }
            if (objectOutputStream!=null){
                objectOutputStream.close();
            }
        }
    }


    public void display()throws IOException,ClassCastException{
        //Mở file ra để hiển thị
        FileInputStream inputStream=null;
        ObjectInputStream objectInputStream=null;
        //display
        try {
            inputStream=new FileInputStream(this.file);
            boolean check=true;
            while (check) {
                try {
                    objectInputStream=new ObjectInputStream(inputStream);
                    this.product = (Product) objectInputStream.readObject();
                    System.out.println(product);
                } catch (EOFException e) {
                   break;
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        //Bắt exception
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (inputStream!=null){
                inputStream.close();
            }
            if (objectInputStream!=null){
                objectInputStream.close();
            }
        }
    }


    public boolean find(String string) throws IOException {
        //Mở file ra để hiển thị
        FileInputStream inputStream=null;
        ObjectInputStream objectInputStream=null;
        //display
        try {
            inputStream=new FileInputStream(this.file);
            boolean isEOFE=true;
            while (isEOFE) {
                try {
                    objectInputStream=new ObjectInputStream(inputStream);
                    this.product = (Product) objectInputStream.readObject();
                    if (this.product.getName().equals(string)){
                        System.out.println(this.product);
                        return true;
                    }
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //Bắt exception
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (inputStream!=null){
                inputStream.close();
            }
            if (objectInputStream!=null){
                objectInputStream.close();
            }
        }
        return false;
    }
}
