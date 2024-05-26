package com.esrcizioU2;

import java.util.Objects;

public class U2State
{
    /** variabili per componenti U2 e per la torcia:
      *     --> se = 1 => si trovano a sinistra del ponte
      *     --> se = 0 => si trovano a destra del ponte e quindi sono arrivato al concerto **/
    private int bono;
    private int edge;
    private int adam;
    private int larry;
    private int torcia;

    public U2State()
    {
        //situazione iniziale: tutti (U2 + torcia) si trovano a sinistra del ponte
        this.setState(1,1,1, 1, 1);
    }

    public void setState (int bono, int edge, int adam, int larry, int torcia)
    {
        this.bono = bono;
        this.edge = edge;
        this.adam = adam;
        this.larry = larry;
        this.torcia = torcia;
    }

    /** GET and SET **/

    public int getBono() {
        return bono;
    }

    public void setBono(int bono) {
        this.bono = bono;
    }

    public int getEdge() {
        return edge;
    }

    public void setEdge(int edge) {
        this.edge = edge;
    }

    public int getAdam() {
        return adam;
    }

    public void setAdam(int adam) {
        this.adam = adam;
    }

    public int getLarry() {
        return larry;
    }

    public void setLarry(int larry) {
        this.larry = larry;
    }

    /***************************************************************************/

    @Override
    public boolean equals(Object state)
    {
        U2State u2State = (U2State) state;

        return ( (bono == u2State.getBono()) &&
                (edge == u2State.getEdge()) &&
                (adam == u2State.getAdam()) &&
                (larry == u2State.getLarry()));
    }

    @Override
    public int hashCode()
    {
        return super.hashCode();
    }

    @Override
    public String toString()
    {
        return "U2: a sinistra del ponte ( " +
                "Bono = " + bono +
                ", Edge = " + edge +
                ", Adam = " + adam +
                ", Larry = " + larry +
                " )\n    arrivati al concerto ( " +
                "Bono = " + ((bono==1)?0:1) +
                ", Edge = " + ((edge==1)?0:1) +
                ", Adam = " + ((adam==1)?0:1) +
                ", Larry = " + ((larry==1)?0:1) +
                " )";
    }
}
