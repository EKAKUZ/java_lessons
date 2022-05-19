package ru.itmo.lessons.exams.exam2_3.Pattern;

import ru.itmo.lessons.exams.exam2_3.*;

import java.io.File;
import java.util.Scanner;

public class ReceiverMenu {
    private final GameStep gameStep;

    public ReceiverMenu(GameStep gameStep){
        this.gameStep = gameStep;
    }

    public int start(){
        System.out.println();
        System.out.println("���� ��������");
        System.out.println("-------------------------------------------------");
        gameStep.setStepKey("key1");
        gameStep.setGameStarted(true);
        return 2;
    }

    public int save(){

        if (!gameStep.isGameStarted()) {
            System.out.println("������� ������������ ����������. ��������� ����!");
        }
        else
        {
            System.out.println();
            System.out.println("���������� ����");
            System.out.println("-------------------------------------------------");
            System.out.println("������� ��� �����");
            Scanner in = new Scanner(System.in);

            String fileName = in.nextLine().replaceAll(" +", "");
            if (fileName.equalsIgnoreCase("")) fileName = "exam2";

            File file = new File(fileName + ".bin");
            BinHandler handler = new BinHandler(file);

            if (handler.writeToFile(gameStep.getStepKey())) {
                System.out.println("��������� ���� ������� ���������� � ���� " + fileName + ".bin");
            }
            else System.out.println("��������� ���� �� ������� ��������� � ���� " + fileName + ".bin");
            System.out.println("-------------------------------------------------");
        }
        return 1;
    }

    public int load(){
        System.out.println();
        System.out.println("�������� ����");
        System.out.println("-------------------------------------------------");
        System.out.println("������� ��� �����");
        Scanner in = new Scanner(System.in);

        String fileName = in.nextLine().replaceAll(" +","");
        if (fileName.equalsIgnoreCase("")) fileName="exam2";

        File file = new File(fileName +".bin");

        BinHandler handler = new BinHandler(file);
        String stepkey = handler.readFromFile();

        if (stepkey != null ) {
            System.out.println("��������� ���� ������� ��������� �� ����� " + fileName + ".bin");
            System.out.println("-------------------------------------------------");
            gameStep.setStepKey(stepkey);
            gameStep.setGameStarted(true);
            return 2;
        }
        else {
            System.out.println("��������� ���� �� ������� ��������� �� ����� " + fileName + ".bin");
            System.out.println("-------------------------------------------------");
        }
        return 1;
    }
    public int exit(){
        gameStep.gameStop();
        System.out.println();
        System.out.println("����� �� ����");
        System.out.println("-------------------------------------------------");
        System.exit (1);
        return 0;
    }
    public int exitToMenu(){
        System.out.println();
        System.out.println("����� � ����");
        System.out.println("-------------------------------------------------");
        return 1;
    }
    public int step1(){
        gameStep.setStepKey(gameStep.getAllParams()[2]);
        return 2;

    }
    public int step2(){
        gameStep.setStepKey(gameStep.getAllParams()[4]);
        return 2;
    }
}