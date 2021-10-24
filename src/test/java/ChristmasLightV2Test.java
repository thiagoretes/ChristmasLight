import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChristmasLightV2Test {

    private ChristmasLightV2 christmasLightV2;

    @BeforeEach
    void setUp() {
        christmasLightV2 = new ChristmasLightV2();
    }

    @Test
    void shouldRaiseBrightnessByOneWhenTurnOn() {
        christmasLightV2.executeInstruction(
                new Instruction(InstructionType.TURNON,
                        0,0,0,0));

        assertEquals(1, christmasLightV2.getTotalLight());
    }

    @Test
    void shouldRaiseBrightnessByFourWhenTurnOn() {
        christmasLightV2.executeInstruction(
                new Instruction(InstructionType.TURNON,
                        0,0,1,1));

        assertEquals(4, christmasLightV2.getTotalLight());
    }

    @Test
    void shouldRaiseBrightnessByTwoWhenToggle() {
        christmasLightV2.executeInstruction(
                new Instruction(InstructionType.TOGGLE,
                        0,0,0,0));

        assertEquals(2, christmasLightV2.getTotalLight());
    }

    @Test
    void shouldRaiseBrightnessByEightWhenToggle() {
        christmasLightV2.executeInstruction(
                new Instruction(InstructionType.TOGGLE,
                        0,0,1,1));

        assertEquals(8, christmasLightV2.getTotalLight());
    }

    @Test
    void shouldLowerBrightnessByOneWhenTurnOff() {
        christmasLightV2.executeInstruction(
                new Instruction(InstructionType.TOGGLE,
                        0,0,1,1));
        christmasLightV2.executeInstruction(
                new Instruction(InstructionType.TURNOFF,
                        0,0,0,0));

        assertEquals(7, christmasLightV2.getTotalLight());
    }

    @Test
    void shouldLowerBrightnessByFourWhenTurnOff() {
        christmasLightV2.executeInstruction(
                new Instruction(InstructionType.TOGGLE,
                        0,0,1,1));
        christmasLightV2.executeInstruction(
                new Instruction(InstructionType.TURNOFF,
                        0,0,1,1));

        assertEquals(4, christmasLightV2.getTotalLight());
    }
}