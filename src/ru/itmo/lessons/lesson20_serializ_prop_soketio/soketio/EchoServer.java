package ru.itmo.lessons.lesson20_serializ_prop_soketio.soketio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

interface Command{
    void execute() throws IOException;

    static Command getCommand(SimpleMessage message, EchoServer server){
        if ("count".equalsIgnoreCase(message.getText())) {
            //return new Count(message, server);
            return () -> {
                try {
                    server.getConnection().sendMessage(SimpleMessage.
                            getMessage("server", "Установлено " +
                                    server.getCountConnection() + " соединений"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            };
        }
        else if ("ping".equalsIgnoreCase(message.getText())) {
            return new Ping(message, server);
        }
        else if ("help".equalsIgnoreCase(message.getText())) {
            return new Help(message, server);
        }
        else if ("exit".equalsIgnoreCase(message.getText())) {
            return new Exit(message, server);
        }
        else {
            return new Error(message, server);
        }
    }
}

class Count implements Command{
    SimpleMessage message;
    EchoServer server;

    public Count(SimpleMessage message, EchoServer server) {
        this.message = message;
        this.server = server;
    }

    @Override
    public void execute()  {
        try {
            server.getConnection().sendMessage(SimpleMessage.getMessage("server", "Установлено " + server.getCountConnection() + " соединений"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class Ping implements Command{
    SimpleMessage message;
    EchoServer server;

    public Ping(SimpleMessage message, EchoServer server) {
        this.message = message;
        this.server = server;
    }
    @Override
    public void execute() {
        try {
            server.getConnection().sendMessage(SimpleMessage.getMessage("server", "Ответ " + message.getSender() + " "));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class Help implements Command{
    SimpleMessage message;
    EchoServer server;

    public Help(SimpleMessage message, EchoServer server) {
        this.message = message;
        this.server = server;
    }
    @Override
    public void execute() {
        try {
            server.getConnection().sendMessage(SimpleMessage.getMessage("server", "\n help Выводит список доступных команд \n " +
                    "count Показывает колличество уставновленных соединений \n " +
                    "ping Рассчитывает время приема-передачи в мс \n" +
                    "exit Останавливает соединение \n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Exit implements Command{
    SimpleMessage message;
    EchoServer server;

    public Exit(SimpleMessage message, EchoServer server) {
        this.message = message;
        this.server = server;
    }
    @Override
    public void execute() {
        try {
            server.getConnection().sendMessage(SimpleMessage.getMessage("server", "Остановка соединения"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Error implements Command{
    SimpleMessage message;
    EchoServer server;

    public Error(SimpleMessage message, EchoServer server) {
        this.message = message;
        this.server = server;
    }
    @Override
    public void execute() {
        try {
            server.getConnection().sendMessage(SimpleMessage.getMessage("server", "Неизвестная комманда"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//----------------------------------------------------------------------------------------------------------------------
public class EchoServer {
    private int port;
    private Connection connection;
    private int countConnection;

    public Connection getConnection() {
        return connection;
    }

    public int getCountConnection() {
        return countConnection;
    }

    public EchoServer(int port){
        this.port = port;
    }

    public void start() throws IOException, ClassNotFoundException {
        try (ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Server started...");
            while (true){
                Socket socket = serverSocket.accept(); // установка канала связи
                //для многопоточности здесь нужно создавать новое соединение для каждого клиента
                connection = new Connection(socket);
                countConnection++;
                SimpleMessage message = connection.readMessage();
                System.out.println(message);
                Command.getCommand(message, this).execute();
            }
        }
    }
    private String countClient() {
        return "Колличество подключенных клиентов: " + countConnection;
    }

    private void printMessage(SimpleMessage message){
        System.out.println("получено сообщение: " + message);
    }

    public static void main(String[] args) {
        int port = 8090;
        EchoServer messageServer = new EchoServer(port);
        try {
            messageServer.start();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}