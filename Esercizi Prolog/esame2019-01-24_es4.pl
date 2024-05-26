quadrati([], []).

quadrati([H1|T1], [H2|T2]) :-
    H2 is H1*H1,
    quadrati(T1, T2).

%quadrati([1,2,4],[1,4,16]). 
%quadrati([1,2,4],[1,4,15]).
%quadrati([1],[1,4]). 
