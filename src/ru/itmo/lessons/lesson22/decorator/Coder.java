package ru.itmo.lessons.lesson22.decorator;


import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Coder extends FilterOutputStream {
    private String key;
    public Coder(OutputStream filestream, String key) {
        super(filestream);
        this.key = key;
    }

    @Override
    public void write(byte[] b) throws IOException {

        for (int i = 0; i <  b.length; i++) {
            //b[i] = (byte) (b[i]^key.getBytes()[i % key.getBytes().length]);
            b[i] = (byte) (b[i]^key.charAt(i % (key.length())));
        }
        super.write(b);
    }
}
