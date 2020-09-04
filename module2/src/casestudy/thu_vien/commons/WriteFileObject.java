package casestudy.thu_vien.commons;

import casestudy.thu_vien.models.Entities;

import java.io.*;
import java.util.List;

public class WriteFileObject {
    private static final String FILE_DICTIONARY="D:\\New folder\\C0620G1-luongvuquangdin\\module2\\src\\" +
            "casestudy\\thu_vien\\data\\Dictionary.txt";

    public static void write(List<Entities> list){
        FileOutputStream file=null;
        ObjectOutputStream oOS =null;
        try {
            file=new FileOutputStream(FILE_DICTIONARY);
            oOS=new ObjectOutputStream(file);
            oOS.writeObject(list);
        }catch (FileNotFoundException e) {
            System.out.println("File don't exits");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (oOS!=null){
                try {
                    oOS.flush();
                    oOS.close();
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
    }
}
