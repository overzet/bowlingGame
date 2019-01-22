package be.intecbrussel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {

    Game game = new Game();

    public void framesInRollsAndPins(int roll, int pins) {
        for (int i = 0; i < roll; i++) {
            game.roll(pins);
        }
    }

    @Test
    public void GutterTest() {
        framesInRollsAndPins(20, 0);
        assertEquals(0, game.score());
    }

    @Test
    public void TestAllOnes() {
        framesInRollsAndPins(20, 1);

        assertEquals(20, game.score());
    }

    @Test
    public void testOneSpare() {
        game.roll(5);//first frame
        game.roll(5);//spare
        game.roll(5);//bonus second frame
        game.roll(5);//spare
        game.roll(3);//bonus third frame


        framesInRollsAndPins(15, 0);
        assertEquals(23, game.score());
    }

    @Test
    public void testOneStrike() {
        game.roll(10);//strike
        game.roll(3);
        game.roll(4);

        framesInRollsAndPins(16, 0); //16 rolls  0 pins so this is the 8 frames left = 16 rolls

        assertEquals(17, game.score());
    }


}