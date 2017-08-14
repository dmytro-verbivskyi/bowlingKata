package _001_2017_08_14;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    private Game g;

    @Before
    public void setUp() throws Exception {
        g = new Game();
    }

    @Test
    public void testAllGutter() throws Exception {
        rollMany(20, 0);
        assertThat(g.getScore()).isEqualTo(0);
    }

    @Test
    public void testAllOnes() throws Exception {
        rollMany(20, 1);
        assertThat(g.getScore()).isEqualTo(20);
    }

    @Test
    public void testOneSpare() throws Exception {
        rollSpare();
        g.roll(3);
        rollMany(17, 0);
        assertThat(g.getScore()).isEqualTo(16);
    }

    @Test
    public void testOneStrike() throws Exception {
        rollStrike();
        g.roll(3);
        g.roll(4);
        rollMany(16, 0);
        assertThat(g.getScore()).isEqualTo(24);
    }

    @Test
    public void testPerfectGameAllStrikes() throws Exception {
        rollMany(12, 10);
        assertThat(g.getScore()).isEqualTo(300);
    }

    private void rollSpare() {
        g.roll(5);
        g.roll(5);
    }

    private void rollStrike() {
        g.roll(10);
    }

    private void rollMany(int times, int pins) {
        for (int i = 0; i < times; i++) {
            g.roll(pins);
        }
    }
}
