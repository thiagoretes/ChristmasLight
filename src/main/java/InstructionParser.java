import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InstructionParser {

    public static final String regexString = "(turn on|turn off|toggle) ([0-9]+),([0-9]+) through ([0-9]+),([0-9]+)";
    public static final Pattern regexPattern = Pattern.compile(regexString);
    private Matcher regexMatcher;

    public Instruction parse(String instructionText) {
        regexMatcher = regexPattern.matcher(instructionText);
        if (isInstruction()) {
            return new Instruction(getInstructionType(),
                    getUpperLeftX(),
                    getUpperLeftY(),
                    getLowerRightX(),
                    getLowerRightY());
        }
        throw new RuntimeException("Unknown Instruction!");
    }

    private boolean isInstruction() {
        return regexMatcher.find();
    }

    private InstructionType getInstructionType() {
        if (regexMatcher.group(1).equals("turn on")) {
            return InstructionType.TURNON;
        } else if (regexMatcher.group(1).equals("turn off")) {
            return InstructionType.TURNOFF;
        } else if (regexMatcher.group(1).equals("toggle")){
            return InstructionType.TOGGLE;
        }
        throw new RuntimeException("Unknown instruction type!");
    }

    private int getUpperLeftX() {
        return Integer.parseInt(this.regexMatcher.group(2));
    }

    private int getUpperLeftY() {
        return Integer.parseInt(regexMatcher.group(3));
    }

    private int getLowerRightX() {
        return Integer.parseInt(regexMatcher.group(4));
    }

    private int getLowerRightY() {
        return Integer.parseInt(regexMatcher.group(5));
    }
}
