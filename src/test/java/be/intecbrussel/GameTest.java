package be.intecbrussel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {

    @Test
    public void GutterTest() {
        Game game = new Game();
        for (int i = 0; i < 20; i++) {
            game.roll(0);
        }
        assertEquals(0, game.score());
    }

    @Test
    public void TestAllOnes() {
        Game game = new Game();
        for (int i = 0; i < 20; i++) {
            game.roll(1);
        }
        assertEquals(20, game.score());
    }

    @Test
    public void testOneSpare() {
        Game game = new Game();
        game.roll(5);//first frame
        game.roll(5);//spare
        game.roll(5);//bonus second frame
        game.roll(5);//spare
        game.roll(3);//bonus third frame


        for (int i = 0; i < 15; i++) {
            game.roll(0);
        }
        assertEquals(23, game.score());
    }

    @Test
    public void testOneStrike() {
        Game game = new Game();
        game.roll(10);//strike
        game.roll(3);
        game.roll(4);
        assertEquals(17, game.score());
    }

}