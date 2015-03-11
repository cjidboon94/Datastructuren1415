/*
public class AStar {
	
	private String[] openList = new String[];
	private String[] closedList = new String[];

	class AStar() {
	

	public void calcHeuristic(CurrentNode, nextNode) {
	
	int heuristicValue;

		if currentNode = goalNode {
			heuristicValue = 0;
		} else {
			heuristicValue = 1 + amount of cars between player and goalnode)
		}

		return heuristicValue;
	}
 	
 	public void calcPathCost(currentNode, nextNode) {
		int pathCost = 1;
		return pathCost; //Every move has cost one 
 	}


	public void calcTotalCost(currentNode, nextNode) {
	
		int totalCost = calcPathCost(currentNode, nextNode) + calcHeuristic(currentNode, nextNode);

		return totalCost;
	}

	LOOP>>>>

	//node heeft een board en een total f cost

	openList.add(initialBoard);

	retrieve all next nodes (met board en f cost);
	
		for all nextNodes {
			calcTotalCost()
			openList.add(nextNodes)
		}

	currentNode = node in openlist with lowest f-cost.
	openList.remove(currentNode);
	closedList.add(currentNode);

	if currentNode = goalNode {
		return //breakloop
	}

	foreach nextNode from currentNode {
		if neighbour in closedList {
			skip to next neighbour
		}
	}

	if new path to neighbour is shorter or neighbour is not in open {
		set calcPathCost(neighbour)
		set parent of neighbour to current
		
		if neighbour is not in open {
			add neighbour to open;
		}
	}


	}
}









*/