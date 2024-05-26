package com.esercizioMC;

import java.util.Objects;

public class MCState
{
    private int missionari;
    private int cannibali;
    private int barca;

    public MCState()
    {
        //situazione iniziale: tutti sulla sponda di sinistra
        this.setState(3,3,1);
    }

    public void setState (int missionari, int cannibali, int barca)
    {
        this.setMissionari(missionari);
        this.setCannibali(cannibali);
        this.setBarca(barca);
    }

    public int getMissionari() {
        return missionari;
    }

    public void setMissionari(int missionari) {
        this.missionari = missionari;
    }

    public int getCannibali() {
        return cannibali;
    }

    public void setCannibali(int cannibali) {
        this.cannibali = cannibali;
    }

    public int getBarca() {
        return barca;
    }

    public void setBarca(int barca) {
        this.barca = barca;
    }

    /***************************************************************************/

    @Override
    public boolean equals(Object state)
    {
        MCState mcState = (MCState) state;
        return ( (this.getMissionari() == mcState.getMissionari()) &&
                (this.getCannibali() == mcState.getCannibali()) &&
                (this.getBarca() == mcState.getBarca()) );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(missionari, cannibali, barca);
    }

    @Override
    public String toString()
    {
        return "QState\nSponda sinistra { " +
                " missionari = " + missionari +
                ", cannibali = " + cannibali +
                ", barca = " + barca +
                " }\nSponda destra {" +
                " missionari = " + (3-missionari) +
                ", cannibali = " + (3-cannibali) +
                ", barca = " + ((barca==1)?0:1) +
                " }";
    }
}
