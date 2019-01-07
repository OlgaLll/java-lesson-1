package ru.rzn.sbt.javaschool.basics;

public class LethalWeapon {
    public String color="";
    private int roundsLeft=0;
    private Double power=0.0;
    public Double getPower() {return this.power;}
    public void setPower(Double p) {this.power = p;}
    public void reload(int i) {this.roundsLeft = this.roundsLeft+i;}
    public void pewPew() {this.roundsLeft = this.roundsLeft-2;}

    private static long nextSerial=0;
    private final long serial;
    public long getSerial(){return this.serial;}

    public LethalWeapon() {this.serial = nextSerial; nextSerial= this.serial+1;}
    public LethalWeapon(String aColor, Double aPower, int aRoundsLeft) {
        this.color = aColor;
        this.power = aPower;
        this.roundsLeft = aRoundsLeft;
        this.serial = nextSerial;
        nextSerial = this.serial+1;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (obj instanceof LethalWeapon) {} else return false;
        LethalWeapon other = (LethalWeapon) obj;
        if (this.color.equals(other.color)) {
            if (this.power.equals(other.getPower())) {
                if (this.roundsLeft==other.roundsLeft) {return true;}
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.roundsLeft+this.power.hashCode()+this.color.hashCode();
    }
}
