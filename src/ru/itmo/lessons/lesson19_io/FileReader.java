package ru.itmo.lessons.lesson19_io;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Scanner;


public class FileReader {

    //java.io
    //java.nio

    //File  - класс для работы с файлами
    // new File(файл или директория)
    // нет возможностей читать из файла или писать в файл

    // программа        источник(файл)
    //InputStream OutputStream - интерфейсы отвечающие за чтение/запись байтовых данных (поток байт)

    //Reader Writer (char)

    //FileInputStream / FileOutputStream
    //ObjectInputStream / ObjectOutputStream - создает последовательность байт из обьекта

    //FileInputStream(ObjectInputStream(обьект))
    //FileInputStream(CustomInputStrem(ObjectInputStream(обьект)))
    //CustomInputStrem - наследник абстрактного FilterInputStream

    public static boolean writeToFile(byte[] data, File file)  /*throws FileNotFoundException */ {
        // если соединение с источником пропишем в круглых скобках try,
        // то закрытие произойдет автоматически
        // закрывается если
        // инструкции блока try  выполнены без ошибок
        // в блоке try произошла ошибка
        // Ресурсы буду закрыты до перехода в catch

        // если класс обьект которого создается в круглых скобках try,
        // должен имплементировать AutoClosable interfece
        // и его абстрактный метод void close()

        boolean result = false;
        try (FileOutputStream fileOutput = new FileOutputStream (file, true)){
            // false - перезаписать file
            // true - дозаписать file
            fileOutput.write(data);
            result = true;
        } catch (FileNotFoundException e) {
            System.out.println("Не удалось использовать файл");
        }  catch (IOException e) { //FileNotFoundException - наследник IOException
            System.out.println("Не удалось записать данные в файл");
        }
        return result;
        /*
        catch (IOException e) { //FileNotFoundException - наследник IOException, поэтому такой обработки достаточно
            System.out.println("Не удалось записать данные в файл");
        }
         */

        //или
        /*
        FileOutputStream fileOutput
        try {
            fileOutput = new FileOutputStream(file, true

        }
        finally {
            fileOutput.Close();
        }
        // закрытие соединения происходит после выполнения блока Catch
         */

    }

    public static byte[] readFromFile  (File file) {
        byte[] result = null;

        try (FileInputStream fileInput = new FileInputStream (file)){

            result = fileInput.readAllBytes();

        } catch (FileNotFoundException e) {
            System.out.println("Не удалось найти/открыть файл");
        }  catch (IOException e) {
            System.out.println("Не удалось прочитать данные из файла");
        }

        return result;
    }

    public static boolean writeFromConsole(File file){
        boolean result =false;
        // в круглых скобках try можно создать несколько обьектов, через ;
        // основной функционал
        try(FileOutputStream fileOutput = new FileOutputStream(file,  true);
            // декоратор
            BufferedOutputStream buffered = new BufferedOutputStream(fileOutput)){ //8192 байт поумолчанию

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Введите данные или stop для выхода!");
                String userInput = scanner.nextLine();
                if ("stop".equalsIgnoreCase(userInput)) break;
                buffered.write(userInput.getBytes()); //преобразование строки в байты
                // декоратор типа OutputStream после накоплениях данных вызывает write,
                // того обьекта, который передан переменной
            }

            result = true;

        }  catch (IOException e) {
            System.out.println("Не удалось записать данные в файл");
        }

        return result;
    }

    public static String readWithBuffer  (File file) {

        String result = null;

        try (FileInputStream fileInput = new FileInputStream (file);
            BufferedInputStream bufferedInput = new BufferedInputStream(fileInput);
            ByteArrayOutputStream byteArray = new ByteArrayOutputStream()){

            byte[] buffer = new byte[300];
            int count;

            while ((count = bufferedInput.read(buffer)) != -1) { // -1 - буфер(файл) закончился
                byteArray.write(buffer,0,count);

            }

            result = byteArray.toString(); //new String(byteArray.toString());

        }   catch (IOException e) {
            System.out.println("Ошибка чтения");
        }

        return result;

    }

    public static boolean byteArrayToImage(File file, byte[] bytes) throws IOException{

        ByteArrayInputStream byteArray = new ByteArrayInputStream(bytes);
        BufferedImage image = ImageIO.read(byteArray);
        return ImageIO.write(image, "png", file);

    }

    public static byte[] imageToBytes(File file) throws IOException{
        BufferedImage image = ImageIO.read(file);
        ByteArrayOutputStream arrayOutput = new ByteArrayOutputStream();
        ImageIO.write(image, "png", arrayOutput);
        return arrayOutput.toByteArray();
    }


    // разобраться с классом Properties
    // как хранит данные, как добавить данные, как получить данные

    //file.properties
    // как прочитать данные из properties файл  в экземпляр Properties


}
