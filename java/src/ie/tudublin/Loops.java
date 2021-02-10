package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet {

    public void settings() {
        size(500, 500);
        cx = width / 2;
        cy = height / 2;        
    }

    int mode = 0;

    float cx;
    float cy;

    public void keyPressed() {
        // the value of mode will be the number of the 
        // number key pressed
        if (keyCode >= '0' && keyCode <= '9')
            mode = keyCode - '0';
    }

    public void setup() {
        colorMode(HSB);
    }

    public void draw() {
        background(0);
        switch (mode)
        {
            case 0:
                ellipse(cx, cy, 100, 100);
                break;
            
            case 1:
                ellipse(cx, cy, 130, 130);
                break;

            case 2:
                ellipse(cx, cy, 160, 160);
                break;

            case 3:
                ellipse(cx, cy, 190, 190);
                break;

            case 4:
                ellipse(cx, cy, 220, 220);
                break;

            case 5:
                ellipse(cx, cy, 250, 250);
                break;

            case 6:
                ellipse(cx, cy, 280, 280);
                break;
            
            case 7:
                ellipse(cx, cy, 310, 310);
                break;
            
            case 8:
                ellipse(cx, cy, 340, 340);
                break;

            case 9:
                ellipse(cx, cy, 370, 370);
                break;
        }
    }
}
