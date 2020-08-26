package io_text_file.bai_tap.optional_doc_file_csv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadCsv {
    public static void main(String[] args) throws IOException {
        FileReader file=null;
        BufferedReader reader=null;
        try {
            file = new FileReader("csv");
            reader=new BufferedReader(file);
            String str;
            String[] String=null;
            while ((str=reader.readLine())!=null){
                String=str.split(",");
                System.out.println(String[String.length-1]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (file!=null){
                    file.close();
            }
            if (reader!=null){
                reader.close();
            }
        }
    }
}
