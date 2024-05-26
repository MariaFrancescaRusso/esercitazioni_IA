package com.esrcizioU2;

import aima.core.agent.Action;
import aima.core.agent.impl.DynamicAction;
import aima.core.search.framework.problem.ActionsFunction;

import java.util.HashSet;
import java.util.Set;

public class U2Actions implements ActionsFunction
{
    public static Action B = new DynamicAction("B");
    public static Action E = new DynamicAction("E");
    public static Action A = new DynamicAction("A");
    public static Action L = new DynamicAction("L");
    public static Action BE = new DynamicAction("BE");
    public static Action BA = new DynamicAction("BA");
    public static Action BL = new DynamicAction("BL");
    public static Action EA = new DynamicAction("EL");
    public static Action AL = new DynamicAction("AL");

    @Override
    public Set<Action> actions(Object state)
    {
        U2State u2State = (U2State) state;
        Set<Action> actionSet = new HashSet<>();




        return actionSet;
    }
}
