import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        ChristmasDecoration christmasLight = new ChristmasLight();
        ChristmasDecoration christmasLightV2 = new ChristmasLightV2();
        InstructionParser parser = new InstructionParser();
        Scanner sc = new Scanner(System.in);
        List<Instruction> instructionList = new ArrayList<>();

        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            if (input.equals(" ") || input.isEmpty()) {
                break;
            }
            instructionList.add(parser.parse(input));
        }

        for (Instruction instruction : instructionList) {
            christmasLight.executeInstruction(instruction);
            christmasLightV2.executeInstruction(instruction);
        }

        System.out.println("Christmas light first part total light: " + christmasLight.getTotalLight());
        System.out.println("Christmas light second part total brightness: " + christmasLightV2.getTotalLight());

    }
}
