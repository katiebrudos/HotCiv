package hotciv.tool;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import hotciv.framework.Game;
import hotciv.framework.GameConstants;
import hotciv.view.GfxConstants;
import hotciv.view.UnitFigure;
import minidraw.framework.Drawing;
import minidraw.framework.DrawingEditor;
import minidraw.framework.Figure;
import minidraw.framework.RubberBandSelectionStrategy;
import minidraw.framework.Tool;
import minidraw.standard.AbstractTool;
import minidraw.standard.NullTool;
import minidraw.standard.handlers.StandardRubberBandSelectionStrategy;

public class IntegrationTool extends AbstractTool {
	private Game game;
	private Tool currentTool;

	public IntegrationTool(Game game, DrawingEditor editor) {
		super(editor);
		this.game = game;
		currentTool = new NullTool();
	}

	public void mouseDown(MouseEvent e, int x, int y) {
		if(e.isShiftDown()) {
			currentTool = new UnitActionTool(game, editor());
			currentTool.mouseDown(e, x, y);
		} else if(y >= GfxConstants.MAP_OFFSET_Y
				&& y <= GfxConstants.MAP_OFFSET_Y+GameConstants.WORLDSIZE*GfxConstants.TILESIZE
				&& x >= GfxConstants.MAP_OFFSET_X
				&& x <= GfxConstants.MAP_OFFSET_X+GameConstants.WORLDSIZE*GfxConstants.TILESIZE) {
			currentTool = new TileFocusTool(game, editor());
			currentTool.mouseDown(e, x, y);
			Figure figure = editor().drawing().findFigure(x, y);
			if(figure != null && figure.getClass().equals(UnitFigure.class)) {
				currentTool = new MoveUnitTool(game, editor(), new StandardRubberBandSelectionStrategy());
				currentTool.mouseDown(e, x, y);
			}
		} else {
			if(y <= GfxConstants.UNIT_SHIELD_Y - 20) {
				currentTool = new ChangePlayerInTurnTool(game, editor());
			} else {
				currentTool = new ChangeCityTool(game, editor());
			}
			currentTool.mouseDown(e, x, y);
		}
	}

	public void mouseDrag(MouseEvent e, int x, int y) {
		currentTool.mouseDrag(e, x, y);
	}

	public void mouseUp(MouseEvent e, int x, int y) { 
		currentTool.mouseUp(e, x, y);
	}

	public void mouseMove(MouseEvent evt, int x, int y) { 
		currentTool.mouseMove(evt, x, y);
	}

	public void keyDown(KeyEvent evt, int key) { 
		currentTool.keyDown(evt, key);
	}
}
