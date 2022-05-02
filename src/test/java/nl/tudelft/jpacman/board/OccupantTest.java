package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test suite to confirm that {@link Unit}s correctly (de)occupy squares.
 *
 * @author Jeroen Roosen 
 *
 */
class OccupantTest {

    /**
     * The unit under test.
     */
    private Unit unit;

    /**
     * Resets the unit under test.
     */
    @BeforeEach
    void setUp() {
        unit = new BasicUnit();
    }

    /**
     * Asserts that a unit has no square to start with.
     */
    @Test
    void noStartSquare() {
        // Remove the following placeholder:
        assertThat(unit).isNotNull();
        assertThat(unit.hasSquare()).isFalse();
        
    }

    /**
     * Tests that the unit indeed has the target square as its base after
     * occupation.
     */
    @Test
    void testOccupy() {
    	Square square = new BasicSquare();
    	unit.occupy(square);
    	
    	assertThat(unit.getSquare()).isEqualTo(square);
    	assertThat(square.getOccupants()).contains(unit);
    }

    @Test
    void testReoccupy() {
        Square square1 = new BasicSquare();
        Square square2 = new BasicSquare();
        unit.occupy(square1);
        assertThat(unit.getSquare()).isEqualTo(square1);
        assertThat(square1.getOccupants()).contains(unit);
        unit.occupy(square2);
        assertThat(unit.getSquare()).isEqualTo(square2);
        assertThat(square2.getOccupants()).contains(unit);
    }
}
