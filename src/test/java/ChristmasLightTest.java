import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChristmasLightTest {

    private ChristmasLight christmasLight;

    @BeforeEach
    void setUp() {
        christmasLight = new ChristmasLight();
    }

    @Test
    void shouldCountLights() {
        christmasLight.turnOn(0, 0, 999, 999);

        assertEquals(1000000, christmasLight.getTotalLight());
    }

    @Test
    void shouldTurnOnOneLight() {
        christmasLight.turnOn(0, 0, 0, 0);
        assertEquals(1, christmasLight.getLights()[0][0]);
    }

    @Test
    void shouldTurnOnMultipleLights() {
        christmasLight.turnOn(250, 500, 750, 999);

        int[][] lights = new int[1000][1000];
        for (int i = 250; i <= 750; i++) {
            for (int j = 500; j <= 999; j++) {
                lights[j][i] = 1;
            }
        }
        assertArrayEquals(lights, christmasLight.getLights());
    }

    @Test
    void shouldTurnOffMultipleLights() {
        christmasLight.turnOn(250, 500, 750, 999);
        int[][] lights = new int[1000][1000];
        for (int i = 250; i <= 750; i++) {
            for (int j = 500; j <= 999; j++) {
                lights[j][i] = 1;
            }
        }
        assertArrayEquals(lights, christmasLight.getLights());
        for (int i = 250; i <= 750; i++) {
            for (int j = 500; j <= 998; j++) {
                lights[j][i] = 0;
            }
        }
        christmasLight.turnOff(250, 500, 750, 998);
        assertArrayEquals(lights, christmasLight.getLights());

    }

    @Test
    void shouldToggleOneLight() {
        christmasLight.toggleLights(0,0,0,0);

        assertEquals(1, christmasLight.getLights()[0][0]);
        christmasLight.toggleLights(0,0,0,0);

        assertEquals(0, christmasLight.getLights()[0][0]);
    }

    @Test
    void shouldToggleMultipleLights() {
        christmasLight.toggleLights(125,125,250,250);

        int[][] lights = new int[1000][1000];
        for (int i = 125; i <= 250; i++) {
            for (int j = 125; j <= 250 ; j++) {
                lights[j][i] = 1;
            }
        }
        assertArrayEquals(lights, christmasLight.getLights());
        christmasLight.toggleLights(125,125,250,250);
        lights = new int[1000][1000];
        assertArrayEquals(lights, christmasLight.getLights());

    }
}