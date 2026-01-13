public class Enemy {
    private double atk;
    private double def;
    private double hp;
    private double maxHp;

    public Enemy() {
        atk = 4;
        def = 1;
        hp = 15;
        maxHp = hp;
    }

    public double getAtk() {
        return atk;
    }

    public double getDef() {
        return def;
    }

    public double getHp() {
        return hp;
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

    public void setMaxHp(double maxHp) {
        this.maxHp = maxHp;
    }

    public boolean isDead() {
        return hp <= 0;
    }


}
