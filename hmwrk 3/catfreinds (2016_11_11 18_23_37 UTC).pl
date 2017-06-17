
catFriends(X, Y):- cat(X,[A|[W|[Z|J]]]), cat(Y,[B|[G|[C|K]]]), 
	(A- B) < 6, (W- G) < 3, (Z - C) < 4, (A- B) > -6, (W- G) > -3, (Z - C) > -4 .  
catFriends(X, Y):- cat(X,[A|[W|[Z|J]]]), cat(Y,[B|[G|[C|K]]]), 
	(A- B) < 6 , (W- G) < 3, (J - K) < 2, (A- B) > -6, (W- G) > -3, (J- K) > -2 . 	

cat(natasha, [3,7,14,2]).
cat(prowler, [6,6,15,2]).
cat(Lancer, [6,11,9,2]).
cat(giberator, [7,16,20,7]).
  