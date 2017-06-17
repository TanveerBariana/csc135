listMins([], [], []).
listMins([X|Y],[E|D], [N|W]):- X < E, N is X, listMins(Y, D, W).
listMins([X|Y],[E|D], [N|W]):- X > E, N is E, listMins(Y, D, W).
