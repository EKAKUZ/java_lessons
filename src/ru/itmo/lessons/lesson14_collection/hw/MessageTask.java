package ru.itmo.lessons.lesson14_collection.hw;

import jdk.swing.interop.SwingInterOpUtils;
import ru.itmo.lessons.lesson14_collection.Student;

import java.util.*;

public class MessageTask {
    public static void countEachPriority(List<Message> messageList) {
        /*for (MessagePriority msgPriority : MessagePriority.values()) {
            int count = 0;
            for (Message msg : messageList) {
                if (msg.getPriority() == msgPriority) {
                    count ++;
                }
            }
            System.out.println(msgPriority + ": " + count);
        }*/
        // TODO:  Подсчитать количество сообщений для каждого приоритета
        //  Ответ в консоль
        int[] counts =new int[MessagePriority.values().length];
        for (Message message: messageList){
            counts[message.getPriority().ordinal()] ++;
        }
        System.out.println(Arrays.toString(counts));
    }

    public static void countEachCode(List<Message> messageList) { //ЕСЛИ ЭТУ ЗАДАЧУ НЕ РАЗБИРАЛИ - СПРОСИТЬ
        List<Integer> msgCodes = new ArrayList<>();
        List<Integer> msgCodesCount = new ArrayList<>();
        for (Message msg : messageList) {
            if (msgCodes.contains(msg.getCode())) {
                int i = msgCodes.indexOf(msg.getCode());
                msgCodesCount.set(i, msgCodesCount.get(i) + 1);
            }
            else {
                msgCodes.add(msg.getCode());
                msgCodesCount.add(1);
            }
        }
        for (int code : msgCodes) {
            System.out.println(code + " : " + msgCodesCount.get(msgCodes.indexOf(code)));
        }
        // TODO: Подсчитать количество сообщений для каждого кода сообщения
        //  Ответ в консоль
    }

    public static void uniqueMessageCount(List<Message> messageList) {
        /*List<Message> uniqMsg = new ArrayList<>();
        for (Message msg : messageList) {
            if (!uniqMsg.contains(msg)) uniqMsg.add(msg);
        }
        System.out.println("Найдено " + uniqMsg.size() + " уникальных сообщений");*/
        System.out.println(new HashSet<>(messageList).size());
        // TODO: Подсчитать количество уникальных сообщений
        //  Ответ в консоль
    }

    public static List<Message> uniqueMessagesInOriginalOrder(List<Message> messageList) {
        /*List<Message> uniqMsg = new ArrayList<>();
        for (Message msg : messageList) {
            if (!uniqMsg.contains(msg)) uniqMsg.add(msg);
        }
        return uniqMsg;*/
        // TODO: вернуть только неповторяющиеся сообщения и в том порядке,
        //  в котором они встретились в первоначальном списке
        //  Например, было: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}, {HIGH, 9}]
        //  на выходе: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}]

        return new ArrayList<>(new LinkedHashSet<>(messageList));
    }

    public static void removeEach(List<Message> messageList, MessagePriority priority) {
        System.out.println(messageList);
        Iterator<Message> iterator = messageList.listIterator();
        while (iterator.hasNext()) { //пока есть следующий
            if (iterator.next().getPriority() == priority) //возвращает ссылку на эелемент коллекции
                iterator.remove();
        }
        System.out.println(messageList);
        // TODO: удалить из коллекции каждое сообщение с заданным приоритетом
        //  вывод в консоль до удаления и после удаления
    }

    public static void removeOther(List<Message> messageList, MessagePriority priority) {
        // TODO: удалить из коллекции все сообщения, кроме тех, которые имеют заданный приоритет
        //  вывод в консоль до удаления и после удаления
        System.out.println(messageList);
        Iterator<Message> iterator = messageList.listIterator();
        while (iterator.hasNext()) { //пока есть следующий
            if (iterator.next().getPriority() != priority) //возвращает ссылку на эелемент коллекции
                iterator.remove();
        }
        System.out.println(messageList);
    }

}
