package hotciv.visual;

import minidraw.framework.*;

import javax.swing.*;

import hotciv.framework.*;
import hotciv.framework.HotCivFactory;
import hotciv.view.*;

/** Factory for visual testing of various dSoftArk template code */
class HotCivFactory4 implements HotCivFactory, Factory {
  private Game game;
  public HotCivFactory4(Game g) { game = g; }

  public DrawingView createDrawingView( DrawingEditor editor ) {
    DrawingView view = 
      new MapView(editor, game);
    return view;
  }

  public Drawing createDrawing( DrawingEditor editor ) {
    return new CivDrawing( editor, game );
  }

  public JTextField createStatusField( DrawingEditor editor ) {
    JTextField f = new JTextField("dSoftArk template code");
    f.setEditable(false);
    return f;
  }

@Override
public ActionStrategy getActionStrategy() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public AgeStrategy getAgeStrategy() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public SetupStrategy getSetupStrategy() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public WinnerStrategy getWinnerStrategy() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public AttackStrategy getAttackStrategy() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public GrowthStrategy getGrowthStrategy() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public ProductionStrategy getProductionStrategy() {
	// TODO Auto-generated method stub
	return null;
}
}
