/* FrAInkenstein AI - CS 171 Project Fall 2016
 * FrAInkensteinNode defines nodes for representing
 * game states in a tree.
 */

import connectK.BoardModel;

public class FrAInkensteinNode
{
	private FrAInkensteinNode[] children; // All of this node's children
	private int value; // The heuristic value of this state's board
	/*private*/ BoardModel state;
	
	private boolean maximize;
	private int current_player;
	
	public FrAInkensteinNode(BoardModel state)
	{
		value = 0;
		this.state = state;
		
		if (!state.gravityEnabled())
		{
			children = new FrAInkensteinNode[state.spacesLeft];
		}
		else
		{
			children = new FrAInkensteinNode[state.width];
		}
	}
	
	// GET METHODS:
	
	public int getPlayer()
	{
		return current_player;
	}
	
	public boolean maxEnabled()
	{
		return maximize;
	}
	
	public int getValue()
	{
		return value;
	}
	
	public FrAInkensteinNode[] getChildren()
	{
		return children;
	}
	
	public BoardModel getState()
	{
		return state;
	}
	
	// ACTION METHODS:
	
	public void setValue(int new_value)
	{
		value = new_value;
	}
	
	public void addChild (FrAInkensteinNode new_child)
	{
		for (int i = 0; i < children.length; i++)
		{
			if (children[i] == null)
			{
				children[i] = new_child;
			}
		}
	}
	
	public void printTree(FrAInkensteinNode node, int depth, int depth_limit)
	{
		System.out.println("-----------------------");
		for (FrAInkensteinNode child: node.children)
		{
			if (node == null)
			{
				System.out.println("NULL NODE");
			}
			for (int col = node.state.getHeight()-1; col > -1; col--)
			{
				for (int row = node.state.getWidth()-1; row > -1; row--)
				{
					System.out.print(node.state.getSpace(row, col));
				}
				System.out.println();
			}
			System.out.println();
			if (depth < depth_limit)
			{
				printTree(node, depth+1, depth_limit);
			}
		}
	}
	
}
	
