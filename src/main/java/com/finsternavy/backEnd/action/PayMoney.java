package backEnd;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

/**
 * PayMoney defines an Action to take money from the current player and give
 * to another player of a given profession.
 */
@RequiredArgsConstructor
@Builder
public class PayMoney implements Action {
    
    private final int amount;
    private final JobCards jobToPay;
    
    @Override
    public void resolve() {
        // remove the money from this player's account
        GameManager.getCurrentPlayer.removeFunds(amount);
        
        // if another player has this job, pay them
        GameManager.getPlayerByJob(jobToPay)
            .ifPresent(player::addFunds);
    }
}