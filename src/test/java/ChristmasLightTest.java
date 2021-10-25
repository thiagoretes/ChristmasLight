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
        var instruction = new Instruction(InstructionType.TURNON,
                0, 0,
                999, 999);

        christmasLight.executeInstruction(instruction);

        assertEquals(1000000, christmasLight.getTotalLight());
    }

    @Test
    void shouldTurnOnOneLight() {
        var instruction = new Instruction(InstructionType.TURNON,
                0, 0,
                0, 0);

        christmasLight.executeInstruction(instruction);
        assertEquals(1, christmasLight.getTotalLight());
    }

    @Test
    void shouldTurnOnMultipleLights() {
        var instruction = new Instruction(InstructionType.TURNON,
                0, 0,
                9, 4);

        christmasLight.executeInstruction(instruction);

        assertEquals(50, christmasLight.getTotalLight());
    }

    @Test
    void shouldTurnOffMultipleLights() {
        var instruction = new Instruction(InstructionType.TURNON,
                0, 0,
                9, 4);

        christmasLight.executeInstruction(instruction);

        instruction = new Instruction(InstructionType.TURNOFF,
                0, 0,
                8, 4);

        christmasLight.executeInstruction(instruction);
        assertEquals(5, christmasLight.getTotalLight());

    }

    @Test
    void shouldToggleOneLight() {
        var instruction = new Instruction(InstructionType.TOGGLE, 0, 0, 0, 0);

        christmasLight.executeInstruction(instruction);

        assertEquals(1, christmasLight.getTotalLight());

        christmasLight.executeInstruction(instruction);

        assertEquals(0, christmasLight.getTotalLight());
    }

    @Test
    void shouldToggleMultipleLights() {
        var instruction = new Instruction(InstructionType.TOGGLE, 0, 0, 99, 99);

        christmasLight.executeInstruction(instruction);

        assertEquals(10000, christmasLight.getTotalLight());

        christmasLight.executeInstruction(instruction);

        assertEquals(0, christmasLight.getTotalLight());
    }
}