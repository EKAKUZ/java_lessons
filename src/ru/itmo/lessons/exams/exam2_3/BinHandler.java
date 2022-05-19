package ru.itmo.lessons.exams.exam2_3;

import java.io.*;

public class BinHandler {
    private File file = new File("exam2.bin");

    public BinHandler() {}

    public BinHandler(File file) {
        this.file = file;
    }

    public boolean writeToFile(String str) {
        boolean result = false;
        try (FileOutputStream fileOutput = new FileOutputStream(file)) {
            fileOutput.write(str.getBytes()); // здесь будет ошибка,
            // если не имплементирован интерфейс сериализации
            return true;
            // обьект превращается в последовательность байт (objectOutput)
            // последовательность байт записывается в файл (fileOutput)
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public String readFromFile() {
        String result = null;

        try (FileInputStream fileInput = new FileInputStream(file);
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream()){
            byteArray.write(fileInput.readAllBytes());

            result = byteArray.toString();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

}