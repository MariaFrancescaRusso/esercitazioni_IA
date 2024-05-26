package com.esrcizioU2;

import aima.core.agent.Action;
import aima.core.search.framework.evalfunc.HeuristicFunction;
import aima.core.search.framework.problem.ResultFunction;
import aima.core.search.framework.problem.StepCostFunction;

public class U2ResultState implements ResultFunction, StepCostFunction, HeuristicFunction
{
    @Override
    public Object result(Object state, Action action)
    {
        U2State u2State = (U2State) state;
        U2State u2StateResult = new U2State();

        if (u2State.getBarca() == 1)
        {
            if (U2Actions.MC.equals(action))
                u2StateResult.setState(u2State.getMissionari()-1, u2State.getCannibali()-1, 0);

            if (U2Actions.MM.equals(action))
                u2StateResult.setState(u2State.getMissionari()-2, u2State.getCannibali(), 0);

            if (U2Actions.CC.equals(action))
                u2StateResult.setState(u2State.getMissionari(), u2State.getCannibali()-2, 0);

            if (U2Actions.M.equals(action))
                u2StateResult.setState(u2State.getMissionari()-1, u2State.getCannibali(), 0);

            if (U2Actions.C.equals(action))
                u2StateResult.setState(u2State.getMissionari(), u2State.getCannibali()-1, 0);
        }

        if (u2State.getBarca() == 0)
        {
            if (U2Actions.MC.equals(action))
                u2StateResult.setState(u2State.getMissionari()+1, u2State.getCannibali()+1, 1);

            if (U2Actions.MM.equals(action))
                u2StateResult.setState(u2State.getMissionari()+2, u2State.getCannibali(), 1);

            if (U2Actions.CC.equals(action))
                u2StateResult.setState(u2State.getMissionari(), u2State.getCannibali()+2, 1);

            if (U2Actions.M.equals(action))
                u2StateResult.setState(u2State.getMissionari()+1, u2State.getCannibali(), 1);

            if (U2Actions.C.equals(action))
                u2StateResult.setState(u2State.getMissionari(), u2State.getCannibali()+1, 1);
        }

        System.out.println(action.toString());
        System.out.println(u2StateResult.toString());
        return u2StateResult;
    }

    @Override
    public double c(Object fromState, Action action, Object toState)
    {
        return 1.0;
    }

    @Override
    public double h(Object state)
    {
        if (state instanceof U2State)
        {
            U2State u2State = (U2State) state;
            int hVal = u2State.getMissionari() + u2State.getCannibali() - ((u2State.getBarca()==1)? 1:0);
            return hVal;
        }
        else return Integer.MAX_VALUE;
    }
}
