package hotciv.tool;

import hotciv.framework.Game;
import hotciv.framework.Position;
import hotciv.view.GfxConstants;
import hotciv.view.UnitFigure;

import java.awt.event.MouseEvent;

import minidraw.framework.Drawing;
import minidraw.framework.DrawingEditor;
import minidraw.framework.Figure;
import minidraw.framework.RubberBandSelectionStrategy;
import minidraw.framework.Tool;
import minidraw.standard.AbstractTool;
import minidraw.standard.NullTool;
import minidraw.standard.handlers.DragTracker;

public class MoveUnitTool extends AbstractTool {
	private Game game;
	protected Tool fChild;
	protected Tool cachedNullTool;
	protected Figure draggedFigure;
	RubberBandSelectionStrategy selectionStrategy;

	public MoveUnitTool(Game game, DrawingEditor editor, 
			RubberBandSelectionStrategy selectionStrategy ) {
		super(editor);
		this.game = game;
		fChild = cachedNullTool = new NullTool();
		draggedFigure = null;
		this.selectionStrategy = selectionStrategy; 
	}

	@Override
	public void mouseDown(MouseEvent e, int x, int y)
	{
		super.mouseDown(e, x, y);

		Drawing model = editor().drawing();

		model.lock();

		draggedFigure = model.findFigure(x, y);

		if ( draggedFigure != null && draggedFigure.getClass() == UnitFigure.class
				&& game.getUnitAt(new Position((super.fAnchorY-18)/30, (super.fAnchorX-13)/30)) != null
				&& game.getUnitAt(new Position((super.fAnchorY-18)/30, (super.fAnchorX-13)/30)).getOwner().equals(game.getPlayerInTurn())) {
			fChild = createDragTracker( draggedFigure ); 
			fChild.mouseDown(e, x, y);
		} else if(e.isShiftDown() ) {
			model.clearSelection();
		} else { 
			draggedFigure = null; 
		}
	}

	@Override
	public void mouseDrag(MouseEvent e, int x, int y) {
		fChild.mouseDrag(e, x, y);
	}

	@Override
	public void mouseUp(MouseEvent arg0, int arg1, int arg2) {

		if(draggedFigure != null) {
			Position p1 = GfxConstants.getPositionFromXY(super.fAnchorX, super.fAnchorY);
			Position p2 = GfxConstants.getPositionFromXY(arg1, arg2);

			System.out.println( "-- Game / moveUnit called: ("+ p1.getRow() + "," + p1.getColumn() + ") ->"+ "("+ p2.getRow() + "," + p2.getColumn() + ")" );		

			if(!game.moveUnit(new Position(p1.getRow(), p1.getColumn()), new Position(p2.getRow(), p2.getColumn()))) {
				// if invalid move, return to original position, otherwise leave in place
				draggedFigure.moveBy(super.fAnchorX - arg1, super.fAnchorY - arg2);
			}

		}
		editor().drawing().unlock();


		fChild = cachedNullTool;
		draggedFigure = null;

	}

	/**
	 * Factory method to create a Drag tracker. It is used to drag a figure.
	 */
	protected Tool createDragTracker(Figure f) {
		return new DragTracker(editor(), f);
	}
}
