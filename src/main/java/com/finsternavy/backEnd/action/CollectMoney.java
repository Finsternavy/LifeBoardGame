package backEnd;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
public class CollectMoney implements Action {
    
    private final int amount;

    @Override
    public void resolve() {
        GameManager.getCurrentPlayer().addFunds(amount);
    }
}