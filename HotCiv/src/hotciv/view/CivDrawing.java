package hotciv.view;

import hotciv.framework.*;
import hotciv.standard.CityImpl;

import java.awt.*;
import java.util.*;

import minidraw.framework.*;
import minidraw.standard.*;
import minidraw.standard.handlers.*;

/** CivDrawing is a specialized Drawing (model component) from
 * MiniDraw that dynamically builds the list of Figures for MiniDraw
 * to render the Unit and other information objects that are visible
 * in the Game instance.
 *
 * This is a TEMPLATE for the dSoftArk Exercise! This means
 * that it is INCOMPLETE and that there are several options
 * for CLEANING UP THE CODE when you add features to it!

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

public class CivDrawing extends StandardDrawing
implements Drawing, GameObserver {

	/** the Game instance that this UnitDrawing is going to render units
	 * from */
	protected Game game;

	public CivDrawing( DrawingEditor editor, Game game ) {
		super();
		this.game = game;

		// register this unit drawing as listener to any game state
		// changes...
		game.addObserver(this);
		// ... and build up the set of figures associated with
		// units in the game.
		defineUnitMap();
		// and the set of 'icons' in the status panel
		defineIcons();
	}

	/** The UnitDrawing should not allow client side
	 * units to add and manipulate figures; only figures
	 * that renders game objects are relevant, and these
	 * should be handled by observer events from the game
	 * instance. Thus this method is 'killed'.
	 */
	public Figure add(Figure arg0) {
		throw new RuntimeException("Should not be used...");
	}

	/** store all moveable figures visible in this drawing = units */
	protected Map<Unit,UnitFigure> figureMap = null;

	/** erase the old list of units, and build a completely new
	 * one from scratch by iterating over the game world and add
	 * Figure instances for each unit in the world.
	 */
	private void defineUnitMap() {
		// ensure no units of the old list are accidental in
		// the selection!
		clearSelection();

		figureMap = new HashMap<Unit,UnitFigure>();
		Position p;
		for ( int r = 0; r < GameConstants.WORLDSIZE; r++ ) {
			for ( int c = 0; c < GameConstants.WORLDSIZE; c++ ) {
				p = new Position(r,c);
				Point point = new Point( GfxConstants.getXFromColumn(p.getColumn()),
						GfxConstants.getYFromRow(p.getRow()) );
				Unit unit = game.getUnitAt(p);
				City city = game.getCityAt(p);
				if ( city != null ) {
					// convert the unit's Position to (x,y) coordinates
					CityFigure cityFigure =
							new CityFigure( city, point);
					cityFigure.addFigureChangeListener(this);
					//figureMap.put(unit, unitFigure);

					// also insert in superclass list as it is
					// this list that is iterated by the
					// graphics rendering algorithms
					super.add(cityFigure);
				}
				if ( unit != null ) {
					String type = unit.getTypeString();
					// convert the unit's Position to (x,y) coordinates
					UnitFigure unitFigure =
							new UnitFigure( type, point, unit );
					unitFigure.addFigureChangeListener(this);
					figureMap.put(unit, unitFigure);

					// also insert in superclass list as it is
					// this list that is iterated by the
					// graphics rendering algorithms
					super.add(unitFigure);
				}
			}
		}
	}

	private ImageFigure turnShieldIcon;
	private ImageFigure unitShieldIcon;
	private ImageFigure cityShieldIcon;
	private TextFigure unitMoveCount;
	private ImageFigure cityProductionFocus;
	private ImageFigure cityWorkforceFocus;
	private TextFigure worldAge;
	private void defineIcons() {
		// very much a template implementation :)
		turnShieldIcon = 
				new ImageFigure( "redshield",
						new Point( GfxConstants.TURN_SHIELD_X,
								GfxConstants.TURN_SHIELD_Y ) );
		unitShieldIcon = 
				new ImageFigure( "black",
						new Point( GfxConstants.UNIT_SHIELD_X,
								GfxConstants.UNIT_SHIELD_Y ) );
		cityShieldIcon = 
				new ImageFigure( "black",
						new Point( GfxConstants.CITY_SHIELD_X,
								GfxConstants.CITY_SHIELD_Y ) );
		unitMoveCount = new TextFigure("", 
				new Point(GfxConstants.UNIT_COUNT_X,
						GfxConstants.UNIT_COUNT_Y) );
		cityProductionFocus = new ImageFigure("black", 
				new Point(GfxConstants.CITY_PRODUCTION_X,
						GfxConstants.CITY_PRODUCTION_Y) );
		cityWorkforceFocus = new ImageFigure("black", 
				new Point(GfxConstants.WORKFORCEFOCUS_X,
						GfxConstants.WORKFORCEFOCUS_Y) );
		worldAge = new TextFigure("" + game.getAge(), 
				new Point(GfxConstants.AGE_TEXT_X,
						GfxConstants.AGE_TEXT_Y) );
		// insert in superclass figure list to ensure graphical
		// rendering.
		super.add(turnShieldIcon);
		super.add(unitShieldIcon);
		super.add(cityShieldIcon);
		super.add(unitMoveCount);
		super.add(cityProductionFocus);
		super.add(cityWorkforceFocus);
		super.add(worldAge);
	}

	// === Observer Methods ===

	public void worldChangedAt(Position pos) {
		System.out.println( "UnitDrawing: world changes at "+pos);
		clearSelection();
		// this is a really brute-force algorithm: destroy
		// all known units and build up the entire set again
		for ( Figure f : figureMap.values() ) {
			super.remove(f);
		}
		defineUnitMap();
		tileFocusChangedAt(pos);
	}

	public void turnEnds(Player nextPlayer, int age) {
		System.out.println( "UnitDrawing: turnEnds for "+
				nextPlayer+" at "+age );
		String playername = "red";
		if ( nextPlayer == Player.BLUE ) { playername = "blue"; }
		turnShieldIcon.set( playername+"shield",
				new Point( GfxConstants.TURN_SHIELD_X,
						GfxConstants.TURN_SHIELD_Y ) );
		worldAge.setText("" + age);
	}

	public void tileFocusChangedAt(Position position) {
		System.out.println( "tileFocusChangedAt " + position );
		Unit unit = game.getUnitAt(position);
		if(unit == null) {
			unitShieldIcon.set("black",
					new Point( GfxConstants.UNIT_SHIELD_X,
							GfxConstants.UNIT_SHIELD_Y ) );
			unitMoveCount.setText("");
		} else {
			unitShieldIcon.set(unit.getOwner().toString().toLowerCase()+"shield",
					new Point( GfxConstants.UNIT_SHIELD_X,
							GfxConstants.UNIT_SHIELD_Y ) );
			unitMoveCount.setText(""+unit.getMoveCount());
		}

		City city = game.getCityAt(position);
		if(city == null) {
			cityShieldIcon.set("black",
					new Point( GfxConstants.CITY_SHIELD_X,
							GfxConstants.CITY_SHIELD_Y ) );
			cityProductionFocus.set("black",
					new Point( GfxConstants.CITY_PRODUCTION_X,
							GfxConstants.CITY_PRODUCTION_Y));
			cityWorkforceFocus.set("black",
					new Point( GfxConstants.WORKFORCEFOCUS_X,
							GfxConstants.WORKFORCEFOCUS_Y));
		} else {
			cityShieldIcon.set(city.getOwner().toString().toLowerCase()+"shield",
					new Point( GfxConstants.CITY_SHIELD_X,
							GfxConstants.CITY_SHIELD_Y ) );
			cityProductionFocus.set(city.getProduction(),
					new Point( GfxConstants.CITY_PRODUCTION_X,
							GfxConstants.CITY_PRODUCTION_Y));
			cityWorkforceFocus.set(city.getWorkforceFocus(),
					new Point( GfxConstants.WORKFORCEFOCUS_X,
							GfxConstants.WORKFORCEFOCUS_Y));
		}
	}
}
