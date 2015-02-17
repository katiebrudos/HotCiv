package hotciv.visual;

import minidraw.standard.*;
import minidraw.standard.handlers.StandardRubberBandSelectionStrategy;
import minidraw.framework.*;

import java.awt.*;

import javax.swing.*;

import hotciv.factory.AlphaFactory;
import hotciv.framework.*;
import hotciv.variant.DieRollStub;
import hotciv.view.*;
import hotciv.standard.GameImpl;
import hotciv.stub.*;
import hotciv.tool.MoveUnitTool;

/** Show a basic world.
 * 
   This source code is from the book 
     "Flexible, Reliable Software:
       Using Patterns and Agile Development"
     published 2010 by CRC Press.
   Author: 
     Henrik B Christensen 
     Computer Science Department
     Aarhus University
   
   This source code is provided WITHOUT ANY WARRANTY either 
   expressed or implied. You may study, use, modify, and 
   distribute it for non-commercial purposes. For any 
   commercial use, see http://www.baerbak.com/
 */
public class ShowMoveUnitTool {
  
  public static void main(String[] args) {

	  Game game = new GameImpl(new AlphaFactory());
	  
    DrawingEditor editor = 
      new MiniDrawApplication( "HotCiv world map, show move unit tool...",  
                               new HotCivFactory4(game) );
    editor.open();
    editor.setTool( new MoveUnitTool(game, editor, new StandardRubberBandSelectionStrategy()));

  }
}


