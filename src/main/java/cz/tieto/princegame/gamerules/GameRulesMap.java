package cz.tieto.princegame.gamerules;

import cz.tieto.princegame.common.action.Action;
import cz.tieto.princegame.common.gameobject.Prince;

public interface GameRulesMap {

	Action generateAction(Prince prince);
	
	void addGameRule(GameRule gameRule);
	
	void setDefaultGameRule(GameRule gameRule);
	
}
