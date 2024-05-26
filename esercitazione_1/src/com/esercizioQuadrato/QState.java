package com.esercizioQuadrato;

import java.util.HashSet;
import java.util.Set;

public class QState
{
    private int[][] matrice;
    private int maxRiga;
    private int maxColonna;
    private int lastRiga;
    private int lastColonna;
    private int lastNumber;

    public QState()
    {

    }

    public QState(int maxRiga, int maxColonna)
    {
        /** situazione iniziale: quadrato = matrice maxRiga*maxColonna con quadratino in (1,1) = 1 e altri vuoti = 0 **/
        this.maxRiga = maxRiga;
        this.maxColonna = maxColonna;
        this.matrice = new int[maxRiga+1][maxColonna+1];
        this.matrice[1][1] = 1;

        this.lastRiga = 1;
        this.lastColonna = 1;
        this.lastNumber = 1;
    }

    public void setState(int riga, int colonna, int numero)
    {
        this.getMatrice()[riga][colonna] = numero;

        this.setLastRiga(riga);
        this.setLastColonna(colonna);
        this.setLastNumber(numero);
    }

    public void copyState(QState qState)
    {
        this.setLastNumber(qState.getLastNumber());
        this.setLastRiga(qState.getLastRiga());
        this.setLastColonna(qState.getLastColonna());

        this.setMaxRiga(qState.getMaxRiga());
        this.setMaxColonna(qState.getMaxColonna());

        this.matrice = new int[this.getMaxRiga()+1][this.getMaxColonna()+1];

        for (int r=1; r<=qState.getMaxRiga(); r++)
        {
            for (int c=1; c<=qState.getMaxColonna(); c++)
            {
                this.getMatrice()[r][c] = qState.getMatrice()[r][c];
            }
        }
    }

    public void deleteState(int numero)
    {
        for (int r=1; r<=this.getMaxRiga(); r++)
        {
            for (int c=1; c<=this.getMaxColonna(); c++)
            {
                if (this.getMatrice()[r][c] == numero)
                {
                    this.setState(r,c,0);
                    break;
                }
            }
        }
    }

    public boolean isComplete(int initRiga, int endRiga, int initColonna, int endColonna)
    {
        boolean isComplete = true;

        for (int r=initRiga; r<=endRiga; r++)
        {
            for (int c=initColonna; c<=endColonna; c++)
            {
                if (this.getMatrice()[r][c] == 0)
                {
                    isComplete = false;
                    break;
                }
            }
        }

        return isComplete;
    }

    /** GET and SET **/

    public int[][] getMatrice()
    {
        return matrice;
    }

    public int getMaxRiga() {
        return maxRiga;
    }

    public void setMaxRiga(int maxRiga) {
        this.maxRiga = maxRiga;
    }

    public int getMaxColonna() {
        return maxColonna;
    }

    public void setMaxColonna(int maxColonna) {
        this.maxColonna = maxColonna;
    }

    public int getLastRiga()
    {
        return lastRiga;
    }

    public void setLastRiga(int lastRiga)
    {
        this.lastRiga = lastRiga;
    }

    public int getLastColonna()
    {
        return lastColonna;
    }

    public void setLastColonna(int lastColonna)
    {
        this.lastColonna = lastColonna;
    }

    public int getLastNumber()
    {
        return lastNumber;
    }

    public void setLastNumber(int lastNumber)
    {
        this.lastNumber = lastNumber;
    }

    /** Generic Functions **/

    @Override
    public int hashCode()
    {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object state)
    {
        QState qState = (QState) state;

        if(this.getMaxColonna() != qState.getMaxColonna() || this.getMaxRiga() != qState.getMaxRiga())
            return false;
        else
            //se confronto tutto anche ultima posizione
//            return (equalsMatrici(qState.getMatrice()) &&
//                    qState.getLastNumber() == this.getLastNumber() &&
//                    qState.getLastColonna() == this.getLastColonna() &&
//                    qState.getLastRiga() == this.getLastRiga());
            //se contronto solo la matrice
            return (equalsMatrici(qState.getMatrice()));
    }

    private boolean equalsMatrici(int[][] a)
    {
        boolean result = true;

        for (int r=1; r<=this.getMaxRiga(); r++)
        {
            for (int c=1; c<=this.getMaxColonna(); c++)
            {
                if (this.getMatrice()[r][c] != a[r][c])
                {
                    result = false;
                    break;
                }
            }
        }

        return result;
    }

    @Override
    public String toString()
    {
        String matriceString = "\n";
        int riga = 1;
        int colonna = 1;

        matriceString += stampaNumeriRiga();
        matriceString += stampaRiga();

        while (riga<=this.getMaxRiga() || colonna<=this.getMaxColonna())
        {
            if (colonna == 1)
                matriceString += stampaNumeriColonna(riga);

            matriceString += stampaNumMatrice(riga, colonna);

            if (colonna == this.getMaxColonna())
            {
                matriceString += "\n" + stampaRiga();

                if (riga!=this.getMaxRiga())
                    colonna = 1;
                else
                    colonna++;

                riga++;
            }
            else
                colonna++;
        }

        return matriceString;
    }

    private String stampaNumMatrice(int riga, int colonna)
    {
        String result = "";

        if (this.getMatrice()[riga][colonna] == 0)
            result += "|    |";
        else
        {
            if (this.getMatrice()[riga][colonna] >= 1 && this.getMatrice()[riga][colonna] <= 9)
                result += "|  " + this.getMatrice()[riga][colonna] + " |";

            if (this.getMatrice()[riga][colonna] >= 10 && this.getMatrice()[riga][colonna] <= 99)
                result += "| " + this.getMatrice()[riga][colonna] + " |";

            if (this.getMatrice()[riga][colonna] >= 100)
                result += "|" + this.getMatrice()[riga][colonna] + " |";
        }

        return result;
    }

    private String stampaRiga ()
    {
        String result = "      ";

        for (int i=1; i<=this.getMaxRiga(); i++)
        {
            result += "------";

            if (i == this.getMaxRiga())
                result += "\n";
        }

        return result;
    }


    private String stampaNumeriRiga()
    {
        String result = "      ";

        for (int i=1; i<=this.getMaxRiga(); i++)
        {
            result += "   " + i + "  ";

            if (i == this.getMaxRiga())
                result += "\n";
        }

        return result;
    }

    private String stampaNumeriColonna(int riga)
    {
        String result = "";

        if (riga >= 1 && riga <= 9)
            result += "   " + riga + "  ";

        if (riga >= 10 && riga <= 99)
            result += "  " + riga + "  ";

        return result;
    }
}
