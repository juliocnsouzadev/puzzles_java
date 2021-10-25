def tournament_winner (competitions, results):
    points = {}
    leader = None
    higher_score = 0
    i = 0
    while i < len(competitions):
		# get actual winner
        winner = None
        if results[i] == 1:
            winner = competitions[i][0]
        else:
            winner = competitions[i][1]   
        # init or update
	    actual_points = 3        
        if winner in points:
            actual_points = points[winner] + 3        
        #update mapped values
	    points[winner] = actual_points
        # check who is the leader 
	    if actual_points > higher_score:
            higher_score = actual_points
            leader = winner
            i = i + 1
    return leader
