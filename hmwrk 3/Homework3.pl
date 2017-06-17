/** problem 1  -----------------------------  */
catsiblings(S, G):- catowner(C,S), catowner(K,G), catparent(P,C), catparent(P,K).
catparent(parent, kitten).
catparent(lady, girl).
catparent(lady, child).
catparent(guy, boy).
catowner(cat, owner).
catowner(child, stacy).
catowner(girl, lacy).

/** problem 2 ----------------------------- */
listMins([], [], []).
listMins([X|Y],[E|D], [N|W]):- X < E, N is X, listMins(Y, D, W).
listMins([X|Y],[E|D], [N|W]):- X > E, N is E, listMins(Y, D, W).

/** problem 3  -----------------------------  */
testNum(9).
testNum(8).
testNum(7).
testNum(6).
testNum(5).
testNum(4).
testNum(3).
testNum(2).
testNum(1).
crypto(P,H,A,R,E,D,L,I,O,S):-  
	testNum(S),
	testNum(O), O=\=S, 
	testNum(I), I=\=O, I=\=S,
	testNum(D), D=\=I, D=\=O, D=\=S, 
	testNum(E), E=\=D, E=\=I, E=\=O, E=\=S,
	testNum(R), R=\=E, R=\=D, R=\=I, R=\=O, R=\=S,
	testNum(A), A=\=R, A=\=E, A=\=D, A=\=I, A=\=O, A=\=S,
	testNum(H), H=\=A, H=\=R, H=\=E, H=\=D, H=\=I, H=\=O, H=\=S,
	testNum(P), P=\= H, P=\= A, P=\=R, P=\=E, P=\=D, P=\= I, P=\= O, P=\=S,
	L is 0,
	Y is(P* 10000 + H* 1000+ A* 100+ R* 10 + E), 
	B is (P * I * ( P* 10 + A) * (R * 10 + A)), B =:= Y, 
	X is (D* 10000 + E* 1000+ L*100 + A *10 +I),
	C is ((S* 10 + H) * (O* 1000+ E* 100+ O* 10+ A)), X =:= C, 
	Z is (A *10000 + L* 1000+ O* 100+ R* 10+ S), 
	F is ( H* (S* 10 + S)* (E* 10 + S)* (O* 10+ I)), Z=:= F . 
/** problem 4   -----------------------------  */
catFriends(X, Y):- cat(X,[A|[W|[Z|J]]]), cat(Y,[B|[G|[C|K]]]), 
	(A- B) < 6, (W- G) < 3, (Z - C) < 4, (A- B) > -6, (W- G) > -3, (Z - C) > -4 .  
catFriends(X, Y):- cat(X,[A|[W|[Z|J]]]), cat(Y,[B|[G|[C|K]]]), 
	(A- B) < 6 , (W- G) < 3, (J - K) < 2, (A- B) > -6, (W- G) > -3, (J- K) > -2 . 	

cat(natasha, [3,7,14,2]).
cat(prowler, [6,6,15,2]).
cat(Lancer, [6,11,9,2]).
cat(giberator, [7,16,20,7]).

/** problem 5   -----------------------------  */

overlap2(A, B):- overlap2([G|I], [H|J]), G =:= H, !, overlapHelp2(I, B).
overlap2([G|I], [H|J]):- overlap2(G, J).
overlapHelp2([G|I], [H|J]):- G =:= H.
overlapHelp2([G|I], [H|J]):- overlaphelp2(G, J).
 

     