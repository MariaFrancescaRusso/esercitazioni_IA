package com.esercizioMC;

/** Esercizio su Problema "Missionari e Cannibali" **/

import aima.core.agent.Action;
import aima.core.search.framework.SearchAgent;
import aima.core.search.framework.problem.Problem;
import aima.core.search.framework.qsearch.GraphSearch;
import aima.core.search.framework.qsearch.TreeSearch;
import aima.core.search.informed.AStarSearch;
import aima.core.search.informed.GreedyBestFirstSearch;
import aima.core.search.local.HillClimbingSearch;
import aima.core.search.local.SimulatedAnnealingSearch;
import aima.core.search.uninformed.*;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

public class Main
{
    private static void printActions (List<Action> actions)
    {
        for (Action a : actions)
        {
            System.out.println(a.toString());
        }
    }

    private static void printInstrumentation (Properties properties)
    {
        Iterator<Object> keys = properties.keySet().iterator();

        while (keys.hasNext())
        {
            String key = (String) keys.next();
            String property = properties.getProperty(key);
            System.out.println(key + " : " + property.toString());
        }
    }

    public static void main(String[] args)
    {
        MCState mcState = new MCState();
        MCGoal mcGoal = new MCGoal();
        MCActions mcActions = new MCActions();
        MCResultState mcResultState = new MCResultState();

        /** Creazione Problem: **/
        Problem problem = new Problem(mcState, mcActions, mcResultState, mcGoal,  mcResultState);

        try
        {
            /** aima.core.search.uninformed **/
            System.out.println("Breadth First --> Graph Search: \n");
//            System.out.println("Depth First --> Graph Search: \n");
//            System.out.println("Depth Limited --> Graph Search: \n");
//            System.out.println("Uniform Cost --> Graph Search: \n");
//            System.out.println("Iterative Deepening --> Graph Search: \n");
            /** aima.core.search.informed **/
//            System.out.println("Greedy Best First --> Graph Search: \n");
//            System.out.println("A Star --> Graph Search: \n");
//            System.out.println("Simulated Annealing --> Graph Search: \n");
//            System.out.println("Hill Climbing --> Graph Search: \n");

            System.out.println("Stato iniziale: " + mcState.toString());

            /** Tecniche di ricerca:
              * (~ tutte con GraphSearch(); si potrebbe utilizzare anche TreeSearch() (in questo caso non conviene) **/
            /** aima.core.search.uninformed **/
            BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(new GraphSearch());
//            DepthFirstSearch depthFirstSearch = new DepthFirstSearch(new GraphSearch());
//            DepthLimitedSearch depthLimitedSearch = new DepthLimitedSearch(50);
//            UniformCostSearch uniformCostSearch = new UniformCostSearch(new GraphSearch());
//            IterativeDeepeningSearch iterativeDeepeningSearch = new IterativeDeepeningSearch();
            /** aima.core.search.informed **/
//            GreedyBestFirstSearch greedyBestFirstSearch = new GreedyBestFirstSearch(new GraphSearch(), mcResultState);
//            AStarSearch aStarSearch = new AStarSearch(new GraphSearch(), mcResultState);
//            SimulatedAnnealingSearch simulatedAnnealingSearch = new SimulatedAnnealingSearch(mcResultState);
            HillClimbingSearch hillClimbingSearch = new HillClimbingSearch(mcResultState);

            /** Creazione Agent: **/
            /** aima.core.search.uninformed **/
            SearchAgent searchAgent = new SearchAgent(problem, breadthFirstSearch);
//            SearchAgent searchAgent = new SearchAgent(problem, depthFirstSearch);
//            SearchAgent searchAgent = new SearchAgent(problem, depthLimitedSearch);
//            SearchAgent searchAgent = new SearchAgent(problem, uniformCostSearch);
//            SearchAgent searchAgent = new SearchAgent(problem, iterativeDeepeningSearch);
            /** aima.core.search.informed **/
//            SearchAgent searchAgent = new SearchAgent(problem, greedyBestFirstSearch);
//            SearchAgent searchAgent = new SearchAgent(problem, aStarSearch);
//            SearchAgent searchAgent = new SearchAgent(problem, simulatedAnnealingSearch);
//            SearchAgent searchAgent = new SearchAgent(problem, hillClimbingSearch);

            /** stampa risultati di ricerca: **/
            printActions(searchAgent.getActions());
            printInstrumentation(searchAgent.getInstrumentation());

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

/** output a contronto:
  *  - aima.core.search.uninformed:
  *                                Breadth First:   //queueSize : 2
  *                                                 //maxQueueSize : 3
  *                                                 //pathCost : 11.0
  *                                                 //nodesExpanded : 13
  *                                Depth First:   //queueSize : 3
  *                                               //maxQueueSize : 4
  *                                               //pathCost : 11.0
  *                                               //nodesExpanded : 12
  *                                Depth Limited:   //pathCost : 49.0
  *                                                 //nodesExpanded : 6067
  *                                Uniform Cost:   //queueSize : 1
  *                                                //maxQueueSize : 3
  *                                                //pathCost : 11.0
  *                                                //nodesExpanded : 14
  *                                Iterative Deepening:   //pathCost : 11.0
  *                                                       //nodesExpanded : 8730
  *  - aima.core.search.uninformed:
  *                                Greedy Best First:   //queueSize : 3
  *                                                     //maxQueueSize : 4
  *                                                     //pathCost : 11.0
  *                                                     //nodesExpanded : 12
  *                                A Star:   //queueSize : 1
  *                                          //maxQueueSize : 3
  *                                          //pathCost : 11.0
  *                                          //nodesExpanded : 14
  *                                Simulated Annealing:   //temp : 0.23240639749261888
  *                                                       //nodeValue : -0.0
  *                                                       //nodesExpanded : 100
  *                                Hill Climbing:   --> non trova soluzione!
  *                                                 //nodeValue : -4.0
  *                                                 //nodesExpanded : 2
  **/