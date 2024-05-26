package com.esercizioQuadrato;

import aima.core.agent.Action;
import aima.core.agent.impl.DynamicAction;
import aima.core.search.framework.problem.ActionsFunction;

import java.util.HashSet;
import java.util.Set;

public class QActions implements ActionsFunction
{
    /** Azioni fatte muovendosi NSEO: +2 caselle **/
    public static Action N = new DynamicAction("N");   //Nord
    public static Action S = new DynamicAction("S");   //Sud
    public static Action E = new DynamicAction("E");   //Est
    public static Action O = new DynamicAction("O");    //Ovest
    /** Azioni farre muovendosi in diagonale: +1 casella **/
    public static Action DNE = new DynamicAction("DNE"); //Diagonale Nord-Est
    public static Action DNO = new DynamicAction("DNO"); //Diagonale Nord-Ovest
    public static Action DSE = new DynamicAction("DSE");  //Diagonale Sud-Est
    public static Action DSO = new DynamicAction("DSO");   //Diagonale Sud-Ovest

    @Override
    public Set<Action> actions(Object state)
    {
        QState qState = (QState) state;
        Set<Action> actionSet = new HashSet<>();

        int riga = qState.getLastRiga();
        int colonna = qState.getLastColonna();

        int maxRiga = qState.getMaxRiga();
        int maxColonna = qState.getMaxColonna();

        //da posizione ultimo quadrato riempito --> controllo le possibili azioni:
        System.out.println("Stato in (" + riga + ", " + colonna + ") : " + qState.getLastNumber());
        /* vincoli : prossimo quadrato vuoto e: */
        //se riga = 1 o 2 o 3 --> NO azione N
        //se colonna = 1 o 2 --> NO azione O
        //se riga = 10 o 9 o 8 --> NO azione S
        //se colonna = 10 o 9 0 8--> NO azione E
        //se r1 o r2 o c1 o c2 --> NO DNO
        //se r1 o r2 o c9 o c10 --> NO DNE
        //se r9 o r10 o c1 o c2 --> NO DSO
        //se r9 o r10 o c9 o c10 --> NO DSE

        if (riga>=1 && riga<=maxRiga && colonna>=1 && colonna<=maxColonna)
        {
            /* azione N */
            if (riga!=1 && riga!=2 && riga!=3)
                if (qState.getMatrice()[riga - 3][colonna] == 0)
                    actionSet.add(N);

            /* azione S */
            if (riga!=(maxRiga-2) && riga!=(maxRiga-1) && riga!=maxRiga)
                if (qState.getMatrice()[riga + 3][colonna] == 0)
                    actionSet.add(S);

            /* azione E */
            if (colonna!=(maxColonna-2) && colonna!=(maxColonna-1) && colonna!=maxColonna)
                if (qState.getMatrice()[riga][colonna + 3] == 0)
                    actionSet.add(E);

            /* azione O */
            if (colonna!=1 && colonna!=2 && colonna!=3)
                if (qState.getMatrice()[riga][colonna - 3] == 0)
                    actionSet.add(O);

            /* azione DNE */
            if (riga!=1 && riga!=2 && colonna!=(maxColonna-1) && colonna!=maxColonna)
                if (qState.getMatrice()[riga - 2][colonna + 2] == 0)
                    actionSet.add(DNE);

            /* azione DNO */
            if (riga!=1 && riga!=2 && colonna!=1 && colonna!=2)
                if (qState.getMatrice()[riga - 2][colonna - 2] == 0)
                    actionSet.add(DNO);

            /* azione DSE */
            if (riga!=(maxRiga-1) && riga!=maxRiga && colonna!=(maxColonna-1) && colonna!=maxColonna)
                if (qState.getMatrice()[riga + 2][colonna + 2] == 0)
                    actionSet.add(DSE);

            /* azione DSO */
            if (riga!=(maxRiga-1) && riga!=maxRiga && colonna!=1 && colonna!=2)
                if (qState.getMatrice()[riga + 2][colonna - 2] == 0)
                    actionSet.add(DSO);
        }

        System.out.println("Azioni possibili: ");
        for (Action action : actionSet)
            System.out.println(action.toString());

        return actionSet;
    }
}
