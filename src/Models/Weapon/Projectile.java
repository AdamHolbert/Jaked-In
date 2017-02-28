package Models.Weapon;

import java.util.ArrayList;

import Enums.Direction;
import Models.Collision;
import Models.Entity;
import Models.Players.PlayableCharacter;
import javafx.scene.image.Image;

public class Projectile extends HitBox{
	
	private Direction direction;

	public Projectile(PlayableCharacter e, Image i) {
		super(e, i);
		setCurrDir(Direction.getDir(getOwnedEntity().getCurrDir().getX(), getOwnedEntity().getCurrDir().getY()));
		setSpeed(5);
		setTag("Attack-Projectile-" + getOwnedEntity().getTag());
	}

	// We can add a lifetime counter or something
	@Override
	public void update(ArrayList<Entity> entities) {
		incrementTimer();
		if(getTimer() >= getLifeTime()){
			entities.remove(this);
		}
		move(getCurrDir().getX(), getCurrDir().getY());
	}
	
	@Override 
	public void hasCollided(Collision c){
		Entity collider;
		if(c.collidedEntity == this){
			collider = c.collidingEntity;
		} else { collider = c.collidedEntity; }
		String[] tagElements = collider.getTag().split("-");
		// We have exactly 2 elements, type and ID
		String[] ourElements = getTag().split("-");
//		System.out.println("Colliding: " + getTag());
//		System.out.println("Collider: " + collider.getTag());
		
		switch(tagElements[0]){
		// If I collide against these then just move away
		case "Attack":
		case "Wall":
//			if(c.xPenDepth < c.yPenDepth){
//				setXPos(getXPos() + c.collisionNormal.getX() * c.xPenDepth);
//				setCurrDir(Direction.getDir(-getCurrDir().getY(), getCurrDir().getY()));
//			} else {
//				setYPos(getYPos() + c.collisionNormal.getY() * c.yPenDepth);
//				setCurrDir(Direction.getDir(getCurrDir().getY(), -getCurrDir().getY()));
//			}
			System.out.println("Colliding: " + getTag());
			System.out.println("Collider: " + collider.getTag());
			break;
		case "Human":
		case "Computer":
		case "NPC":
			// do damage
			break;
		}
	}
	
	public void setCurrDir(Direction direction) {
		this.direction = direction;
	}
	
	public Direction getCurrDir(){
		return direction;
	}

}
