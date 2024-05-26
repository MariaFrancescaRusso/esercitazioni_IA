% se liste vuote
no_ripetuti([], [], 0).
% se el ripetuto, vado avanti e incremento N
no_ripetuti([HXs|TXs], Ys, N):-
    member(HXs, TXs),
    no_ripetuti(TXs, Ys, N1), 
    N is N1 + 1.
% altrimenti inserisco el nella lista Ys
no_ripetuti([HXs|TXs], [HYs|TYs], N):-
    \+ member(HXs, TXs),
    HYs is HXs,
    no_ripetuti(TXs, TYs, N).

% funzione per vedere se el appartiene alla lista
member(H,[H|_]).
member(H,[_|T]):- 
    member(H,T).
    
%TEST:
no_ripetuti([3,5,3,9,9,8,9], Ys, N).

%ESERCIZIO OK:

no_ripetuti([], [], 0).
no_ripetuti([HXs|TXs], Ys, N):-
    member(HXs, TXs), !,
    no_ripetuti(TXs, Ys, N1), 
    N is N1 + 1.
no_ripetuti([HXs|TXs], [HXs|TYs], N):-
    no_ripetuti(TXs, TYs, N).
% funzione per vedere se el appartiene alla lista
member(H,[H|_T]).
member(H,[_H|T]):- 
    member(H,T).
