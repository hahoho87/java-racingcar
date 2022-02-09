package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    @Test
    void RacingCar_리스트를_받아_RacingGame_객체_생성() {
        final RacingCars racingCars = new RacingCars("car1,car2");

        final RacingGame racingGame = new RacingGame(racingCars);

        assertThat(racingGame.getRacingCars()).isEqualTo(racingCars);
    }

    @RepeatedTest(value = 1000)
    void getRandomValue_랜덤값을_생성()
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        final RacingGame racingGame = new RacingGame();
        final Method getRandomValue = RacingGame.class.getDeclaredMethod("getRandomValue");
        getRandomValue.setAccessible(true);

        final int result = (int) getRandomValue.invoke(racingGame);

        assertTrue(result <= 9);
        assertTrue(result >= 0);
    }
}