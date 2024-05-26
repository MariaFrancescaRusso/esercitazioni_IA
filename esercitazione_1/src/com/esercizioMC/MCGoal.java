package com.esercizioMC;

import aima.core.search.framework.problem.GoalTest;

public class MCGoal implements GoalTest
{
    @Override
    public boolean isGoalState(Object state)
    {
        MCState mcState = (MCState) state;

        if (mcState.getBarca()==0 && mcState.getCannibali()==0 && mcState.getMissionari()==0) //stato su sponda di sinistra
        {
            System.out.println("Goal: " + mcState.toString());
            return true;
        }
        else
            return false;
    }
}
