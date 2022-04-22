package ru.itmo.lessons.lesson22.decorator;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) throws IOException {
        byte[] b = {1,2,3,4,5,6};
        byte[] a = new byte[b.length];
        String key = "qwerty";
        
        FileOutputStream fileOutputStream = new FileOutputStream("file.txt");
        Coder coder = new Coder(fileOutputStream,key);
        coder.write(b);


        FileInputStream fileInputStream = new FileInputStream("file.txt");
        Decoder decoder = new Decoder(fileInputStream,key);
        decoder.read(a);
        System.out.println(Arrays.toString(a));
    }
}
