package ru.itmo.lessons.lesson22.decorator;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Decoder extends FilterInputStream {
    private String key;

    public Decoder(InputStream filestream, String key) {
        super(filestream);
        this.key = key;
    }

    @Override
    public int read(byte[] b) throws IOException {
        int count = super.read(b);
        for (int i = 0; i <  b.length; i++)
            b[i] = (byte) (b[i]^key.getBytes()[i % key.getBytes().length]);
        return count;
    }
}
