package io_text_file.bai_tap.copy_file_text;

import java.io.*;

public class CopyFileText { ;

    public static void copy(File fileSource,File fileTarget){
            FileWriter fileWriter=null;
            FileReader fileReader=null;
            BufferedReader reader=null;
            try{
                fileReader= new FileReader(fileSource);
                reader=new BufferedReader(fileReader);
                fileWriter=new FileWriter(fileTarget);
                String textLine;
                while ((textLine=reader.readLine())!=null){
                    System.out.println(textLine);
                    fileWriter.write(textLine);
                    fileWriter.write("\n");
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fileSource!=null){
                    try {
                        fileReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fileTarget!=null){
                    try {
                        fileWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
       }
    }
