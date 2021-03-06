package Models.NPCs;

import java.util.ArrayList;

import Controller.StoryController;
import Cutscene.Cutscene;
import Cutscene.DialogCutscene;
import Interfaces.Interactable;
import Models.Entity;
import Models.Players.PlayableCharacter;
import Models.Upgrades.MedPack;
import Models.Upgrades.Upgrade;
import SpriteSheet.SpriteSheet;

public class MedicNPC extends NPC implements Interactable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] dialogue = {"You dont need my help right now.", "You are hurt! This will help."};

	public MedicNPC(StoryController st, int x, int y) {
		super(SpriteSheet.getMedic(), st, x, y);
	}

	// Figure out how to make this work
	// could maybe do it in the update method...
	public String callPlayer() {
		return "OVER HERE!!";
	}

	@Override
	public void interact(PlayableCharacter c) {
		Cutscene convo;
		
		if (c.getMaxHealth() > c.getCurrentHealth()) {
			Upgrade u = new MedPack(0, 0);
			u.collect(c);
			convo = new DialogCutscene(getController(), .5, dialogue[1]);
		} else {
			convo = new DialogCutscene(getController(), .5, dialogue[0]);
		}
		
		getController().startCutscene(convo);
	}

	@Override
	public void update(ArrayList<Entity> entities) {
		//entity does not move. no need to update.

	}

}
