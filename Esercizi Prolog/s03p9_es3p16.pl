% -------------------------- Esercizio 3 Slide 3 --------------------------

%Si scriva un programma Prolog che, prendendo in ingresso due liste L1 e L2,
%restituisca in uscita due liste L3 e L4 tali che L3 contenga gli elementi 
%di L1 che appartengono anche a L2, mentre L4 contenga gli elementi di L1 che
%non appartengono a L2. 
%Si supponga disponibile il predicato member. 
%Si dica inoltre se il predicato così definito è ricorsivo tail.

%Esempio:
%?- list_mem([a,r,t],[t,s,m,n,a],L3,L4).
%restituirà L3=[a,t] e L4=[r].

%--------------------------------------------------------------------------

list_mem([], _L2, [], []).

%list_mem([EL1|TL1], L2, [HL3|TL3], L4) :-
list_mem([EL1|TL1], L2, [EL1|TL3], L4) :-
    member(EL1, L2), 
    !,
    %HL3 = EL1,
    list_mem(TL1, L2, TL3, L4).

%list_mem([EL1|TL1], L2, L3, [HL4|TL4]) :-
list_mem([EL1|TL1], L2, L3, [EL1|TL4]) :-
    %HL4 = EL1,
    list_mem(TL1, L2, L3, TL4).

% funzione per vedere se el appartiene alla lista
member(El,[El|_]).
member(El,[_|T]):- 
    member(El,T).
    
%Si dica inoltre se il predicato così definito è ricorsivo tail.
	
	%Sì, il predicato è ricorsivo tail.
