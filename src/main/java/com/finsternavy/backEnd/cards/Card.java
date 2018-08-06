package backEnd;

/**
 * Card interface defines things that are common across all cards
 */
public interface Card {
    
    /**
     * Returns a pretty string to render info about this card to prompt the user
     */
    default String getCardDetails() {
        return this.toString();
    }
}