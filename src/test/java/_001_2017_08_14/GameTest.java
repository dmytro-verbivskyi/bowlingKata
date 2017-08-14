package _001_2017_08_14;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    @Test
    public void testAllGutter() throws Exception {
        Game g = new Game();
        for (int i = 0; i < 20; i++) {
            g.roll(0);
        }
        assertThat(g.getScore()).isEqualTo(0);
    }
}
