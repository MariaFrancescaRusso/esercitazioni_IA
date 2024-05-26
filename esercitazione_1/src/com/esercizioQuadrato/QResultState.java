package com.esercizioQuadrato;

import aima.core.agent.Action;
import aima.core.search.framework.evalfunc.HeuristicFunction;
import aima.core.search.framework.problem.ResultFunction;
import aima.core.search.framework.problem.StepCostFunction;

public class QResultState implements ResultFunction, StepCostFunction, HeuristicFunction
{
    @Override
    public Object result(Object state, Action action)
    {
        QState qState = (QState) state;
        QState qStateResult = new QState(qState.getMaxRiga(), qState.getMaxColonna());

        int riga = qState.getLastRiga();
        int colonna = qState.getLastColonna();
        int nuovoNum = qState.getLastNumber() + 1;

        qStateResult.copyState(qState);
        qStateResult.deleteState(nuovoNum);

        if (QActions.N.equals(action))
            qStateResult.setState(riga-3, colonna, nuovoNum);

        if (QActions.S.equals(action))
            qStateResult.setState(riga+3, colonna, nuovoNum);

        if (QActions.E.equals(action))
            qStateResult.setState(riga, colonna+3, nuovoNum);

        if (QActions.O.equals(action))
            qStateResult.setState(riga, colonna-3, nuovoNum);

        if (QActions.DNE.equals(action))
            qStateResult.setState(riga-2, colonna+2, nuovoNum);

        if (QActions.DNO.equals(action))
            qStateResult.setState(riga-2, colonna-2, nuovoNum);

        if (QActions.DSE.equals(action))
            qStateResult.setState(riga+2, colonna+2, nuovoNum);

        if (QActions.DSO.equals(action))
            qStateResult.setState(riga+2, colonna-2, nuovoNum);

        return qStateResult;
    }

    @Override
    public double c(Object fromState, Action action, Object toState)
    {
        QState qState = (QState) toState;
        return 1.0;
//        return (qState.getMaxRiga()*qState.getMaxColonna()) - qState.getLastNumber();
    }

    @Override
    public double h(Object state)
    {
        if (state instanceof QState)
        {
            QState qState = (QState) state;
//            int hVal = qState.getLastNumber();
//            return hVal;
            return 1.0;
        }
        else
            return Integer.MAX_VALUE;
    }
}
