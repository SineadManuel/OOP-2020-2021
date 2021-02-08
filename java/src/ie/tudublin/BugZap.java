package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet {
    public void settings()
	{
		// If you want to use the width and 
		// height variables, they have to be after settings 
		// is called
		size(500, 500);
	}

	// Player dimensions
	float playerX, playerY, playerWidth;
	
	// Starting postion of player
	int start, down; //bugX, bugY;

	public void setup() {
		playerX = 250;
		playerY =  480;
		playerWidth = 20;
		start = 0;
		down = 0;
	}
	
	public void drawPlayer(float x, float y, float w, int s) {
		stroke(255, 255, 255);
		noFill();

		// Starting position
		if( s == 0 ) {
			ellipse(x, y, w, w);
			line(x, y - 10, x, 465);
		}
		// Move left
		else if( s == 1 ) {
			ellipse(x, y, w, w);
			line(x, y - 10, x, 465);
		}
		// Move right
		else if( s == 2 ) {
			ellipse(x, y, w, 20);
			line(x, y - 10, x, 465);
		}
	}

	public void drawLaser(float x, float y, float w) {
		stroke(255, 255, 0);
		line(x, 465, x, 0);
	}

	public void drawBug(int d) {//int drop) {
		noStroke();

		// fill(0, 0, 255);
		// triangle(10, 10, 30, 10, 20, 25);

		// fill(255, 0, 0);
		// triangle(10, 20, 30, 20, 20, 5);
		// float r = random(100);
		
		// if ((frameCount % 60) == 0) {
		// 	//drop = (int) r + 10;

		// 	text((int) r, 255, 255);
			
		// 	fill(0, 0, 255);
		// 	triangle(10, down, 30, down, 20, down + 15);

		// 	fill(255, 0, 0);
		// 	triangle(10, down + 10, 30, down + 10, 20, down - 5);
		// }

		// down = down + 10;
		if(d + 10 < 500) {
			fill(0, 0, 255);
			ellipse(100, d, 50, 50);
			d = d + 10;
		}
		else if(d + 10 > 500) {
			d = 10;
			break;
		}
	}

	public void draw() {
		background(0); 
		drawPlayer(playerX, playerY, playerWidth, start);
		down = down + 10;
		drawBug(down);//down);
	}

	public void keyPressed()
	{
		// Moves player to the left
		if (keyCode == LEFT)
		{
			System.out.println("Left arrow pressed");
			
			if(playerX - 5 > 10) {
				playerX = playerX - 5;
				drawPlayer(playerX, playerY, playerWidth, 1);
			}
		}

		// Moves player to the right
		if (keyCode == RIGHT)
		{
			System.out.println("Right arrow pressed");

			if(playerX + 5 < 490) {
				playerX = playerX + 5;
				drawPlayer(playerX, playerY, playerWidth, 2);
			}
		}

		// Shoots laser beam
		if (key == ' ')
		{
			System.out.println("SPACE key pressed");
			
			drawLaser(playerX, playerY, playerWidth);
		}
	}
}