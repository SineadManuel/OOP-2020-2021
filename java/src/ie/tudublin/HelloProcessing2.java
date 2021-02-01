package ie.tudublin;

import processing.core.PApplet;

public class HelloProcessing2 extends PApplet // HP2 is subclass of PA
{

	public void settings()
	{
		size(500, 500); // size of window
	}

	public void setup() {
		
	}
	
	public void draw()
	{	
		background(255, 0, 0); // Background colour red
		//stroke(0); // Pen colour green
		// line(10, 10, 200, 200); // x1, y1, x2, y2

		noStroke(); // does not outline other shapes

		// Yellow circle
		fill(225, 225, 0);
		ellipse(250, 300, 400, 400); // cx, cy, w, h

		// Cyan triangle
		fill(0, 255, 255);
		triangle(450, 450, 250, 50, 50, 450);

		// Grey ellipse
		fill(198, 203, 202);
		ellipse(250, 250, 190, 100);

		// Black ellipse
		fill(0);
		ellipse(250, 250, 70, 70);

		// fill(0, 0, 255); dark blue
		// rect(20, 100, 70, 90); // top-left_x, top-left_y, w, h
		// point(200, 60);

		// fill(0); black
		// text("Hello world", 300, 300);
	}
}
