public class Instruction {
    private InstructionType type;
    private int upperLeftX;
    private int upperLeftY;
    private int lowerRightX;
    private int lowerRightY;

    public Instruction(InstructionType type, int upperLeftX, int upperLeftY, int lowerRightX, int lowerRightY) {
        this.type = type;
        this.upperLeftX = upperLeftX;
        this.upperLeftY = upperLeftY;
        this.lowerRightX = lowerRightX;
        this.lowerRightY = lowerRightY;
    }

    public InstructionType getType() {
        return type;
    }

    public int getUpperLeftX() {
        return upperLeftX;
    }

    public int getUpperLeftY() {
        return upperLeftY;
    }

    public int getLowerRightX() {
        return lowerRightX;
    }

    public int getLowerRightY() {
        return lowerRightY;
    }
}
