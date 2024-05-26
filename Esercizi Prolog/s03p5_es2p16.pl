% -------------------------- Esercizio 2 Slide 3 --------------------------

%Un associazione di volontariato tiene traccia delle spese di cancelleria tramite un insieme di fatti Prolog del tipo:
	%spesa(carta, 13).
	%spesa(matite, 12).
	%spesa(graffette, 5.99).
	%spesa(carta, 12).
%Dove il primo parametro rappresenta l’oggetto acquistato, ed il secondo l’importo.
%Definire i seguenti predicati Prolog:
	%- elenca(L), che deve restituire la lista degli item acquistati, senza 			ripetizione. Si usi a tal scopo il predicato setof;
	%- subTotale(X, S), che ricevuto in ingresso un oggetto X, restituisce l’ammontare della spesa per tale oggetto;
	%- totale(S), che restituisce quanto è stato speso in cancelleria.
%Ad esempio, i predicati (invocati sulla base di conoscenza presentata all’inizio di questo esercizio) devono restituire: 
	%| ?- elenca(L).
	%L = [carta,graffette,matite] ?
	%| ?- subtotale(carta, S).
	%S = 25 ?
	%| ?- totale(S).
	%S = 42.99 ?

%--------------------------------------------------------------------------

spesa(carta, 13).
spesa(matite, 12).
spesa(graffette, 5.99).
spesa(carta, 12).

elenca(L) :-
    setof(X, Y^spesa(X, Y), L).	% per ottendere una lista senza ripetizioni in base a X
    %setof(X, spesa(X, _Y), L).	% in questo modo il setof ordina in base a Y; allora avrò 3 liste diverse

subTotale(X, S) :-
    bagof(Y, spesa(X, Y), L),	% utilizzando bagof mantengo le ripetizioni; Y per avere lista importi
    conto(L, S).

conto([], 0).
conto([HL|TL], S) :-
    conto(TL, St),
    S is St + HL.

totale(S) :-
    bagof(Y, X^spesa(X,Y), L),
    %findall(Y, spesa(_X, Y), L),	%invece di bagof per ottenere una lista di el si può usare findall
    conto(L, S).
