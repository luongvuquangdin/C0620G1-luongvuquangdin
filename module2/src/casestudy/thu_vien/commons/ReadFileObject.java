package casestudy.thu_vien.commons;

import casestudy.thu_vien.models.Entities;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFileObject {
    private static final String FILE_DICTIONARY="D:\\New folder\\C0620G1-luongvuquangdin\\module2\\src\\" +
            "casestudy\\thu_vien\\data\\Dictionary.txt";

    public static List<Entities> read(){
        List<Entities> list_1=new ArrayList<>();
        FileInputStream file=null;
        ObjectInputStream oIS =null;
        try {
            file=new FileInputStream(FILE_DICTIONARY);
            oIS=new ObjectInputStream(file);
            list_1= (List<Entities>) oIS.readObject();
        }catch (FileNotFoundException e) {
            System.out.println("File don't exits");
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
            System.out.println("File null");
        } finally {
            if (oIS!=null){
                try {
                    oIS.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (file!=null){
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return list_1;
    }
}
