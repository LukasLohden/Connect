/* FrAInkenstein AI - CS 171 Prject Fall 2016
 * FrAInkensteinNode defines nodes for representing
 * game states in a tree.
 */

import connectK.BoardModel;

public class FrAInkensteinNode
{
	private FrAInkensteinNode[] children; // All of this node's children
	private int best; // Index of best child (so far)
	private boolean gravity; // True if playing with gravity ON
	/*private*/ BoardModel state;
	
	public FrAInkensteinNode(BoardModel gameState)
	{
		state = gameState;
		gravity = state.gravity;
		best = 0;
		
		if (!gravity)
		{
			children = new FrAInkensteinNode[state.spacesLeft];
		}
		else
		{
			children = new FrAInkensteinNode[state.width];
		}
	}
	
	public int getBest()
	{
		return best;
	}
	
	public FrAInkensteinNode[] getChildren()
	{
		return children;
	}
	
	public BoardModel getState()
	{
		return state;
	}
	
	public void addChild (FrAInkensteinNode child)
	{
		for (int i = 0; i < children.length; i++)
		{
			if (children[i] == null)
			{
				children[i] = child;
			}
		}
	}
}