% -------------------------- Esercizio 3 Slide 3 --------------------------

%Si scriva un predicato Prolog list_to_set a due argomenti che, 
%data una lista di liste come primo argomento, 
%leghi il secondo argomento a una lista nella quale sono state eliminate 
%le liste ripetute o le loro permutazioni.
	%Per esempio dato il goal:
	%?-list_to_set([[1,2,3],[3,1,2],[1]], Y).
	%si vuole ottenere:
	%yes Y=[[3,1,2],[1]]
	%Per esempio dato il goal:
	%?-list_to_set([[1,2],[1,2],[1,2]], Y).
	%si vuole ottenere:
	%yes Y=[[1,2]]
%Si supponga dato il predicato permutation(X,Y) che verifica 
%se una lista X è una permutazione della lista Y.

%--------------------------------------------------------------------------

list_to_set([], []).

list_to_set([H|T], Res) :-
    controlloPerm(H, T),
    !,
    list_to_set(T, Res).

list_to_set([H|T], [H|TRes]) :-
    list_to_set(T, TRes).

controlloPerm(H1, [H2|_T]) :-
    permutation(H1, H2),
 	!.

controlloPerm(H1, [_H2|T]) :-
    controlloPerm(H1, T).
