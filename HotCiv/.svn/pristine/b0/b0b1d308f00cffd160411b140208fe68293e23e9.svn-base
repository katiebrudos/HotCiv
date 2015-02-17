package hotciv.visual;

import hotciv.factory.GammaFactory;
import hotciv.factory.SemiFactory;
import hotciv.framework.Game;
import hotciv.standard.GameImpl;
import hotciv.tool.IntegrationTool;
import hotciv.tool.UnitActionTool;
import minidraw.framework.DrawingEditor;
import minidraw.standard.MiniDrawApplication;

public class ShowIntegrationTool {
	public static void main(String[] args) {

		Game game = new GameImpl(new SemiFactory());

		DrawingEditor editor = 
				new MiniDrawApplication( "HotCiv world map, show unit action tool?!?!",  
						new HotCivFactory4(game) );
		editor.open();

		editor.setTool( new IntegrationTool(game, editor));
	}
}
