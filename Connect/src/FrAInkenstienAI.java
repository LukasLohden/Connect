import connectK.CKPlayer;
import connectK.BoardModel;

import java.awt.Point;


public class FrAInkenstienAI extends CKPlayer {

	public FrAInkenstienAI(byte player, BoardModel state) 
	{
		super(player, state);
		teamName = "FrAInkenstein";
	}

	@Override
	public Point getMove(BoardModel state) 
	{
		return getMove(state, 5000);	
	}

	@Override
	public Point getMove(BoardModel state, int deadline) 
	{
		long stopTime = System.currentTimeMillis() + deadline;
		int depthLimit = 1;
		
		FrAInkensteinNode currentNode = new FrAInkensteinNode(state);
		FrAInkensteinNode nextNode = currentNode;
		
		while (System.currentTimeMillis() < stopTime)
		{
			expandNode(currentNode, true, depthLimit, stopTime);
			if (System.currentTimeMillis() < stopTime)
			{
				minmaxSearch(currentNode, depthLimit, stopTime);
			}
			else
			{
				break;
			}
			
			if (System.currentTimeMillis() < stopTime && depthLimit < state.spacesLeft)
			{
				nextNode = currentNode.getChildren()[currentNode.getBest()];
			}
			else
			{
				break;
			}
			depthLimit++;
		}
		return findMove(state, nextNode.getState());
	}
	public void minmaxSearch(FrAInkensteinNode node, int depth, long stopTime)
	{
		 // Assign heuristic values to children of node recursively
	}
	
	public int max(BoardModel state)
	{
		return 0;
	}
	
	public int min(BoardModel state)
	{
		return 0;
	}
	
	
	public Point findMove(BoardModel state1, BoardModel state2)
	{
		Point move = null;
		return move;
	}
	
	public void expandNode(FrAInkensteinNode node, boolean maximize, int depthLimit, long stopTime)
	{
		if (depthLimit == 0)
		{
			if (maximize)
			{
				// Add children to the node left to right.
				// Set next state to opponent's turn and recur to calculate deeper
			}
		}
	}
}