import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InstructionParserTest {

    private InstructionParser instructionParser;

    @BeforeEach
    void setUp() {
        instructionParser = new InstructionParser();
    }

    @Test
    void shouldParseTurnOnInstruction() {
        var instruction = instructionParser.parse("turn on 599,989 through 806,993");
        assertEquals(InstructionType.TURNON, instruction.getType());
    }

    @Test
    void shouldParseTurnOffInstruction() {
        var instruction = instructionParser.parse("turn off 599,989 through 806,993");
        assertEquals(InstructionType.TURNOFF, instruction.getType());
    }

    @Test
    void shouldParseToggleInstruction() {
        var instruction = instructionParser.parse("toggle 599,989 through 806,993");
        assertEquals(InstructionType.TOGGLE, instruction.getType());
    }

    @Test
    void shouldParseUpperLeftPointInstruction() {
        var instruction = instructionParser.parse("toggle 599,989 through 806,993");
        assertEquals(599, instruction.getUpperLeftX());
        assertEquals(989, instruction.getUpperLeftY());
    }

    @Test
    void shouldParseLowerRightPointInstruction() {
        var instruction = instructionParser.parse("toggle 599,989 through 806,993");
        assertEquals(806, instruction.getLowerRightX());
        assertEquals(993, instruction.getLowerRightY());
    }

    @Test
    void shouldThrowUnknownInstruction() {
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> instructionParser.parse("unknown 599,989 through 806,993"),
                "Expected runtime exception but it didn't happen!");
        assertTrue(exception.getMessage().contains("Unknown Instruction!"));


    }


}