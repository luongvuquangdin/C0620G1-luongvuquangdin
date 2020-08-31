package casestudy.furama_resort.commons;

import casestudy.furama_resort.models.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

    //    //get all Villa
    public static List<Services> getAllVilla(String file){
        List<Services> listVila=new ArrayList<>();
        Villa villa=null;
        FileReader reader=null;
        BufferedReader bfReader=null;
        try {
            reader=new FileReader(file);
            bfReader=new BufferedReader(reader);
            String str=null;
            String[] string=null;
            str=bfReader.readLine();
            while ((str=bfReader.readLine())!=null){
                string=str.split(",");
                villa=new Villa(string[0],string[1],Double.parseDouble(string[2]),Double.parseDouble(string[3])
                        ,Integer.parseInt(string[4]),string[5],string[6],string[7],Double.parseDouble(string[8])
                        ,Integer.parseInt(string[9]));
                listVila.add(villa);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bfReader!=null){
                try {
                    bfReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return listVila;

    }
    //get all House
    public static List<Services> getAllHouse(String file){
        List<Services> listHouse=new ArrayList<>();
        House house=null;
        FileReader reader=null;
        BufferedReader bfReader=null;
        try {
            reader=new FileReader(file);
            bfReader=new BufferedReader(reader);
            String str=null;
            String[] string=null;
            str=bfReader.readLine();
            while ((str=bfReader.readLine())!=null){
                string=str.split(",");
                house=new House(string[0],string[1],Double.parseDouble(string[2]),Double.parseDouble(string[3])
                        ,Integer.parseInt(string[4]),string[5],string[6],string[7],Integer.parseInt(string[8]));
                listHouse.add(house);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bfReader!=null){
                try {
                    bfReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return listHouse;
    }

      //get all Room
      public static List<Services> getAllRoom(String file){
        List<Services> listRoom=new ArrayList<>();
        Room room=null;
        FileReader reader=null;
        BufferedReader bfReader=null;
        try {
            reader=new FileReader(file);
            bfReader=new BufferedReader(reader);
            String str=null;
            String[] string=null;
            str=bfReader.readLine();
            while ((str=bfReader.readLine())!=null){
                string=str.split(",");
                room=new Room(string[0],string[1],Double.parseDouble(string[2]),Double.parseDouble(string[3])
                        ,Integer.parseInt(string[4]),string[5],string[6]);
                listRoom.add(room);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bfReader!=null){
                try {
                    bfReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return listRoom;
    }

    //Get data Customer in file
public static List<Customer> getAllCustomer(String file){
        List<Customer> listCustomer=new ArrayList<>();
        Customer customer=null;
        FileReader reader=null;
        BufferedReader bfReader=null;
        try {
            reader=new FileReader(file);
            bfReader=new BufferedReader(reader);
            String str=null;
            String[] string=null;
            str=bfReader.readLine();
            while ((str=bfReader.readLine())!=null){
                string=str.split(",");
                customer=new Customer(string[0],string[1],string[2],string[3],string[4],string[5],string[6]
                        ,string[7]);
                listCustomer.add(customer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bfReader!=null){
                try {
                    bfReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return listCustomer;
    }

}
