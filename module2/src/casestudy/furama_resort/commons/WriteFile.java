package casestudy.furama_resort.commons;

import casestudy.furama_resort.models.Customer;
import casestudy.furama_resort.models.Services;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
    public static void writerServices(String file, Services name){
        FileWriter writer=null;
        BufferedWriter bufferedWriter=null;
        StringBuilder string=null;
        try {
            //Mở file để ghi
            writer=new FileWriter(file,true);
            bufferedWriter=new BufferedWriter(writer);

            //Tạo ra một chuỗi để ghi vào file
            string=new StringBuilder();
            string=string.append(name.toString()).append("\n");

            //Ghi File
            bufferedWriter.write(string.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //Đóng file
            if (bufferedWriter!=null){
                try {
                    bufferedWriter.flush();
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (writer!=null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            }
        }
    }

    public static void writerCustomer(String file, Customer name){
        FileWriter writer=null;
        BufferedWriter bufferedWriter=null;
        StringBuilder string=null;
        try {
            //Mở file để ghi
            writer=new FileWriter(file,true);
            bufferedWriter=new BufferedWriter(writer);

            //Tạo ra một chuỗi để ghi vào file
            string=new StringBuilder();
            string=string.append(name.toString()).append("\n");

            //Ghi File
            bufferedWriter.write(string.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //Đóng file
            if (bufferedWriter!=null){
                try {
                    bufferedWriter.flush();
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (writer!=null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            }
        }
    }

    //    //Write Head in file
    public static void writerHead(String linkFile, String head) {
        File file=new File(linkFile);
        if (file.length() == 0) {
            FileWriter writer = null;
            BufferedWriter bufferedWriter = null;
            StringBuilder string = null;
            try {
                //Mở file để ghi
                writer = new FileWriter(file,true);
                bufferedWriter = new BufferedWriter(writer);

                //Tạo ra một chuỗi để ghi vào file
                string = new StringBuilder();
                string = string.append(head).append("\n");

                //Ghi File
                bufferedWriter.write(string.toString());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                //Đóng file
                if (bufferedWriter != null) {
                    try {
                        bufferedWriter.flush();
                        bufferedWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (writer != null) {
                        try {
                            writer.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    //Write Booking
    public static void writerBooking(String file, Customer name){
        FileWriter writer=null;
        BufferedWriter bufferedWriter=null;
        StringBuilder string=null;
        try {
            //Mở file để ghi
            writer=new FileWriter(file,true);
            bufferedWriter=new BufferedWriter(writer);
            //Tạo ra một chuỗi để ghi vào file
            string=new StringBuilder();
            string=string.append(name.toString()).append(",").append(name.getServices().toString()).append("\n");
            //Ghi File
            bufferedWriter.write(string.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //Đóng file
            if (bufferedWriter!=null){
                try {
                    bufferedWriter.flush();
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (writer!=null){
                    try {
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
