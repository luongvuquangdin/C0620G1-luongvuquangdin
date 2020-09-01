package casestudy.furama_resort.commons;

import casestudy.furama_resort.models.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ReadNameFileNotDuplicate {
    //Read Villa
    public static Map<String,Services> readVilla(String file){
        Map<String,Services> treeMap=new TreeMap<>();
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
                treeMap.put(villa.getNameServices(),villa);
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
        return treeMap;
    }

    //Read House
    public static Map<String,Services> readHouse(String file){
        Map<String,Services> treeMap=new TreeMap<>();
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
                treeMap.put(house.getNameServices(),house);
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
        return treeMap;
    }


    //Read Room
    public static Map<String,Services> readRoom(String file){
        Map<String,Services> treeMap=new TreeMap<>();
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
                treeMap.put(room.getNameServices(),room);
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
        return treeMap;
    }

    public static Map<String, Employee> readEmployee(String file){
        Map<String,Employee> linkedHashMap=new LinkedHashMap<>();
        Employee employee=null;
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
                employee=new Employee(string[0],string[1],string[2],string[3]);
                linkedHashMap.put(employee.getId(),employee);
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
        return linkedHashMap;
    }

}
