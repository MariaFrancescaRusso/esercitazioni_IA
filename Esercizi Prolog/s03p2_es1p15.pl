% --- versione ricorsiva ---

averStud(Matr, LE, AV) :-
    conta(Matr, LE, N, AVt),
    N > 0,
    AV is AVt / N.

conta(_Matr, [], 0, 0) :- !.
% si mette ! per stampare il risultato senza continuare

conta(Matr,[esame(Matr, _Esame, Voto)|TLE], N, AV) :- 
    !,
    conta(Matr, TLE, Nt, AVt),
    N is Nt + 1,
    AV is Voto + AVt.

conta(Matr,[_HLE|TLE], N, AV) :- 
    conta(Matr, TLE, N, AV).
    

% --- versione ricorsiva con uguaglianza matricola esplicita ---
%averStud(Matr, LE, AV) :-
    %conta(Matr, LE, N, AVt),
    %N > 0,
    %AV is AVt / N.

%conta(_Matr, [], 0, 0).

%conta(Matr,[esame(MatrCorr, _Esame, Voto)|TLE], N, AV) :- 
    %Matr == MatrCorr, 
    %!,
    %conta(Matr, TLE, Nt, AVt),
    %N is Nt + 1,
    %AV is Voto + AVt.

%conta(Matr,[_HLE|TLE], N, AV) :- 
    %conta(Matr, TLE, N, AV).

