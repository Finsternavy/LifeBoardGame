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
        
        Space shared43 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Tropical vacation. Pay $25,000")//to travel agent
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared42.getNextSpaces().add(shared43);
        
        Space shared44 = Space.builder()
            .isMandatory(false)
            .spaceType(SpaceType.NORMAL)
            .landingText("Night school.  Pay $25,000")// to teacher. 
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared43.getNextSpaces().add(shared44);
        
        Space shared45 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Learn CPR. Life Tile added")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared44.getNextSpaces().add(shared45);
        
        Space shared46 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Art auction. Pay $20,000")// to artist
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared45.getNextSpaces().add(shared46);
        
        Space shared47 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Pay Day!")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared46.getNextSpaces().add(shared47);
        
        Space shared48 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Help out at Special Olympics. Life Tile added")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared47.getNextSpaces().add(shared48);
        
        Space shared49 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Win beautiful baby contest. Collect $10,000")// if has kids
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared48.getNextSpaces().add(shared49);
        
        Space shared50 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Spin again if not in the lead")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared49.getNextSpaces().add(shared50);
        
        Space shared51 = Space.builder()
            .isMandatory(false)
            .spaceType(SpaceType.NORMAL)
            .landingText("Trade salary with any player")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared50.getNextSpaces().add(shared51);
        
        Space shared52 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Taxes due")//pay accountant
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared51.getNextSpaces().add(shared52);
        
        Space shared53 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Lessons at Ace training camp.  Pay $25,000")//to athlete
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared52.getNextSpaces().add(shared53);
        
        Space shared54 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("African safari. Pay $25,000")//to travel agent
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared53.getNextSpaces().add(shared54);
        
        Space shared55 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Pay Day!")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared54.getNextSpaces().add(shared55);
        
        Space shared56 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Stock market slumps. Return 1 stock")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared55.getNextSpaces().add(shared56);
        
        Space shared57 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Be my Valentine! Life Tile added")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared56.getNextSpaces().add(shared57);
        
        Space shared58 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Day care. Pay $5,000 per child")// to teacher
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared57.getNextSpaces().add(shared58);
        
        Space shared59 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Write best-seller. Collect $80,000")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared58.getNextSpaces().add(shared59);
        
        Space shared60 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.SPLIT)
            .landingText("Adopt twins! Advance 1 spot")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared59.getNextSpaces().add(shared60);
        
        Space secondSplitA1 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Host police cherity ball. Pay $25,000") // to police officer
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared60.getNextSpaces().add(secondSplitA1);
        
        Space secondSplitA2 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Pay Day!")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        secondSplitA1.getNextSpaces().add(secondSplitA2);
        
        Space secondSplitA3 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Find buried treasure! Collect $80,000")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        secondSplitA2.getNextSpaces().add(secondSplitA3);
        
        Space secondSplitA4 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Taxes due.") // pay accountant
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        secondSplitA3.getNextSpaces().add(secondSplitA4);
        
        Space secondSplitB1 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Invest in Broadway play. Pay $15,000") // to Superstar
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared60.getNextSpaces().add(secondSplitB1);
        
        Space secondSplitB2 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Pay Day!")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        secondSplitB1.getNextSpaces().add(secondSplitB2);
        
        Space secondSplitB3 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Remembered your anniversary! Life Tile")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        secondSplitB2.getNextSpaces().add(secondSplitB3);
        
        Space secondSplitB4 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Forgot anniversary. Pay $25,000")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        secondSplitB3.getNextSpaces().add(secondSplitB4);
        
        Space secondSplitB5 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Convicted of a felony! Go to prison. Lose 3 turn.  Your spouse left with the kids and half your funds!")// per Pay day: Salary - (#kids * 5000)
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        secondSplitB4.getNextSpaces().add(secondSplitB5);
        
        Space secondSplitB6 = Space.builder()
            .isMandatory(false)
            .spaceType(SpaceType.NORMAL)
            .landingText("Trade salary with any player")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        secondSplitB5.getNextSpaces().add(secondSplitB6);
        
        Space secondSplitB7 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Buy sports car. Pay $25,000")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        secondSplitB6.getNextSpaces().add(secondSplitB7);
        
        Space secondSplitB8 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Tax refund! Collect $75,000")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        secondSplitB7.getNextSpaces().add(secondSplitB8);
        
        Space shared61 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Pay Day!")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        secondSplitB8.getNextSpaces().add(shared61);
        secondSplitA4.getNextSpaces().add(shared61);
        
        Space shared62 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Donate to Art Institute. Pay $25,000")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared61.getNextSpaces().add(shared62);
        
        Space shared63 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Recycle your trash. Life Tile added")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared61.getNextSpaces().add(shared63);
        
        Space shared64 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("TV game show winner! Collect $95,000")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared63.getNextSpaces().add(shared64);
        
        Space shared65 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Summer school. Pay $5,000 per child")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared64.getNextSpaces().add(shared65);
        
        Space shared66 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Play a family game. Life Tile added")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared65.getNextSpaces().add(shared66);
        
        Space shared67 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Learn sign language. Life Tile added. Advance 1 space")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared66.getNextSpaces().add(shared67);
        
        Space shared68 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Buy cabin on the lake. Pay $90,000")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared67.getNextSpaces().add(shared68);
        
        Space shared69 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Pay Day!")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared68.getNextSpaces().add(shared69);
        
        Space shared70 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Burglar! Pay $50,000 if not insured")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared69.getNextSpaces().add(shared70);
        
        Space shared71 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Win nobel prize. Collect $100,000")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared70.getNextSpaces().add(shared71);
        
        Space shared72 = Space.builder()
            .isMandatory(false)
            .spaceType(SpaceType.NORMAL)
            .landingText("Trade salary with any player")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared71.getNextSpaces().add(shared72);
        
        Space shared73 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Spring for gym equipment. Pay $30,000")//to athlete
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared72.getNextSpaces().add(shared73);
        
        Space shared74 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Stock market slumps. Return 1 stock")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared73.getNextSpaces().add(shared74);
        
        Space shared75 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Tornado hits house! Pay $125,000 if not insured")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared74.getNextSpaces().add(shared75);
        
        Space shared76 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Pay Day! Advance 1 space")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared75.getNextSpaces().add(shared76);
        
        Space shared77 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Moo-shu flu attack! Pay $25,000") // to doctor
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared76.getNextSpaces().add(shared77);
        
        Space shared78 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Taxes due") // pay accountant per salary card
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared77.getNextSpaces().add(shared78);
        
        Space shared79 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Buy sailboat. Pay $30,000")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared78.getNextSpaces().add(shared79);
        
        Space shared80 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Sponsor golf tournament. Pay $35,000")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared79.getNextSpaces().add(shared80);
        
        Space shared81 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Mid-life crisis. Choose new career")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared70.getNextSpaces().add(shared81);
        
        Space shared82 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Spin again if not in the lead")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared81.getNextSpaces().add(shared82);
        
        Space shared83 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Pay Day!")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared82.getNextSpaces().add(shared83);
        
        Space shared84 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Produce rock video. Pay $100,000") // to superstar
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared83.getNextSpaces().add(shared84);
        
        Space shared85 = Space.builder()
            .isMandatory(false)
            .spaceType(SpaceType.NORMAL)
            .landingText("Trade salary with any player")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared84.getNextSpaces().add(shared85);
        
        Space shared86 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Help the homeless. Life Tile added")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared85.getNextSpaces().add(shared86);
        
        Space shared87 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Spin again if not in the lead")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared86.getNextSpaces().add(shared87);
        
        Space shared88 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Have tattoos removed. Pay $100,000")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared87.getNextSpaces().add(shared88);
        
        Space shared89 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("College. Pay $50,000 per child")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared88.getNextSpaces().add(shared89);
        
        Space shared90 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Pay Day!")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared89.getNextSpaces().add(shared90);
        
        Space shared91 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Taxes due") // to accountant
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared90.getNextSpaces().add(shared91);
        
        Space shared92 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Spin again if not in the lead")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared91.getNextSpaces().add(shared92);
        
        Space shared93 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Visit war memorial. Life Tile added")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared92.getNextSpaces().add(shared93);
        
        Space shared94 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Sponsor an art exhibit. Pay $125,000") // to artisit
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared93.getNextSpaces().add(shared94);
        
        Space shared95 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Grand Canyon vacation. Life Tile")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared94.getNextSpaces().add(shared95);
        
        Space shared96 = Space.builder()
            .isMandatory(false)
            .spaceType(SpaceType.NORMAL)
            .landingText("Trade salary with any player")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared95.getNextSpaces().add(shared96);
        
        Space shared97 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Pay Day!")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared96.getNextSpaces().add(shared97);
        
        Space shared98 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Go fishing. Life Tile added")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared97.getNextSpaces().add(shared98);
        
        Space shared99 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Spin again if not in the lead")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared98.getNextSpaces().add(shared99);
        
        Space shared100 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Hire jockey for your racehourse. Pay $65,000")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared99.getNextSpaces().add(shared100);
        
        Space shared101 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Take a hike! Life Tile added")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared100.getNextSpaces().add(shared101);
        
        Space shared102 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Pay Day!")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared101.getNextSpaces().add(shared102);
        
        Space shared103 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Arbor day! Plant a tree. Life Tile added")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared102.getNextSpaces().add(shared103);
        
        Space shared104 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Spin again if not in the lead")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared103.getNextSpaces().add(shared104);
        
        Space shared105 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Support wildlife fund. Life Tile added")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared104.getNextSpaces().add(shared105);
        
        Space shared106 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Tour Europe. Pay $45,000") // to travel agent
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared105.getNextSpaces().add(shared106);
        
        Space shared107 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Your a grandparent! Life Tile added")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared106.getNextSpaces().add(shared107);
        
        Space shared108 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Pay Day!")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared107.getNextSpaces().add(shared108);
        
        Space shared109 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Throw party for grammy winners. Pay $55,000")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared108.getNextSpaces().add(shared109);
        
        Space shared110 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Luxury cruise. Pay $20,000")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared109.getNextSpaces().add(shared110);
        
        Space shared111 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Pention. Collect $20,000")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared110.getNextSpaces().add(shared111);
        
        Space shared112 = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Retire! Select Countrside Acres or Millionaire Estates.")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared111.getNextSpaces().add(shared112);
        
        Space countrysideAcres = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Welcome to Countryside Acres!")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared112.getNextSpaces().add(countrysideAcres);
        
        Space millionaireEstates = Space.builder()
            .isMandatory(true)
            .spaceType(SpaceType.NORMAL)
            .landingText("Welcome to Millionaire Estates!")
            .actions(new ArrayList<Action>())
            .nextSpaces(new ArrayList<Space>());
        shared112.getNextSpaces().add(millionaireEstates);
        
        
      
      // all spaces setup!
      return startSpace;
    }
}