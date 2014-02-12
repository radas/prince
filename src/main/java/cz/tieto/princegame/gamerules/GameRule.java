package cz.tieto.princegame.gamerules;

import cz.tieto.princegame.common.action.Action;
import cz.tieto.princegame.common.gameobject.Prince;

public interface GameRule {

	Action generateAction(Prince prince);

}
