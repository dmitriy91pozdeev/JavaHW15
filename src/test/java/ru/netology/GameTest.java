package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Game game = new Game();

    @Test

    public void testWhenFirstPlayerWin() {
        Player nikolay = new Player(1, "Николай", 90);
        Player andrey = new Player(1, "Андрей", 70);

        game.register(nikolay);
        game.register(andrey);
        int expected = 1;
        int actual = game.round("Николай", "Андрей");

        Assertions.assertEquals(expected, actual);


    }

    @Test

    public void testWhenSecondPlayerWin() {
        Player nikolay = new Player(1, "Николай", 90);
        Player andrey = new Player(1, "Андрей", 100);

        game.register(nikolay);
        game.register(andrey);
        int expected = 2;
        int actual = game.round("Николай", "Андрей");

        Assertions.assertEquals(expected, actual);


    }

    @Test

    public void testWhenDeadHeat() {
        Player nikolay = new Player(1, "Николай", 90);
        Player andrey = new Player(1, "Андрей", 90);

        game.register(nikolay);
        game.register(andrey);
        int expected = 0;
        int actual = game.round("Николай", "Андрей");

        Assertions.assertEquals(expected, actual);


    }

    @Test

    public void testWhenFirstPlayerNotRegistered() {
        Player nikolay = new Player(1, "Николай", 90);
        Player andrey = new Player(1, "Андрей", 90);

        game.register(nikolay);
        game.register(andrey);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Алексей", "Андрей")
        );
    }

    @Test

    public void testWhenSecondPlayerNotRegistered() {
        Player nikolay = new Player(1, "Николай", 90);
        Player andrey = new Player(1, "Андрей", 90);

        game.register(nikolay);
        game.register(andrey);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Николай", "Петр")
        );
    }

}