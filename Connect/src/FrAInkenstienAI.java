import connectK.CKPlayer;
import connectK.BoardModel;

import java.awt.Point;


public class FrAInkenstienAI extends CKPlayer {

	int ai_player;
	int opponent;
	
	public FrAInkenstienAI(byte player, BoardModel state) 
	{
		super(player, state);
		teamName = "FrAInkenstein";
		ai_player = player;
		
		if (ai_player == 1)
		{
			opponent = 2;
		}
		else
		{
			opponent = 1;
		}
	}

	@Override
	public Point getMove(BoardModel state) 
	{
		return getMove(state, 5000);	
	}

	@Override
	public Point getMove(BoardModel state, int deadline) 
	{
		long stop_time = System.currentTimeMillis() + deadline;
		int depth_limit = 1;
		
		FrAInkensteinNode tree = new FrAInkensteinNode(state);
		FrAInkensteinNode best_node = tree;
		
		while (System.currentTimeMillis() < stop_time)
		{
			expandTree(tree, depth_limit, stop_time);
			if (System.currentTimeMillis() < stop_time)
			{
				minmaxSearch(tree, depth_limit, stop_time);
			}
			else
			{
				break;
			}
			
			if (System.currentTimeMillis() < stop_time && depth_limit < state.spacesLeft)
			{
				best_node = tree.getChildren()[tree.getBest()];
			}
			else
			{
				break;
			}
			depth_limit++;
		}
		return findMove(state, best_node.getState());
	}
	private void minmaxSearch(FrAInkensteinNode node, int depth, long stop_time)
	{
		 if (System.currentTimeMillis() > stop_time)
		 {
			 return;
		 }
		 
		 
	}
	
	private int max(BoardModel state)
	{
		return 0;
	}
	
	private int min(BoardModel state)
	{
		return 0;
	}
	
	private int heuristic(BoardModel state, long stop_time)
	{
		int ai_score = 0; // The AI's score
		int op_score = 0; // The opponent's score
		
		int columns = state.getWidth();
		int rows =  state.getHeight();
		
		for (int row = 0; row < rows; row++)
		{
			for (int col = 0; col < columns; col++)
			{
				if (state.getSpace(row, col) == ai_player)
				{
					ai_score += score(state, row, col);
				}
				if (state.getSpace(row, col) == opponent)
				{
					op_score += score(state, row, col);
				}
			}
		}
		
		return ai_score - op_score;
	}
	
	// Currently only counts how many k-length strings that start from given position.
	private int score(BoardModel state, int row, int col)
	{
		int tally = 0;
		
		tally += search(state, row, col, 1, 0);
		tally += search(state, row, col, 1, 1);
		tally += search(state, row, col, 0, 1);
		tally += search(state, row, col, -1, 1);
		tally += search(state, row, col, -1, 0);
		tally += search(state, row, col, -1, -1);
		tally += search(state, row, col, 0, -1);
		tally += search(state, row, col, 1, -1);
		
		return tally;
	}
	
	// Currently only determines if a winning k-string could be started from this position.
	private int search(BoardModel state, int row, int col, int row_change, int col_change)
	{
		int distance = 0;
		
		row = row + row_change;
		col = col + col_change;
		
		while ( (0<=row) && (row <= state.getHeight()) && (0<=col) && (col <= state.getWidth()) )
		{
			if (state.getSpace(row, col) == opponent)
			{
				return 0;
			}
			if (state.getSpace(row, col) == ai_player)
			{
				distance += 1;
			}
			
			if (distance == state.getkLength())
			{
				return 1;
			}
		}
		
		return 0;
	}
	
	
	private Point findMove(BoardModel state1, BoardModel state2)
	{
		for (int col = 0; col < state1.getWidth(); col++)
		{
			for (int row = 0; row < state1.getHeight(); row++)
			{
				if (state1.getSpace(row, col) != state2.getSpace(row, col))
				{
					return new Point(row, col);
				}
			}
		}
		return null;
	}
	
	private void expandTree(FrAInkensteinNode node, int depth_limit, long stop_time)
	{
		if (System.currentTimeMillis() > stop_time)
		 {
			 return;
		 }
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	