package cz.tieto.princegame.gamerules;

import java.util.ArrayList;
import java.util.List;

import cz.tieto.princegame.common.action.Action;
import cz.tieto.princegame.common.gameobject.Prince;

public class GameRulesMapImpl implements GameRulesMap {

	private final List<GameRule> gameRules = new ArrayList<GameRule>();
	
	private GameRule defaultGameRule;
	
	@Override
	public Action generateAction(Prince prince) {
		
		for (final GameRule gameRule : this.gameRules) {
			
			Action action = gameRule.generateAction(prince);
			
			if (action != null) {
				
				return action;
				
			}
			
		}
		
		Action defaultAction = defaultGameRule.generateAction(prince);
		
		return defaultAction;
		
	}
	
	@Override
	public void addGameRule(GameRule gameRule) {
		
		this.gameRules.add(gameRule);
		
	}

	@Override
	public void setDefaultGameRule(GameRule defaultGameRule) {
		
		this.defaultGameRule = defaultGameRule;
		
	}

}
