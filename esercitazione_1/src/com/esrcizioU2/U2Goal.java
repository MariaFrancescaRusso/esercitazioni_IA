package com.esrcizioU2;

import aima.core.search.framework.problem.GoalTest;

public class U2Goal implements GoalTest
{
    @Override
    public boolean isGoalState(Object state)
    {
        U2State u2State = (U2State) state;

        if (u2State.getBono()==0 && u2State.getEdge()==0 && u2State.getAdam()==0 && u2State.getLarry()==0)
        {   //anche la torcia sarà zero --> controllo inutile
            //stato: sono arrivati tutto al concerto
            System.out.println("Goal:\n" + u2State.toString());
            return true;
        }
        else
            return false;
    }
}
