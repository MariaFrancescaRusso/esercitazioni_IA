sum([], 0).

sum(L, V) :-
    maggiore(L, Vt),
    controllo(V, Vt).

maggiore([], 0).

maggiore([HL|TL], Vt) :-
    HL>=0,
    !,
    maggiore(TL, Vtmp),
    Vt is Vtmp+HL.

maggiore([_HL|TL], Vt) :-
    maggiore(TL, Vt).

controllo(V, V) :- 
    !.

controllo(V, Vt) :-
    V is Vt.
