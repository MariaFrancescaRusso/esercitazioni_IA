reduce([], []).
reduce([_H1|[]], []).
reduce([H1,H2|Ti], [H1,Ho|To]) :-
    controllo(H1, H2, Ho),
    reduce([Ho|Ti], To).
controllo(_H1, [], []).
controllo(H1, [H2|T2], Ho) :-
    member(H2, H1),
    !,
    controllo(H1, T2, Ho).
controllo(H1, [H2|T2], [H2|To]) :-
    controllo(H1, T2, To).
member(H, [H|_T]).
member(H, [_H|T]) :-
    member(H, T).
