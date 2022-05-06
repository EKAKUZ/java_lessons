package ru.itmo.lessons.lesson20_serializ_prop_soketio.soketio;

import java.io.IOException;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

interface Answer{
    void execute() throws IOException;

    static Answer getAnswer(SimpleMessage message, Client client){
        if ("ping".equalsIgnoreCase(message.getText())) {
            return new PingAnswer(message, client);
        }
        else if ("exit".equalsIgnoreCase(message.getText())) {
            return new ExitAnswer(message, client);
        }
        else {
            return new ServerAnswer(message, client);
        }
    }
}

class PingAnswer implements Answer{
    SimpleMessage message;
    Client client;
    public PingAnswer(SimpleMessage message, Client client) {
        this.message = message;
        this.client = client;
    }

    @Override
    public void execute()  {
        try (Connection connection = new Connection(client.getSocket())){ // getSocket Только для того, чтобы посмотреть методы сокета
            connection.sendMessage(message);

            SimpleMessage fromServer = connection.readMessage();
            System.out.println("ответ от сервера: " + fromServer);
            LocalDateTime outTime = message.getDateTime();
            LocalDateTime  inTime = LocalDateTime.now();// fromServer.getDateTime();
            System.out.println("ping time / время приема-передачи : " + ChronoUnit.MILLIS.between(outTime, inTime) + " мc");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ExitAnswer implements Answer{
    SimpleMessage message;
    Client client;
    public ExitAnswer(SimpleMessage message, Client client) {
        this.message = message;
        this.client = client;
    }

    @Override
    public void execute()  {
        try (Connection connection = new Connection(client.getSocket())){ // getSocket Только для того, чтобы посмотреть методы сокета
            connection.sendMessage(message);

            SimpleMessage formServer = connection.readMessage();
            System.out.println("ответ от сервера: " + formServer);
            client.setEx(false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ServerAnswer implements Answer{
    SimpleMessage message;
    Client client;
    public ServerAnswer(SimpleMessage message, Client client) {
        this.message = message;
        this.client = client;
    }

    @Override
    public void execute()  {
        try (Connection connection = new Connection(client.getSocket())){ // getSocket Только для того, чтобы посмотреть методы сокета
            connection.sendMessage(message);

            SimpleMessage formServer = connection.readMessage();
            System.out.println("ответ от сервера: " + formServer);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
//------------------------------------------------------------------------------------------------------------------
public class Client {

    private int port;
    private String ip;
    private Scanner scanner;
    private LocalTime time;
    private boolean ex = true;

    public boolean isEx() {
        return ex;
    }

    public void setEx(boolean ex) {
        this.ex = ex;
    }

    public Client(int port, String ip) {
        this.port = port;
        this.ip = ip;
        scanner = new Scanner(System.in);
    }


    public void start() throws Exception {
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        String messageText;

        while (isEx()){
            System.out.println("Введите сообщение");
            messageText = scanner.nextLine();

            Answer.getAnswer(SimpleMessage.getMessage(name, messageText), this).execute();
            //sendAndPrintMessage(SimpleMessage.getMessage(name, messageText));
        }
    }


    private void sendAndPrintMessage(SimpleMessage message) throws Exception {
        try (Connection connection = new Connection(getSocket())){ // getSocket Только для того, чтобы посмотреть методы сокета
            connection.sendMessage(message);

            SimpleMessage formServer = connection.readMessage();
            System.out.println("ответ от сервера: " + formServer);

            /* if ("exit".equalsIgnoreCase(message.getText())) setEx(false);
            if ("ping".equalsIgnoreCase(message.getText())) {
                LocalDateTime outTime = message.getDateTime();
                LocalDateTime  inTime = formServer.getDateTime();
                System.out.println("ping time / время приема-передачи : " + ChronoUnit.MILLIS.between(outTime, inTime) + " мc");
            }*/
        }
    }

    /*private Socket getSocket() throws IOException {
        Socket socket = new Socket(ip, port);
        return socket;
    }*/

    public Socket getSocket() throws IOException {
        Socket socket = new Socket(ip, port);
        return socket;
    } //сокет устанавливает соединение

    public static void main(String[] args) {
        int port = 8090;
        String ip = "127.0.0.1";

        try {
            new Client(port, ip).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}