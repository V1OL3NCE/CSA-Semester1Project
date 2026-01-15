public class Player {
    private double atk;
    private double def;
    private double hp;
    private double maxHp;

    public Player() {
        atk = 5;
        def = 2;
        hp = 25;
        maxHp = hp;
    }

    public double getAtk() {
        return atk;
    }

    public String getAtkRounded() {
        return String.format("%.2f", getAtk());
    }

    public double getDef() {
        return def;
    }

    public String getDefRounded() {
        return String.format("%.2f", getDef());
    }

    public double getHp() {
        return hp;
    }

    public String getHpRounded() {
        return String.format("%.2f", getHp());
    }

    public double getMaxHp() {
        return maxHp;
    }

    public void setAtk(double atk) {
        this.atk = atk;
    }



    public void setDef(double def) {
        this.def = def;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public void setMaxHp(double maxHp) {this.maxHp = maxHp;}

    public boolean isDead() {return this.hp <= 0;}



}
