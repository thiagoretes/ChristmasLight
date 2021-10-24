public class ChristmasLightV2 implements ChristmasDecoration {
    private final int[][] lights = new int[1000][1000];

    @Override
    public void executeInstruction(Instruction instruction) {
        switch(instruction.getType()){
            case TURNON -> turnOn(instruction);
            case TURNOFF -> turnOff(instruction);
            case TOGGLE -> toggle(instruction);
            default -> throw new RuntimeException("Unknown Instruction type!");
        }
    }

    private void turnOn(Instruction instruction) {
        changeBrightness(instruction, 1);
    }

    private void turnOff(Instruction instruction) {
        changeBrightness(instruction, -1);
    }

    private void toggle(Instruction instruction) {
        changeBrightness(instruction, 2);
    }

    private void changeBrightness(Instruction instruction, int amount) {
        for (int y = instruction.getUpperLeftY();
             y <= instruction.getLowerRightY(); y++) {
            for (int x = instruction.getUpperLeftX();
                 x <= instruction.getLowerRightX(); x++) {
                lights[y][x] += amount;
                if(lights[y][x] < 0){
                    lights[y][x] = 0;
                }
            }
        }
    }

    @Override
    public int getTotalLight() {
        int sumOfLights = 0;
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                sumOfLights += lights[i][j];
            }
        }
        return sumOfLights;
    }
}
