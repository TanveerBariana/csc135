catsiblings(S, G):- catowner(C,S), catowner(K,G), catparent(P,C), catparent(P,K).
catparent(parent, kitten).
catparent(lady, girl).
catparent(lady, child).
catparent(guy, boy).
catowner(cat, owner).
catowner(child, stacy).
catowner(girl, lacy).

