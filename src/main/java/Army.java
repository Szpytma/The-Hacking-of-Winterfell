class Army {
    Soldiers elite;
    Soldiers simpleSoldiers;
    private String armyName;

    public Army(Soldiers elite, Soldiers simpleSoldiers, String armyName) {
        this.elite = elite;
        this.simpleSoldiers = simpleSoldiers;
        this.armyName = armyName;
    }

    public String getArmyName(){
        return armyName;
    }

    public int getAttackValue(){
        return elite.attack * elite.amount +
                simpleSoldiers.attack * simpleSoldiers.amount;
    }

    public void eliteDie(){
        elite.amount --;
    }

    public int getEliteDefense(){
        return elite.defense;
    }

    public boolean areEliteStillalive(){
        return elite.amount > 0;
    }

    public void simpleSoldiersDie(){
        simpleSoldiers.amount --;
    }

    public int getSimpleSoldiersDefense(){
        return simpleSoldiers.defense;
    }

    public boolean areSimpleSoldiersStillAlive(){
        return simpleSoldiers.amount > 0;
    }

}
