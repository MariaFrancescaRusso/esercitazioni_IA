package com.esercizioMC;

import aima.core.agent.Action;
import aima.core.agent.impl.DynamicAction;
import aima.core.search.framework.problem.ActionsFunction;

import java.util.HashSet;
import java.util.Set;

public class MCActions implements ActionsFunction
{
    public static Action MC = new DynamicAction("MC");
    public static Action MM = new DynamicAction("MM");
    public static Action CC = new DynamicAction("CC");
    public static Action M = new DynamicAction("M");
    public static Action C = new DynamicAction("C");

    @Override
    public Set<Action> actions(Object state)
    {
        MCState mcState = (MCState) state;
        Set<Action> actionSet = new HashSet<>();

        //caso barca si trova sulla sponda di sinistra e deve andare in quella di destra
        if ( mcState.getBarca() == 1)
        {
            /* Action MC */
            if ((mcState.getCannibali()-1)>=0 && (mcState.getMissionari()-1)>=0)
                if (((mcState.getCannibali() - 1) <= (mcState.getMissionari() - 1)) || ((mcState.getMissionari() - 1) == 0) ) //controllo sponda di sinistra
                    if (((3 - mcState.getCannibali()) + 1) <= ((3 - mcState.getMissionari()) + 1)) //controllo sponda di destra
                        actionSet.add(MC);

            /* Action MM */
            if ((mcState.getMissionari()-2) >= 0)
                if ((mcState.getCannibali() <= (mcState.getMissionari()-2)) || ((mcState.getMissionari() - 2) == 0) )  //controllo sponda di sinistra
                    if((3-mcState.getCannibali()) <= ((3-mcState.getMissionari())+2)) //controllo sponda di destra
                        actionSet.add(MM);

            /* Action CC */
            if ((mcState.getCannibali()-2) >= 0)
                if (((mcState.getCannibali()-2) <= mcState.getMissionari()) || (mcState.getMissionari() == 0) )  //controllo sponda di sinistra
                    if((((3-mcState.getCannibali())+2) <= (3-mcState.getMissionari())) || ((3-mcState.getMissionari()) == 0)) //controllo sponda di destra
                        actionSet.add(CC);

            /* Action M */
            if ((mcState.getMissionari()-1) >= 0)
                if ((mcState.getCannibali() <= (mcState.getMissionari()-1)) || ((mcState.getMissionari() - 1) == 0) )  //controllo sponda di sinistra
                    if((3-mcState.getCannibali()) <= ((3-mcState.getMissionari())+1)) //controllo sponda di destra
                        actionSet.add(M);

            /* Action C */
            if ((mcState.getCannibali()-1) >= 0)
                if (((mcState.getCannibali()-1) <= mcState.getMissionari()) || (mcState.getMissionari() == 0) )  //controllo sponda di sinistra
                    if((((3-mcState.getCannibali())+1) <= (3-mcState.getMissionari())) || ((3-mcState.getMissionari()) == 0)) //controllo sponda di destra
                        actionSet.add(C);
        }

        //caso barca si trova sulla sponda di destra e deve tornare in quella di sinistra
        if(mcState.getBarca() == 0)
        {
            /* Action MC */
            if(((3-mcState.getCannibali())-1)>=0 && ((3-mcState.getMissionari())-1)>=0)
                if ((mcState.getCannibali()+1) <= (mcState.getMissionari()+1))  //controllo sponda di sinistra
                    if((((3-mcState.getCannibali())-1) <= ((3-mcState.getMissionari())-1)) || (((3-mcState.getMissionari())-1) == 0) ) //controllo sponda di destra
                        actionSet.add(MC);

            /* Action MM */
            if(((3-mcState.getMissionari())-2) >= 0)
                if (mcState.getCannibali() <= (mcState.getMissionari()+2))  //controllo sponda di sinistra
                    if(((3-mcState.getCannibali()) <= ((3-mcState.getMissionari())-2)) || (((3-mcState.getMissionari())-2) == 0)) //controllo sponda di destra
                        actionSet.add(MM);

            /* Action CC */
            if(((3-mcState.getCannibali())-2) >= 0)
                if (((mcState.getCannibali()+2) <= mcState.getMissionari()) || (mcState.getMissionari() == 0))  //controllo sponda di sinistra
                    if((((3-mcState.getCannibali())-2) <= (3-mcState.getMissionari())) || ((3-mcState.getMissionari()) == 0)) //controllo sponda di destra
                        actionSet.add(CC);

            /* Action M */
            if(((3-mcState.getMissionari())-1) >= 0)
                if (mcState.getCannibali() <= (mcState.getMissionari()+1))  //controllo sponda di sinistra
                    if((3-mcState.getCannibali()) <= ((3-mcState.getMissionari())-1) || (((3-mcState.getMissionari())-1) == 0)) //controllo sponda di destra
                        actionSet.add(M);

            /* Action C */
            if(((3-mcState.getCannibali())-1) >= 0)
                if (((mcState.getCannibali()+1) <= mcState.getMissionari()) || (mcState.getMissionari() == 0))  //controllo sponda di sinistra
                    if((((3-mcState.getCannibali())-1) <= (3-mcState.getMissionari())) || ((3-mcState.getMissionari()) == 0)) //controllo sponda di destra
                        actionSet.add(C);
        }

        return actionSet;
    }
}
