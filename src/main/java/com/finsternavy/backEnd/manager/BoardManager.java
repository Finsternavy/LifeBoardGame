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
            .landingText("Start college, take out a $40,000 loan")
            .actions(new ArrayList<Action>()) // todo, define actions
            .nextSpaces(new ArrayList<Space>());
        startSpace.getNextSpaces().add(college1);
        
        Space college2 = Space.builder()
            .isMandatory(true)
            .landingText("Scholarship! Collect $20,000")
            .actions(new ArrayList<Action>()
            .nextPaces(new ArrayList<Space>());
        college1.getNextSpaces().add(college2);
        
        Space college3 = Space.builder()
            .isMandatory(true)
            .landingText("Buy books and supplies, pay $5,000")
            .actions(new ArrayList<Action>()
            .nextPaces(new ArrayList<Space>());
        college2.getNextSpaces().add(college3);
        
        Space college4 = Space.builder()
            .isMandatory(true)
            .landingText("Make a new friend. Life Tile Added")
            .actions(new ArrayList<Action>()
            .nextPaces(new ArrayList<Space>());
        college3.getNextSpaces().add(college4);
        
        Space college5 = Space.builder()
            .isMandatory(true)
            .landingText("Part time job, collect $5,000")
            .actions(new ArrayList<Action>()
            .nextPaces(new ArrayList<Space>());
        college4.getNextSpaces().add(college5);
        
        Space college6 = Space.builder()
            .isMandatory(true)
            .landingText("Cram for exams, lose next turn")
            .actions(new ArrayList<Action>()
            .nextPaces(new ArrayList<Space>());
        college5.getNextSpaces().add(college6);
        
        Space college7 = Space.builder()
            .isMandatory(true)
            .landingText("Study in Europe, Life Tile added")
            .actions(new ArrayList<Action>()
            .nextPaces(new ArrayList<Space>());
        college6.getNextSpaces().add(college7);
        
        Space college8 = Space.builder()
            .isMandatory(true)
            .landingText("Spring break in Florida, pay $5,000")
            .actions(new ArrayList<Action>()
            .nextPaces(new ArrayList<Space>());
        college7.getNextSpaces().add(college8);
        
        Space college9 = Space.builder()
            .isMandatory(true)
            .landingText("Dean's list. Life Tile added")
            .actions(new ArrayList<Action>()
            .nextPaces(new ArrayList<Space>());
        college8.getNextSpaces().add(college9);
        
        Space college10 = Space.builder()
            .isMandatory(true)
            .landingText("Write term paper. Lose next turn.")
            .actions(new ArrayList<Action>()
            .nextPaces(new ArrayList<Space>());
        college9.getNextSpaces().add(college10);
        
        Space college11 = Space.builder()
            .isMandatory(true)
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
            .landingText("Start career. Pick job and salary")
            .actions(new ArrayList<Action>()) // todo, define actions
            .nextSpaces(new ArrayList<Space>());
        startSpace.getNextSpaces().add(nonCollege1);
        
        // define where they link up
        // todo ...
        Space shared1 = Space.builder()
            .isMandatory(true)
            .landingText("Pay Day!")
            .actions(new ArrayList<Action>()) // todo, define actions
            .nextSpaces(new ArrayList<Space>());
        nonCollege1.getNextSpaces().add(shared1);
        college12.getNextSpace().add(shared1);
        
        // define straight path to next split
        // todo ...
        Space shared2 = Space.builder()
            .isMandatory(true)
            .landingText("Pay Day!")
            .actions(new ArrayList<Action>()) // todo, define actions
            .nextSpaces(new ArrayList<Space>());
        shared2.getNextSpaces().add(shared1);
      
      
      // all spaces setup!
      return startSpace;
    }
}