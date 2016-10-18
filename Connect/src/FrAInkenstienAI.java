import connectK.CKPlayer;
import connectK.BoardModel;

import java.awt.Point;
import java.lang.Math;


public class FrAInkenstienAI extends CKPlayer {

	public FrAInkenstienAI(byte player, BoardModel state) {
		super(player, state);
		teamName = "FrAInkenstein";
	}

	@Override
	public Point getMove(BoardModel state) {
		while (state.hasMovesLeft())
		{
			int i = (int)(Math.random() * state.getWidth() );
			int j = (int)(Math.random() * state.getHeight() );
			while (state.getSpace(i,j) != 0)
			{
				i = (int)(Math.random() * state.getWidth() );
				j = (int)(Math.random() * state.getHeight() );
			}
			return new Point(i,j);
		}
		return null;

		
//		for(int i=0; i<state.getWidth(); ++i)
//			for(int j=0; j<state.getHeight(); ++j)
//				if(state.getSpace(i, j) == 0)
//					return new Point(i,j);
		
	}

	@Override
	public Point getMove(BoardModel state, int deadline) {
		return getMove(state);
	}
}