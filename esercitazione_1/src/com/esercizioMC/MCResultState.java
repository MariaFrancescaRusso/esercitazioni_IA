package com.esercizioMC;

import aima.core.agent.Action;
import aima.core.search.framework.evalfunc.HeuristicFunction;
import aima.core.search.framework.problem.ResultFunction;
import aima.core.search.framework.problem.StepCostFunction;

public class MCResultState implements ResultFunction, StepCostFunction, HeuristicFunction
{
    @Override
    public Object result(Object state, Action action)
    {
        MCState mcState = (MCState) state;
        MCState mcStateResult = new MCState();

        if (mcState.getBarca() == 1)
        {
            if (MCActions.MC.equals(action))
                mcStateResult.setState(mcState.getMissionari()-1, mcState.getCannibali()-1, 0);

            if (MCActions.MM.equals(action))
                mcStateResult.setState(mcState.getMissionari()-2, mcState.getCannibali(), 0);

            if (MCActions.CC.equals(action))
                mcStateResult.setState(mcState.getMissionari(), mcState.getCannibali()-2, 0);

            if (MCActions.M.equals(action))
                mcStateResult.setState(mcState.getMissionari()-1, mcState.getCannibali(), 0);

            if (MCActions.C.equals(action))
                mcStateResult.setState(mcState.getMissionari(), mcState.getCannibali()-1, 0);
        }

        if (mcState.getBarca() == 0)
        {
            if (MCActions.MC.equals(action))
                mcStateResult.setState(mcState.getMissionari()+1, mcState.getCannibali()+1, 1);

            if (MCActions.MM.equals(action))
                mcStateResult.setState(mcState.getMissionari()+2, mcState.getCannibali(), 1);

            if (MCActions.CC.equals(action))
                mcStateResult.setState(mcState.getMissionari(), mcState.getCannibali()+2, 1);

            if (MCActions.M.equals(action))
                mcStateResult.setState(mcState.getMissionari()+1, mcState.getCannibali(), 1);

            if (MCActions.C.equals(action))
                mcStateResult.setState(mcState.getMissionari(), mcState.getCannibali()+1, 1);
        }

        System.out.println(action.toString());
        System.out.println(mcStateResult.toString());
        return mcStateResult;
    }

    @Override
    public double c(Object fromState, Action action, Object toState)
    {
        return 1.0;
    }

    @Override
    public double h(Object state)
    {
        if (state instanceof MCState)
        {
            MCState mcState = (MCState) state;
            int hVal = mcState.getMissionari() + mcState.getCannibali() - ((mcState.getBarca()==1)? 1:0);
            return hVal;
        }
        else return Integer.MAX_VALUE;
    }
}
