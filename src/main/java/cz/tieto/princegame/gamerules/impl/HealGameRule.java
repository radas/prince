package cz.tieto.princegame.gamerules.impl;

import cz.tieto.princegame.common.action.Action;
import cz.tieto.princegame.common.action.Heal;
import cz.tieto.princegame.common.gameobject.Prince;
import cz.tieto.princegame.domain.Direction;
import cz.tieto.princegame.domain.DirectionResolver;
import cz.tieto.princegame.domain.prince.PrinceDTO;
import cz.tieto.princegame.domain.prince.PrinceInstance;
import cz.tieto.princegame.gamerules.GameRule;

public class HealGameRule implements GameRule {
	
	@Override
	public Action generateAction(Prince prince) {
		
		PrinceDTO princeDto = PrinceInstance.getPrince();
		
		Action actionInPreviousRound = princeDto.getActionInPreviousRound();
		/*
		// if there is no need for healing, return null;
		if (prince.getHealth() >= princeDto.getMaxHealth()) {
			
			return null;
			
		}
		
		return new Heal();
		*/
		/*
		int healthDiff = princeDto.getHealthInPreviousRound() - prince.getHealth();
		
		if (actionInPreviousRound instanceof Heal) {
			
			if (healthDiff > 0) {
			
			
		}
		*/
		boolean waitUntilHealed = princeDto.isWaitUntilHealed();
		
		if (waitUntilHealed) {
			
			if (prince.getHealth() < princeDto.getMaxHealth()) {
				
				if (actionInPreviousRound instanceof Heal) {
					
					//if (prince.getHealth() < 5) {
					MoveGameRule moveGameRule = new MoveGameRule();
					
					Direction originalDirection = DirectionResolver.getDirection();
					
					DirectionResolver.changePrinceDirection();
					
					Action stepBackAction = moveGameRule.generateAction(prince);
					
					DirectionResolver.setDirection(originalDirection);
					princeDto.setWaitUntilHealed(true);
					System.out.println("StepBack");
					return stepBackAction;
					
				} else {
				
					return new Heal();
				
				}
				
			} else {
				
				princeDto.setWaitUntilHealed(false);
				
				return null;
				
			}
			
		}
		
		/*
		if (actionInPreviousRound instanceof Heal) {
			
			if (princeDto.getHealthInPreviousRound() == prince.getHealth()) {
				
				//if (prince.getHealth() < 5) {
				MoveGameRule moveGameRule = new MoveGameRule();
				
				Direction originalDirection = DirectionResolver.getDirection();
				
				DirectionResolver.changePrinceDirection();
				
				Action stepBackAction = moveGameRule.generateAction(prince);
				
				DirectionResolver.setDirection(originalDirection);
				princeDto.setWaitUntilHealed(true);
				System.out.println("StepBack");
				return stepBackAction;
				
				//}
				
			}
			
		}
		*/
		
		int healthDiff = princeDto.getHealthInPreviousRound() - prince.getHealth();
		
		if (healthDiff > 3) {
			
			MoveGameRule moveGameRule = new MoveGameRule();
			
			Direction originalDirection = DirectionResolver.getDirection();
			
			DirectionResolver.changePrinceDirection();
			
			Action stepBackAction = moveGameRule.generateAction(prince);
			
			DirectionResolver.setDirection(originalDirection);
			princeDto.setWaitUntilHealed(true);
			System.out.println("StepBack3");
			return stepBackAction;
			
		}
		
		if (prince.getHealth() <= 4) {
		MoveGameRule moveGameRule = new MoveGameRule();
		
		Direction originalDirection = DirectionResolver.getDirection();
		
		DirectionResolver.changePrinceDirection();
		
		Action stepBackAction = moveGameRule.generateAction(prince);
		
		DirectionResolver.setDirection(originalDirection);
		princeDto.setWaitUntilHealed(true);
		System.out.println("StepBack2");
		return stepBackAction;
		
		}
		
		return null;
		
	}

}
