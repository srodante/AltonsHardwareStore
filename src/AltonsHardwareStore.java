import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

import java.util.Scanner;

public class AltonsHardwareStore {
    public static void main (String[] args){
        Scanner keybd = new Scanner(System.in);
        double woodFence = 25.0f, chainFence = 15.0f;
        double tax = 1.06f;
        double totalPrice = 0;
        int gate = 150, permit = 50;
        int length, width, totalFence, numberOfGates;
        String material;
        boolean wood, chain, both;

        System.out.println("Welcome to Alton's Hardware Store");
        do {     // Outer loop
            System.out.print("Enter the length of the yard. Enter -1 to quit: ");
            length = keybd.nextInt();
            if (length > 0) {    // verify the user wanted to continue
                System.out.print("Enter the width of the yard: ");
                width = keybd.nextInt();
                totalFence = (2 * width) + (2 * length);
                System.out.print("How many gates are requested: ");
                numberOfGates = keybd.nextInt();
                keybd.nextLine(); // flush the input buffer
                do {      //Inner loop for invalid responses
                    System.out.print("What type of material is requested (wood/chain/both): ");
                    material = keybd.nextLine();
                    wood = material.equalsIgnoreCase("wood");
                    chain = material.equalsIgnoreCase("chain");
                    both = material.equalsIgnoreCase("both");
                    if ((wood || chain || both) == false) {
                        System.out.println("Invalid response");
                    }
                } while ((wood || chain || both) == false);
                // The print line below is redundant as it's listed in the total line
                // System.out.println("The amount of fencing needed is " + totalFence + " feet");
                if (wood || both) {
                    totalPrice = ((totalFence * woodFence) + (numberOfGates * gate) + permit) * tax;
                    System.out.printf("The cost of %d feet of wood fencing with %d gate(s)" +
                            " is: $%.2f\n", totalFence, numberOfGates, totalPrice);
                }
                if (chain || both) {
                    totalPrice = ((totalFence * chainFence) + (numberOfGates * gate) + permit) * tax;
                    System.out.printf("The cost of %d feet of chain link fencing with %d gate(s) " +
                            "is: $%.2f\n", totalFence, numberOfGates, totalPrice);
                }
            }
        } while (length != -1);
   }
}
