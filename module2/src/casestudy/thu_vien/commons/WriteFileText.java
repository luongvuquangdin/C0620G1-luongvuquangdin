package casestudy.thu_vien.commons;

import casestudy.thu_vien.models.Entities;

import java.io.*;
import java.util.List;

public class WriteFileText {
    private static final String COMMA=",";
    private static final String ENTER="\n";
    public static void write(List<Entities> list, String LinkFile){
        FileWriter file=null;
        BufferedWriter bufferedWriter =null;
        StringBuilder string=null;
        Entities entities=new Entities();
        try {
            file=new FileWriter(LinkFile);
            bufferedWriter=new BufferedWriter(file);
            for (int i=0;i<list.size();i++){
                string=new StringBuilder();
                entities=list.get(i);
                string.append(entities.getKeyword()).append(COMMA);
                string.append(entities.getType()).append(COMMA);
                string.append(entities.getMean()).append(ENTER);
                bufferedWriter.write(string.toString());
            }
        }catch (FileNotFoundException e) {
            System.out.println("File don't exits");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bufferedWriter!=null){
                try {
                    bufferedWriter.flush();
                    bufferedWriter.close();
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
