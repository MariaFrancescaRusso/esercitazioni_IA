% è sufficiente che Lin1 sia vuota
% affinché anche Lout lo sia
listindex([],_,[]).

listindex([HLin1|TLin1], Lin2, [HLout|TLout]) :-
    estrai(HLin1, Lin2, HLout),
    listindex(TLin1,Lin2, TLout).

% se l'indice in Lin1 è 1 
% allora prendo il primo elemento della lista Lin2
estrai(1, [HLin2|_], HLin2).

estrai(HLin1, [_|TLin2], HLout) :-
    Nin1 is HLin1-1,
    estrai(Nin1, TLin2, HLout).