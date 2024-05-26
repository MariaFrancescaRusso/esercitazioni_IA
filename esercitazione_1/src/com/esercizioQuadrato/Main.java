package com.esercizioQuadrato;

/** Esercizio su Problema "Riempimento di un Quadrato" **/

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
        QState qState = new QState(7,7);
        QGoal qGoal = new QGoal();
        QActions qActions = new QActions();
        QResultState qResultState = new QResultState();

        /** Creazione Problem: **/
        Problem problem = new Problem(qState, qActions, qResultState, qGoal, qResultState);

        try
        {
            /** aima.core.search.uninformed **/
//            System.out.println("Breadth First --> Graph Search: \n");
//            System.out.println("Depth First --> Graph Search: \n");
//            System.out.println("Depth Limited --> Graph Search: \n");
//            System.out.println("Uniform Cost --> Graph Search: \n");
//            System.out.println("Iterative Deepening --> Graph Search: \n");
            /** aima.core.search.informed **/
//            System.out.println("Greedy Best First --> Graph Search: \n");
//            System.out.println("A Star --> Graph Search: \n");
//            System.out.println("Simulated Annealing --> Graph Search: \n");
//            System.out.println("Hill Climbing --> Graph Search: \n");

            System.out.println("Stato iniziale: " + qState.toString());

            /** Tecniche di ricerca:
              * (~ tutte con GraphSearch(); si potrebbe utilizzare anche TreeSearch() (in questo caso non conviene) **/
            /** aima.core.search.uninformed **/
            BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(new GraphSearch());
            DepthFirstSearch depthFirstSearch = new DepthFirstSearch(new GraphSearch());
            DepthLimitedSearch depthLimitedSearch = new DepthLimitedSearch(100000);
            UniformCostSearch uniformCostSearch = new UniformCostSearch(new GraphSearch());
            IterativeDeepeningSearch iterativeDeepeningSearch = new IterativeDeepeningSearch();
            /** aima.core.search.informed **/
            GreedyBestFirstSearch greedyBestFirstSearch = new GreedyBestFirstSearch(new GraphSearch(), qResultState);
            AStarSearch aStarSearch = new AStarSearch(new GraphSearch(), qResultState);
            SimulatedAnnealingSearch simulatedAnnealingSearch = new SimulatedAnnealingSearch(qResultState);
            HillClimbingSearch hillClimbingSearch = new HillClimbingSearch(qResultState);

            /** Creazione Agent: **/
            /** aima.core.search.uninformed **/
//            SearchAgent searchAgent = new SearchAgent(problem, breadthFirstSearch);
            SearchAgent searchAgent = new SearchAgent(problem, depthFirstSearch);
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

/** output a contronto: (Matrice 5x5:)
  *  - aima.core.search.uninformed:
  *                                Breadth First:   //queueSize : 2554
  *                                                 //maxQueueSize : 14008
  *                                                 //pathCost : 24.0
  *                                                 //nodesExpanded : 100736
  *                                Depth First:   //queueSize : 10
  *                                               //maxQueueSize : 18
  *                                               //pathCost : 24.0
  *                                               //nodesExpanded : 1425
  *                                Depth Limited:   //pathCost : 24.0
  *                                                 //nodesExpanded : 298
  *                                Uniform Cost:   //queueSize : 551
  *                                                //maxQueueSize : 13855
  *                                                //pathCost : 24.0
  *                                                //nodesExpanded : 103289
  *                                Iterative Deepening:   //pathCost : 24.0
  *                                                       //nodesExpanded : 559884
  *  - aima.core.search.uninformed:
  *                                Greedy Best First:   //queueSize : 22
  *                                                     //maxQueueSize : 32
  *                                                     //pathCost : 24.0
  *                                                     //nodesExpanded : 2723
  *                                A Star:   //queueSize : 551
  *                                          //maxQueueSize : 13855
  *                                          //pathCost : 24.0
  *                                          //nodesExpanded : 103289
  *                                Simulated Annealing:   //temp : 0.23240639749261888
  *                                                       //nodeValue : -1.0    --> non arriva alla soluzione (numMax=23)
  *                                                       //nodesExpanded : 100
  *                                Hill Climbing:   --> non trova soluzione!
  *                                                 //nodeValue : -1.0
  *                                                 //nodesExpanded : 1
  **/

/** output a contronto: (Matrice 10x10:)
 *  - aima.core.search.uninformed:
 *                                Breadth First:   //queueSize : 2554
 *                                                 //maxQueueSize : 14008
 *                                                 //pathCost : 24.0
 *                                                 //nodesExpanded : 100736
 *                                Depth First:   //queueSize : 10
 *                                               //maxQueueSize : 18
 *                                               //pathCost : 24.0
 *                                               //nodesExpanded : 1425
 *                                Depth Limited:   //pathCost : 24.0
 *                                                 //nodesExpanded : 298
 *                                Uniform Cost:   //queueSize : 551
 *                                                //maxQueueSize : 13855
 *                                                //pathCost : 24.0
 *                                                //nodesExpanded : 103289
 *                                Iterative Deepening:   //pathCost : 24.0
 *                                                       //nodesExpanded : 559884
 *  - aima.core.search.uninformed:
 *                                Greedy Best First:   //queueSize : 22
 *                                                     //maxQueueSize : 32
 *                                                     //pathCost : 24.0
 *                                                     //nodesExpanded : 2723
 *                                A Star:   //queueSize : 551
 *                                          //maxQueueSize : 13855
 *                                          //pathCost : 24.0
 *                                          //nodesExpanded : 103289
 *                                Simulated Annealing:   //temp : 0.23240639749261888
 *                                                       //nodeValue : -1.0    --> non arriva alla soluzione (numMax=23)
 *                                                       //nodesExpanded : 100
 *                                Hill Climbing:   --> non trova soluzione!
 *                                                 //nodeValue : -1.0
 *                                                 //nodesExpanded : 1
 **/