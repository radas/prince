package cz.tieto.princegame.gamerules.impl;

import cz.tieto.princegame.common.action.Action;
import cz.tieto.princegame.common.action.Heal;
import cz.tieto.princegame.common.gameobject.Prince;
import cz.tieto.princegame.domain.Direction;
import cz.tieto.princegame.domain.DirectionResolver;
import cz.tieto.princegame.domain.prince.PrinceDTO;
import cz.tieto.princegame.domain.prince.PrinceInstance;
import cz.tieto.princegame.gamerules.GameRule;

public class StepBackGameRule implements GameRule {
	
	@Override
	public Action generateAction(Prince prince) {
		
		PrinceDTO princeDto = PrinceInstance.getPrince();
		
		int healthDiff = princeDto.getHealthInPreviousRound() - prince.getHealth();
		
		Action actionInPreviousRound = princeDto.getActionInPreviousRound();
		
		if (actionInPreviousRound instanceof Heal) {
			
			if (princeDto.getHealthInPreviousRound() == prince.getHealth()) {
				
				if (prince.getHealth() < 5) {
				MoveGameRule moveGameRule = new MoveGameRule();
				
				Direction originalDirection = DirectionResolver.getDirection();
				
				DirectionResolver.changePrinceDirection();
				
				Action stepBackAction = moveGameRule.generateAction(prince);
				
				DirectionResolver.setDirection(originalDirection);
				System.out.println("StepBack");
				return stepBackAction;
				
				}
				
			}
			
		}
		
		// we can not stay on this position, something is killing us constantly
		/*
		if ((healthDiff >= 2) && (prince.getHealth() < 2)) {
			
			MoveGameRule moveGameRule = new MoveGameRule();
			
			Direction originalDirection = DirectionResolver.getDirection();
			
			DirectionResolver.changePrinceDirection();
			
			Action stepBackAction = moveGameRule.generateAction(prince);
			
			DirectionResolver.setDirection(originalDirection);
			System.out.println("StepBack");
			return stepBackAction;
			
		}
		*/
		return null;
		
	}

}
