package hotciv.tool;

import hotciv.framework.Game;
import hotciv.framework.GameConstants;
import hotciv.view.GfxConstants;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import minidraw.framework.Drawing;
import minidraw.framework.DrawingEditor;
import minidraw.standard.AbstractTool;
import minidraw.standard.NullTool;

public class TileFocusTool extends AbstractTool {
	private Game game;

	public TileFocusTool(Game game, DrawingEditor editor) {
		super(editor);
		this.game = game;
	}

	@Override
	public void mouseDown(MouseEvent e, int x, int y) {
		editor().drawing().lock();
		if(y >= GfxConstants.MAP_OFFSET_Y
				&& y <= GfxConstants.MAP_OFFSET_Y+GameConstants.WORLDSIZE*GfxConstants.TILESIZE
				&& x >= GfxConstants.MAP_OFFSET_X
				&& x <= GfxConstants.MAP_OFFSET_X+GameConstants.WORLDSIZE*GfxConstants.TILESIZE) {
			game.setTileFocus(GfxConstants.getPositionFromXY(x, y));
		}
	}
	
	@Override
	public void mouseUp(MouseEvent arg0, int arg1, int arg2) {
		editor().drawing().unlock();
	}
}
