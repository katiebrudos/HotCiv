package hotciv.visual;

import hotciv.factory.SemiFactory;
import hotciv.framework.Game;
import hotciv.standard.GameImpl;
import hotciv.tool.ChangePlayerInTurnTool;
import minidraw.framework.DrawingEditor;
import minidraw.standard.MiniDrawApplication;

public class ShowChangePlayerInTurnTool {
	public static void main(String[] args) {

		Game game = new GameImpl(new SemiFactory());

		DrawingEditor editor = 
				new MiniDrawApplication("HotCiv world map, show change player in turn tool...",  
						new HotCivFactory4(game) );
		editor.open();
		editor.setTool(new ChangePlayerInTurnTool(game, editor));
	}
}
