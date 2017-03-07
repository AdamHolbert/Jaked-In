package Models.NPCs;

import java.util.ArrayList;

import Controller.StoryController;
import Cutscene.Cutscene;
import Cutscene.DialogCutscene;
import Interfaces.Interactable;
import Models.Collision;
import Models.Entity;
import Models.Players.PlayableCharacter;
import SpriteSheet.SpriteSheet;

public class AmbushNPC extends PlayableCharacter implements Interactable {
	
	private StoryController controller;
	private PlayableCharacter enemy;
	private boolean interacted;

	public AmbushNPC(StoryController controller, int x, int y) {
		super(SpriteSheet.getNPC(), x, y);
		this.controller = controller;
		setTag(getTag() + "-EnemyNPC");
	}
	
//	public String conversation(PlayableCharacter c) {
//		return dialogue;
//	}

	@Override
	public void interact(PlayableCharacter p) {
		Cutscene c = new DialogCutscene(controller, .5, "GET HIM!");
		controller.startCutscene(c);
		setImage(SpriteSheet.getEnemy());
		setEnemy(p);
		interacted = true;
	}

	@Override
	public void hasCollided(Collision c) {
//		Entity collider;
//		if(c.collidingEntity == this){
//			collider = c.collidedEntity;
//		} else { 
//			collider = c.collidingEntity;
//		}
//		System.out.println(collider);
//		System.out.println(collider.getTag());
//		String[] tagElements = collider.getTag().split("-");
//		switch(tagElements[0]){
//		case "Human":
//			if(InputHandler.keyInputContains(KeyCode.F)){
//				interact((PlayableCharacter)collider);
//			}
//			break;
//		}
	}

	@Override
	public void update(ArrayList<Entity> entities) {
		if(interacted){
			// make sure we add weapon and health bar
		}
	}
	
	public void setEnemy(PlayableCharacter c){
		enemy = c;
	}

}
