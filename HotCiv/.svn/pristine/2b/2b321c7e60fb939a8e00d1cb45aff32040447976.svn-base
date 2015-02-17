package hotciv.tool;

import java.awt.event.MouseEvent;

import hotciv.framework.Game;
import hotciv.framework.Position;
import hotciv.view.GfxConstants;
import hotciv.view.UnitFigure;
import minidraw.framework.Drawing;
import minidraw.framework.DrawingEditor;
import minidraw.framework.Figure;
import minidraw.standard.AbstractTool;

public class UnitActionTool extends AbstractTool {
	private Game game;
	
	public UnitActionTool(Game game, DrawingEditor editor) {
		super(editor);
		this.game = game;
	}
	
	@Override
	public void mouseDown(MouseEvent e, int x, int y)
	{
		super.mouseDown(e, x, y);

		Drawing model = editor().drawing();

		model.lock();

		Figure figure = model.findFigure(x, y);
		if ( figure != null && figure.getClass() == UnitFigure.class
				&& game.getUnitAt(new Position((super.fAnchorY-18)/30, (super.fAnchorX-13)/30)) != null
				&& game.getUnitAt(new Position((super.fAnchorY-18)/30, (super.fAnchorX-13)/30)).getOwner().equals(game.getPlayerInTurn())
				&& e.isShiftDown() ) {
			Position p = GfxConstants.getPositionFromXY(x, y);
			game.performUnitActionAt(p);
		}
	}
	
	@Override
	public void mouseUp(MouseEvent arg0, int arg1, int arg2) {
		editor().drawing().unlock();
	}
}
