public class ChristmasLight implements ChristmasDecoration {
    private final int[][] lights = new int[1000][1000];

    public void turnOn(int startX, int startY, int endX, int endY) {
        for (int i = startY; i <= endY; i++) {
            for (int j = startX; j <= endX; j++) {
                lights[i][j] = 1;
            }
        }
    }

    public void turnOff(int startX, int startY, int endX, int endY) {
        for (int i = startY; i <= endY; i++) {
            for (int j = startX; j <= endX; j++) {
                lights[i][j] = 0;
            }
        }
    }

    public int[][] getLights() {
        return lights;
    }

    public void toggleLights(int startX, int startY, int endX, int endY) {
        for (int i = startY; i <= endY; i++) {
            for (int j = startX; j <= endX; j++) {
                if (lights[i][j] == 0) {
                    lights[i][j] = 1;
                } else {
                    lights[i][j] = 0;
                }
            }
        }
    }

    @Override
    public void executeInstruction(Instruction instruction) {
        switch (instruction.getType()) {
            case TURNON -> turnOn(instruction.getUpperLeftX(),
                    instruction.getUpperLeftY(),
                    instruction.getLowerRightX(),
                    instruction.getLowerRightY()
            );
            case TURNOFF -> turnOff(instruction.getUpperLeftX(),
                    instruction.getUpperLeftY(),
                    instruction.getLowerRightX(),
                    instruction.getLowerRightY());
            case TOGGLE -> toggleLights(instruction.getUpperLeftX(),
                    instruction.getUpperLeftY(),
                    instruction.getLowerRightX(),
                    instruction.getLowerRightY());
            default -> throw new RuntimeException("Unknown instruction type!");
        }
    }

    @Override
    public int getTotalLight() {
        int sumOfLights = 0;
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                if (lights[i][j] == 1) {
                    sumOfLights++;
                }
            }
        }
        return sumOfLights;
    }


}
