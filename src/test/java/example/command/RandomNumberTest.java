package example.command;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class RandomNumberTest {

    @Test
    void testRandadd() {
        int lastNumber = 5;
        RandomNumber rand = new RandomNumber();
        int result = rand.randadd(lastNumber);

        assertThat(result).isBetween(-95, 105);
    }
}