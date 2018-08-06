package backEnd;

import java.util.ArrayList;
import lombok.Getter;

/**
 * BoardManager is responsible for managing the game board
 */
@Getter
public class BoardManager {
    
    /**
     * Setup the game board and return the start space once everything is bound
     */
    public static Space setup() {
        // define all spaces and relationships
        
        Space startSpace = Space.builder()
            .isMandatory(false)
            .spaceType(SpaceType.SPLIT)
            .splitText("Do you want to go to college or skip it?");
            .nextSpaces(new ArrayList<Space>());
            
        // college path
        Space college1 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Start college, take out a $40,000 loan")
            .actions(new ArrayList<Action>()) // todo, define actions
            .nextSpaces(new ArrayList<Space>());
        startSpace.getNextSpaces().add(college1);
        
        Space college2 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Scholarship! Collect $20,000")
            .actions(new ArrayList<Action>(Arrays.asList(
                new CollectMoney(20000))
            ))
            .nextPaces(new ArrayList<Space>());
        college1.getNextSpaces().add(college2);
        
        Space college3 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Buy books and supplies, pay $5,000")
            .actions(new ArrayList<Action>()
            .nextPaces(new ArrayList<Space>());
        college2.getNextSpaces().add(college3);
        
        Space college4 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Make a new friend. Life Tile Added")
            .actions(new ArrayList<Action>()
            .nextPaces(new ArrayList<Space>());
        college3.getNextSpaces().add(college4);
        
        Space college5 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Part time job, collect $5,000")
            .actions(new ArrayList<Action>()
            .nextPaces(new ArrayList<Space>());
        college4.getNextSpaces().add(college5);
        
        Space college6 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Cram for exams, lose next turn")
            .actions(new ArrayList<Action>()
            .nextPaces(new ArrayList<Space>());
        college5.getNextSpaces().add(college6);
        
        Space college7 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Study in Europe, Life Tile added")
            .actions(new ArrayList<Action>()
            .nextPaces(new ArrayList<Space>());
        college6.getNextSpaces().add(college7);
        
        Space college8 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Spring break in Florida, pay $5,000")
            .actions(new ArrayList<Action>()
            .nextPaces(new ArrayList<Space>());
        college7.getNextSpaces().add(college8);
        
        Space college9 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Dean's list. Life Tile added")
            .actions(new ArrayList<Action>()
            .nextPaces(new ArrayList<Space>());
        college8.getNextSpaces().add(college9);
        
        Space college10 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Write term paper. Lose next turn.")
            .actions(new ArrayList<Action>()
            .nextPaces(new ArrayList<Space>());
        college9.getNextSpaces().add(college10);
        
        Space college11 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Graduation day! Life Tile added")
            .actions(new ArrayList<Action>()
            .nextPaces(new ArrayList<Space>());
        college10.getNextSpaces().add(college11);
        
        Space college12 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.STOP)
            .landingText("STOP! Job search")
            .actions(new ArrayList<Action>()
            .nextPaces(new ArrayList<Space>());
        college11.getNextSpaces().add(college12);
        
        // non college path
        // todo ....
        Space nonCollege1 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Start career. Pick job and salary")
            .actions(new ArrayList<Action>()) // todo, define actions
            .nextSpaces(new ArrayList<Space>());
        startSpace.getNextSpaces().add(nonCollege1);
        
        // define where they link up
        // todo ...
        Space shared1 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Pay Day!")
            .actions(new ArrayList<Action>()) // todo, define actions
            .nextSpaces(new ArrayList<Space>());
        nonCollege1.getNextSpaces().add(shared1);
        college12.getNextSpace().add(shared1);
        
        // define straight path to next split
        // todo ...
        Space shared2 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Rent apartment. Pay $5,000")
            .actions(new ArrayList<Action>()) // todo, define actions
            .nextSpaces(new ArrayList<Space>());
        shared1.getNextSpaces().add(shared2);
        
        Space shared3 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Raffle prize! Collect $10,000")
            .actions(new ArrayList<Action>()) // todo, define actions
            .nextSpaces(new ArrayList<Space>());
        shared2.getNextSpaces().add(shared3);
        
        Space shared4 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Pay Day!")
            .actions(new ArrayList<Action>()) // todo, define actions
            .nextSpaces(new ArrayList<Space>());
        shared3.getNextSpaces().add(shared4);
        
        Space shared5 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Adopt a pet. Life Tile added")
            .actions(new ArrayList<Action>()) // todo, define actions
            .nextSpaces(new ArrayList<Space>());
        shared4.getNextSpaces().add(shared5);
        
        Space shared6 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Donate to favorite cherity. Pay $5,000")
            .actions(new ArrayList<Action>()) // todo, define actions
            .nextSpaces(new ArrayList<Space>());
        shared5.getNextSpaces().add(shared6);
        
        Space shared7 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Birthday party! Life Tile added")
            .actions(new ArrayList<Action>()) // todo, define actions
            .nextSpaces(new ArrayList<Space>());
        shared6.getNextSpaces().add(shared7);
        
        Space shared8 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Ski accident! pay $5,000") //Pay to player with job Doctor
            .actions(new ArrayList<Action>()) // todo, define actions
            .nextSpaces(new ArrayList<Space>());
        shared7.getNextSpaces().add(shared8);
        
        Space shared9 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Win marathon! Collect $10,000")
            .actions(new ArrayList<Action>()) // todo, define actions
            .nextSpaces(new ArrayList<Space>());
        shared8.getNextSpaces().add(shared9);
        
        Space shared10 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Say NO to drugs. Life Tile added")
            .actions(new ArrayList<Action>()) // todo, define actions
            .nextSpaces(new ArrayList<Space>());
        shared9.getNextSpaces().add(shared10);
        
        Space shared11 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Don't drink and drive. Life Tile added")
            .actions(new ArrayList<Action>()) // todo, define actions
            .nextSpaces(new ArrayList<Space>());
        shared10.getNextSpaces().add(shared11);
        
        Space shared12 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Pay Day!")
            .actions(new ArrayList<Action>()) // todo, define actions
            .nextSpaces(new ArrayList<Space>());
        shared11.getNextSpaces().add(shared12);
        
        Space shared13 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Flat tire. Lose next turn")
            .actions(new ArrayList<Action>()) // todo, define actions
            .nextSpaces(new ArrayList<Space>());
        shared12.getNextSpaces().add(shared13);
        
        Space shared14 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.STOP)
            .landingText("STOP! Get married. Life Tile added")
            .actions(new ArrayList<Action>()) // todo, define actions
            .nextSpaces(new ArrayList<Space>());
        shared13.getNextSpaces().add(shared14);
      
      Space shared15 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Wedding reception. Pay $10,000")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared14.getNextSpaces().add(shared15);
        
        Space shared16 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Happy honeymoon! Life Tile added")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared15.getNextSpaces().add(shared16);
        
        Space shared17 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Buy furniture. Pay $10,000")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared16.getNextSpaces().add(shared17);
        
        Space shared18 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Car accident. Pay $10,000 if not insured")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared17.getNextSpaces().add(shared18);
        
        Space shared19 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Move across country. Pay $10,000")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared18.getNextSpaces().add(shared19);
        
        Space shared20 = Space.builder()
            .isMandatory(false)
            .spaceType(SpaceType.NORMAL)
            .landingText("Night school.  Pay $20,000")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared19.getNextSpaces().add(shared20);
        
        Space shared21 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Pay Day!")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared20.getNextSpaces().add(shared21);
        
        Space shared22 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Taxes due!")//pay Accountant taxes associated with salary
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared21.getNextSpaces().add(shared22);
        
        Space shared23 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Win lottery! Collect $50,000")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared22.getNextSpaces().add(shared23);
        
        Space shared24 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Visit in-laws. Life Tile added")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared23.getNextSpaces().add(shared24);
        
        Space shared25 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.STOP)
            .landingText("STOP! Buy a house.")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared24.getNextSpaces().add(shared25);
        
        Space shared26 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Pay Day!")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared25.getNextSpaces().add(shared26);
        
        Space shared27 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("You're fired!!! Start new career")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared26.getNextSpaces().add(shared27);
        
        Space shared28 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Baby boy! Life Tile added")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared27.getNextSpaces().add(shared28);
        
        Space shared29 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Inheritance! Collect $100,000")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared28.getNextSpaces().add(shared29);
        
        Space shared30 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Baby girl! Life Tile added")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared29.getNextSpaces().add(shared30);
        
        Space shared31 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Win talent contest. Collect $10,000")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared30.getNextSpaces().add(shared31);
        
        Space shared32 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Pay Day!")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared31.getNextSpaces().add(shared32);
        
        Space shared33 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Twins! Life Tile added")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared32.getNextSpaces().add(shared33);
        
        Space shared34 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Box seats at World Series. Pay $20,000")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared33.getNextSpaces().add(shared34);
        
        Space shared35 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Baby girl! Life Tile added")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared34.getNextSpaces().add(shared35);
        
        Space shared36 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Attend Hollywood movie premiere. Pay $5,000")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared35.getNextSpaces().add(shared36);
        
        Space shared37 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.SPLIT)
            .landingText("House flooded! Pay $40,000 if not insured")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared36.getNextSpaces().add(shared37);
        
        Space firstSplitA1 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Family checkups. Pay $5,000 for each family member")//Pay to Doctor
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared37.getNextSpaces().add(firstSplitA1)
        
        Space firstSplitA2 = Space.builder()
            .isMandatory(false)
            .spaceType(SpaceType.NORMAL)
            .landingText("Trade Salary with any player")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        firstSplitA1.getNextSpaces().add(firstSplitA2);
        
        Space firstSplitA3 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Baby boy! Life Tile added")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        firstSplitA2.getNextSpaces().add(firstSplitA3);
        
        Space firstSplitA4 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Pay Day!")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        firstSplitA3.getNextSpaces().add(firstSplitA4);
        
        Space firstSplitA5 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Baby girl! Life Tile added")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        firstSplitA4.getNextSpaces().add(firstSplitA5);
        
        Space firstSplitA6 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Tree falls on house.  Pay $15,000 if not insured")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        firstSplitA5.getNextSpaces().add(firstSplitA6);
        
        Space firstSplitA7 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Return lost wallet. Life Tile added")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        firstSplitA6.getNextSpaces().add(firstSplitA7);
        
        Space firstSplitB1 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Buy big screen TV. Pay $5,000")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared37.getNextSpaces().add(firstSplitB1);
        
        Space firstSplitB2 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Buy big screen TV. Pay $5,000")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        firstSplitB1.getNextSpaces().add(firstSplitB2);
        
        Space firstSplitB3 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Stock market booms! Collect 1 stock")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        firstSplitB2.getNextSpaces().add(firstSplitB3);
        
        Space firstSplitB4 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Family picnic. Life Tile added")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        firstSplitB3.getNextSpaces().add(firstSplitB4);
        
        Space firstSplitB5 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Visit Mount Rushmore. Life Tile added")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        firstSplitB4.getNextSpaces().add(firstSplitB5);
        
        Space firstSplitB6 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Pay Day!")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        firstSplitB5.getNextSpaces().add(firstSplitB6);
        
        Space firstSplitB7 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Car accident.  Pay $15,000 if not insured")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        firstSplitB6.getNextSpaces().add(firstSplitB7);
        
        Space shared38 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Trade Salary with any player")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        firstSplitB7.getNextSpaces().add(shared38);
        firstSplitA7.getNextSpaces().add(shared38);
        
        Space shared39 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Run for office. Life Tile added")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared38.getNextSpaces().add(shared39);
        
        Space shared40 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Vote! Life Tile added")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared39.getNextSpaces().add(shared40);
        
        Space shared41 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Baby boy! Life Tile added")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared40.getNextSpaces().add(shared41);
        
        Space shared42 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Pay Day!")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared41.getNextSpaces().add(shared42);
      
      // all spaces setup!
      return startSpace;
    }
}