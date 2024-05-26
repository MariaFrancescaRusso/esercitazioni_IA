% -------------------------- Esercizio 3 Slide 3 --------------------------

%Si scriva un programma Prolog che,
%data in ingresso una lista di liste con 2 elementi ciascuna 
%ed una costante c1, 
%restituisca in uscita due liste DX ed SX, 
%la prima contenente gli elementi che nelle coppie compaiono a destra di c1,
%la seconda a sinistra.

%--------------------------------------------------------------------------

coppie([], _C1, [], []).

% caso N=C1 (sia a destra che a sinistra) : N viene inserito in DX e SX
coppie([[C1,C1]|TL], C1, [C1|TDX], [C1|TSX]) :-
    !,
    coppie(TL, C1, TDX, TSX).

% caso N a destra di C1 : N viene inserito in DX
coppie([[C1,N]|TL], C1, [N|TDX], SX) :-
    !,
    coppie(TL, C1, TDX, SX).

% caso N a sinistra di C1 : N viene inserito in SX
coppie([[N,C1]|TL], C1, DX, [N|TSX]) :-
    !,
    coppie(TL, C1, DX, TSX).

% caso non ci sia C1 (N nè a destra nè a sinistra)
coppie([_L|TL], C1, DX, SX) :-
    coppie(TL, C1, DX, SX).

%Test:
	%coppie([[1,3],[3,5],[3,6],[18,5],[8,3],[3,19],[3,3],[2,6]], 3, DX, SX).
