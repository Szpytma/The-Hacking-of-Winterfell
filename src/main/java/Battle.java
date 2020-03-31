public class Battle {

    Army sevenKingdomArmy;
    Army whiteWalkerArmy;
    String winner = "";

    public String run(String firstTurn, int no_of_dragons, int no_of_white_lords) {
        int attacksCounter = 0;

        if (no_of_dragons < 0 || no_of_white_lords < 0) {
            return "Invalid parameter provided";
        }

        sevenKingdomArmy = new Army(new Soldiers(600, 600, no_of_dragons),
                                    new Soldiers(2, 2, 5000),
                                    "Seven Kingdom Army");

        whiteWalkerArmy = new Army(new Soldiers(50, 100, no_of_white_lords),
                                    new Soldiers(1, 3, 10000),
                                    "White Walker Army");

        while (winner.isEmpty()) {
            if (firstTurn == sevenKingdomArmy.getArmyName()) {
                attack(sevenKingdomArmy, whiteWalkerArmy);
                firstTurn = whiteWalkerArmy.getArmyName();
            } else {
                attack(whiteWalkerArmy, sevenKingdomArmy);
                firstTurn = sevenKingdomArmy.getArmyName();
            }
            attacksCounter++;
        }

        return winner + " | " + attacksCounter;
    }

    private void attack(Army attackers, Army defenders) {
        int attack = attackers.getAttackValue();
        attack = attackSimpleSoldiers(defenders, attack);
        attackElite(defenders, attack);
        tryToAssignAWinner(attackers, defenders);
    }

    private void attackElite(Army defenders, int attack) {
        while (attack > defenders.getEliteDefense() && defenders.areEliteStillalive()) {
            defenders.eliteDie();
            attack -= defenders.getEliteDefense();
        }
    }

    private int attackSimpleSoldiers(Army defenders, int attack) {
        while (attack > defenders.getSimpleSoldiersDefense() && defenders.areSimpleSoldiersStillAlive()) {
            defenders.simpleSoldiersDie();
            attack -= defenders.getSimpleSoldiersDefense();
        }
        return attack;
    }

    private void tryToAssignAWinner(Army attackers, Army defenders) {
        if (!defenders.areEliteStillalive() && !defenders.areSimpleSoldiersStillAlive()) {
            winner = attackers.getArmyName();
        }
    }
}
