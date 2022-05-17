package ru.itmo.lessons.exams.exam2_2;

public class GameApp {
    public static void main(String[] args) {

        Game game = Game.getGame();
        game.go();

        game.nextstep();

    }
}
