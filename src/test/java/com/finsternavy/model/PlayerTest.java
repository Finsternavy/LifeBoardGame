import org.junit.Test;

import static org.junit.Assert.assertTrue;

public PlayerTest {
    @Test
    public void testPlayer() {
        // GIVEN - create the thing
        Player myPlayer = new Player();
        
        // WHEN - put in the test data
        myPlayer.setHouseOwned(true);
        
        // THEN - assert
        assertTrue(myPlayer.getHouseOwned);
    }
}