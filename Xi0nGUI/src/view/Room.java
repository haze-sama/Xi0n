package view;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Room {

	private Robot robot;
	private List<Obstacle> obstacles;

	public Room() {
		this.robot = new Robot(0, 0);
		this.obstacles = new ArrayList<Obstacle>();
		this.initialize();
	}
	
	private void initialize(){
		this.obstacles.add(new Obstacle(50, 50, 200));
	}

	public void render(ShapeRenderer sr) {
		sr.setColor(Color.BLACK);
		sr.rect(-500, -500, 1000, 1000);
		for(Obstacle obstacle : this.obstacles){
			obstacle.render(sr);
			if(obstacle.collide(this.robot.getPosition())){
				this.robot.crash();
				Gdx.app.error("Robot", "destroyed");
			}
		}
		this.robot.render(sr);
	}

	public void update() {
		//TODO: Calculate the distance between the obstacle and the sensor to simulate it before mathieu's work
		this.robot.update(0);
	}

	public Vector2 getCameraPosition() {
		return this.robot.getPosition();
	}

}
