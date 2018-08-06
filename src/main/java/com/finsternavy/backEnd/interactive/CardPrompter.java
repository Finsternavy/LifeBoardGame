package backend;

/**
 * Prompts the player to select which card they want from the list
 * 
 * @returns card that the player selected
*/
public class CardPrompter {
    
    /**
     * Prompts the player to select which card they want from the list
     * 
     * @returns card that the player selected
     */
    public static Card askWhichCard(List<Card> cards) {
        boolean optionSelected = false;
        int option = -1;
        while(!optionSelected) {
            printOptions(cards);
            try (Scanner scanner = new Scanner(System.in)) {
                option = scanner.nextInt() - 1;
                if (option < 1 || option > cards.size()) {
                    throw new Exception("Selected an invalid index!");
                } else {
                    optionSelected = true;
                }
            } catch (Exception e) {
                System.out.println("That option is invalid. Please select one of the numbers above!");
            }
        }
        
        return cards.get(option);
    }
    
    private static void printOptions(List<Card> cards) {
        StringBuilder sb = new StringBuilder();
        sb.append("Select your option by typing the number and hitting enter:\n");
        for (int i = 0; i < cards.size(); i++) {
            sb.append("\t").append("Option " + i + 1 + ":\n");
            sb.append(cards.get(i).getCardDetails());
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}