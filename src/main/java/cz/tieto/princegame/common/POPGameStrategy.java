package cz.tieto.princegame.common;

import cz.tieto.princegame.common.action.Action;
import cz.tieto.princegame.common.gameobject.Prince;
import cz.tieto.princegame.gamerules.GameRulesMap;
import cz.tieto.princegame.gamerules.GameRulesMapImpl;
import cz.tieto.princegame.gamerules.impl.EnterGateGameRule;
import cz.tieto.princegame.gamerules.impl.GrabSwordGameRule;
import cz.tieto.princegame.gamerules.impl.HealGameRule;
import cz.tieto.princegame.gamerules.impl.JumpChopperGameRule;
import cz.tieto.princegame.gamerules.impl.JumpPitfallGameRule;
import cz.tieto.princegame.gamerules.impl.KillDragonGameRule;
import cz.tieto.princegame.gamerules.impl.KillKnightGameRule;
import cz.tieto.princegame.gamerules.impl.MoveGameRule;

public class POPGameStrategy implements GameStrategy {
	
	private static final GameRulesMap gameRulesMap = initGameRulesMap();
	
	public Action step(Prince prince) {
		
		Action action = gameRulesMap.generateAction(prince);
		
		return action;
		
	}

	private static final GameRulesMap initGameRulesMap() {
		
		final GameRulesMap map = new GameRulesMapImpl();
		
		map.addGameRule(new EnterGateGameRule());
		map.addGameRule(new GrabSwordGameRule());
		map.addGameRule(new HealGameRule());
		map.addGameRule(new KillDragonGameRule());
		map.addGameRule(new KillKnightGameRule());
		map.addGameRule(new JumpChopperGameRule());
		map.addGameRule(new JumpPitfallGameRule());
		
		map.setDefaultGameRule(new MoveGameRule());
		
		return map;
		
	}
	
}
