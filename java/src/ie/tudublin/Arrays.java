package ie.tudublin;

import processing.core.PApplet;

public class Arrays extends PApplet {

    public float map1(float from, float start1, float stop1, float start2, float stop2)
    {
        float range1 = stop1 - start1;
        float range2 = stop2 - start2;
        float howFar = from - start1;

        return start2 + (howFar / range1) * range2;
    }

    public void drawGrid() {
        stroke(0, 255, 0);

        float border = width * 0.1f;
        textAlign(CENTER, CENTER);

        for(int i = -5; i <= 5; i++) {
            float x = map1(i, -5, 5, border, width - border);
            line(x, border, x, height - border);
            line(border, x, width - border, x);

            fill(255);
            text(i, x, border * 0.5f);
            text(i, border * 0.5f, x);
        }
    }


    public void settings() {
        size(500, 500);          
        
        float f = map1(2, 0, 10, 0, width);
        println(f); // Should print 100

        f = map1(9, 0, 1, 0, 10);
        println(f); // Should print 90

        f = map1(250, 200, 300, 400, 500);
        println(f); // Should print 450

        f = map1(5, 0, 10, 1000, 2000);
        println(f); // Should print 1500


    }

    int mode = 0;

    float[] rainfall = {45, 37, 55, 27, 38, 50, 79, 48, 104, 31, 100, 58};
    String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    float[] arr = new float[100]; // 100 float array

    public void keyPressed() {
        // the value of mode will be the number of the 
        // number key pressed
        if (keyCode >= '0' && keyCode <= '9')
            mode = keyCode - '0';
    }

    public void setup() {
        colorMode(RGB);

        println("\nLooping through the arrays");
        for(int i = 0; i < rainfall.length; i++) {
            println(months[i] + "\t" + rainfall[i]);
        }

        // Enhanced for loop
        println("\nEnhanced for loop");
        for(float f:rainfall) {
            println(f);
        }

        // What month had the most and least rainfall?
        int min = 0;
        int max = 0;

        println("\nMax & Min months of rainfall");
        for(int i = 0; i < rainfall.length; i++) {
            if(rainfall[min] > rainfall[i]) {
                min = i;
            }

            if(rainfall[max] < rainfall[i]) {
                max = i;
            } 
        }
        println("Min rainfall month: " + months[min]);
        println("Max rainfall month: " + months[max]);

        
        // Calculate average
        int sum = 0;
        for(int i = 0; i < rainfall.length; i++) {
            sum += rainfall[i];
        }
        println("\nAverage rainfall: " + sum/12);


        // Draw a bar chart of the rainfall
        // Use the map function
        colorMode(HSB);
        float w = width / (float) rainfall.length;

        for(int i = 0; i < rainfall.length; i++) {
            noStroke();
            fill(random(225), 225, 225);
            float x = map(i, 0 , rainfall.length, 0, width);
            rect(x, height, w, - rainfall[i]);
        }
    }

    float offset = 0;

    public void draw() {
        // background(0);
        // //noStroke();
        colorMode(HSB);
        float c = map(mouseX, 0, width, 0, 255);
        // background(c, 255, 255);
    }
}
