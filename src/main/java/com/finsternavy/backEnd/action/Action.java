package backEnd;

/**
 * Action is something you can or have to do when landing on a space
 */
public interface Action {
    
    /**
     * Perform and resolve this action
     */
    void resolve();
}