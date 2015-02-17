package hotciv.visual;

import java.awt.Point;
import java.awt.event.MouseEvent;

import hotciv.factory.DeltaFactory;
import hotciv.factory.GammaFactory;
import hotciv.factory.SemiFactory;
import hotciv.framework.Game;
import hotciv.framework.Position;
import hotciv.standard.GameImpl;
import hotciv.tool.TileFocusTool;
import hotciv.tool.UnitActionTool;
import hotciv.view.CityFigure;
import hotciv.view.GfxConstants;
import minidraw.framework.DrawingEditor;
import minidraw.standard.MiniDrawApplication;

public class ShowUnitActionTool {
	public static void main(String[] args) {

		Game game = new GameImpl(new GammaFactory());

		DrawingEditor editor = 
				new MiniDrawApplication( "HotCiv world map, show unit action tool?!?!",  
						new HotCivFactory4(game) );
		editor.open();

		editor.setTool( new UnitActionTool(game, editor));
	}
}
