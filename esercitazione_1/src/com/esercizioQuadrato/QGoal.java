package com.esercizioQuadrato;

import aima.core.search.framework.problem.GoalTest;

public class QGoal implements GoalTest
{
    @Override
    public boolean isGoalState(Object state)
    {
        QState qState = (QState) state;
        /** Metodo 1: controllo che nella matrice non ci siano ancora quadrati vuoti (= 0) **/
//        boolean isGoal = true;
//
//        for (int r=1; r<=qState.getMaxRiga(); r++)
//        {
//            for (int c=1; c<=qState.getMaxColonna(); c++)
//            {
//                if (qState.getMatrice()[r][c] == 0)
//                {
//                    isGoal = false;
//                    break;
//                }
//            }
//        }
//
//        return isGoal;

        /** Metodo 2: controllo che l'ultimo numero inserito sia maxRiga*maxColonna **/
        if (qState.getLastNumber() == (qState.getMaxRiga()*qState.getMaxColonna()))
        {
            System.out.println("GOAL!\n" + qState.toString());
            return true;
        }
        else
            return false;
    }
}
