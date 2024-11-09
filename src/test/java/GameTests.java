import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTests {
    @Test
    public void FirstPlayerWin() {
        Player player1 = new Player(12, "Вася", 22);
        Player player2 = new Player(13, "Петя", 10);
        Game game = new Game();
        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Вася", "Петя");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void SecondPlayerWin() {
        Player player1 = new Player(12, "Вася", 22);
        Player player2 = new Player(13, "Петя", 110);
        Game game = new Game();
        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Вася", "Петя");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void PlayerWinEqulse() {
        Player player1 = new Player(12, "Вася", 110);
        Player player2 = new Player(13, "Петя", 110);
        Game game = new Game();
        game.register(player1);
        game.register(player2);

        int expected = 0;
        int actual = game.round("Вася", "Петя");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void NonRegisterFirstPlayer() {
        Player player1 = new Player(12, "Вася", 110);
        Player player2 = new Player(13, "Петя", 110);
        Game game = new Game();
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Вася", "Петя"));
    }

    @Test
    public void NonRegisterSecondPlayer() {
        Player player1 = new Player(12, "Вася", 110);
        Player player2 = new Player(13, "Петя", 110);
        Game game = new Game();
        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Вася", "Петя"));
    }

}
