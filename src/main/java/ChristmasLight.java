public class ChristmasLight implements ChristmasDecoration {
    private final int[][] lights = new int[1000][1000];

    private void turnOn(Instruction instruction) {
        for (int y = instruction.getUpperLeftY(); y <= instruction.getLowerRightY(); y++) {
            for (int x = instruction.getUpperLeftX(); x <= instruction.getLowerRightX(); x++) {
                lights[y][x] = 1;
            }
        }
    }

    private void turnOff(Instruction instruction) {
        for (int y = instruction.getUpperLeftY(); y <= instruction.getLowerRightY(); y++) {
            for (int x = instruction.getUpperLeftX(); x <= instruction.getLowerRightX(); x++) {
                lights[y][x] = 0;
            }
        }
    }

    private void toggleLights(Instruction instruction) {
        for (int y = instruction.getUpperLeftY(); y <= instruction.getLowerRightY(); y++) {
            for (int x = instruction.getUpperLeftX(); x <= instruction.getLowerRightX(); x++) {
                if (lights[y][x] == 0) {
                    lights[y][x] = 1;
                } else {
                    lights[y][x] = 0;
                }
            }
        }
    }

    @Override
    public void executeInstruction(Instruction instruction) {
        switch (instruction.getType()) {
            case TURNON -> turnOn(instruction);
            case TURNOFF -> turnOff(instruction);
            case TOGGLE -> toggleLights(instruction);
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
