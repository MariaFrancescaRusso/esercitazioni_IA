%stessaSomma([HL|[]], V) :-	%posso scrivere solo [el] se è l'ultimo el.
stessaSomma([HL], V) :-
    !,
    conta(HL, V).	%funzione controllo non nec. se metto stessa var. V
    %conta(HL, Vtmp),
    %controllo(V, Vtmp).

stessaSomma([HL|TL], V) :-
    conta(HL, V),	%funzione controllo non nec. se metto stessa var. V
    %conta(HL, Vtmp),
    %controllo(V, Vtmp),
    stessaSomma(TL, V).

conta([], 0).

%conta([H|T], Vtmp) :-
conta([H|T], V) :-
    conta(T, Vt),
    V is Vt+H.
	%Vtmp is Vt+H.

%controllo(V, V) :- 
    %!.

%controllo(V, Vtmp) :-
    %V is Vtmp.

%per testare:
  %stessaSomma([],V).
  %stessaSomma([[6,7], [1,12], [8,5]], 13).
  %stessaSomma([[6,4,1,2], [1,12], [8,5]], V).
  %stessaSomma([[6,7,2], [1,5,9], [8,3,4]], V). 
