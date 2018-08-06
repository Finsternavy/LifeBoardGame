package backEnd;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Define Space attributes
 */
@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class Space {
    // List of spaces that you can go forward to
    private final List<Space> nextSpaces;
    
    // If the actions are mandatory or not
    private final boolean isMandatory;
    
    // List of actions to execute upon landing here
    private final List<Action> actions;
    
    // The type of space
    private final SpaceType spaceType;
    
    // The text to render when landing ON this space
    private final landingText;
    
    // The text to render when presented with a split choice
    private final splitText;
}