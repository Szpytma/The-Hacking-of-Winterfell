import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class BattleTests {

    private Battle battle;

    @BeforeEach
    void setUp() {
        battle = new Battle();
    }

    @Test
    void caluclateBattleResultScenario1() {
        assertEquals("White Walker Army | 6",
                battle.run("Seven Kingdom Army", 4, 5));
    }

    @Test
    void calculateBattleResultScenario2() {
        assertEquals("Seven Kingdom Army | 5",
                battle.run("Seven Kingdom Army", 10, 5));
    }

    @Test
    void calculateBattleResultScenario3() {
        assertEquals("Seven Kingdom Army | 3",
                battle.run("Seven Kingdom Army", 16, 18));
    }

    @Test
    void calculateBattleResultScenario4() {
        assertEquals("White Walker Army | 4",
                battle.run("Seven Kingdom Army", 2, 6));
    }

    @Test
    void getAnErrorMessageIfValuesNegative() {
        assertEquals("Invalid parameter provided",
                battle.run("Seven Kingdom Army", -4, 5));
    }
}