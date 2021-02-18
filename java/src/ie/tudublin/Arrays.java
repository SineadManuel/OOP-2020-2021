package ie.tudublin;

import processing.core.PApplet;

public class Arrays extends PApplet {

    // This is how the map function works!
    public float map1(float from, float start1, float stop1, float start2, float stop2) {
        float range1 = stop1 - start1;
        float range2 = stop2 - start2;
        float howFar = from - start1;

        return start2 + (howFar / range1) * range2;
    }

    // This is a demo of the map function
    public void drawGrid() {
        stroke(0, 255, 0);
        float border = width * 0.1f;
        textAlign(CENTER, CENTER);
        for (int i = -5; i <= 5; i++) {
            float x = map(i, -5, 5, border, width - border);
            line(x, border, x, height - border);
            line(border, x, width - border, x);
            fill(255);
            text(i, x, border * 0.5f);
            text(i, border * 0.5f, x);
        }
    }
    
    // Return the sum of all the elements in an array
    float sum(float[] array) {
        float sum = 0;
        for (float r : array) {
            sum += r;
        }
        return sum;
    }

    public void settings() {
        size(500, 500);

        // Testing the map function
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

    float[] rainfall = { 45, 37, 55, 27, 38, 50, 79, 48, 104, 31, 100, 58 };
    String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
    float[] arr = new float[100]; // 100 float array

    public void keyPressed() {
        // the value of mode will be the number of the
        // number key pressed
        if (keyCode >= '0' && keyCode <= '9')
            mode = keyCode - '0';
    }

    public void setup() {
        colorMode(RGB);

        // Iterating over an array in Java
        for (int i = 0; i < rainfall.length; i++) {
            println(months[i] + "\t" + rainfall[i]);
        }

        // Enhanced for loop
        for (float f : rainfall) {
            println(f);
        }

        // What month had the most and least rainfall??
        // What is the total rainfall?
        // What is the average rainfall??

        float sum = 0;
        int minIndex = 0;
        int maxIndex = 0;
        sum = 0;
        float average = 0;
        for (int i = 0; i < rainfall.length; i++) {
            if (rainfall[i] < rainfall[minIndex]) {
                minIndex = i;
            }
            if (rainfall[i] > rainfall[maxIndex]) {
                maxIndex = i;
            }
            sum += rainfall[i];
        }

        average = sum / (float) rainfall.length;
        println("Least rainfall was in " + months[minIndex] + " with " + rainfall[minIndex]);
        println("Most rainfall was in " + months[maxIndex] + " with " + rainfall[maxIndex]);
        println("Average rainfall: " + average);

        // rect(x, y, w, -h);

        // Draw a bar chart of the rainfall!!
        // Use the map function

        colorMode(HSB);
        float w = 400 / (float) rainfall.length;
        for (int i = 0; i < rainfall.length; i++) {
            stroke(255);
            fill(random(255), 255, 255);
            float x = map(i, 0, rainfall.length, 50, 450);
            rect(x, 450, w, -rainfall[i]);
        }
    }


    public void draw() {
        background(0);
        size(500, 500);
        switch (mode) {
            // Bar Chart
            case 0: {               
                // Y-axis numbers
                float border = width * 0.1f;
                for (int i = 120; i >= 0; i--) {
                    float x = map(i, 120, 1.5f, border + 5 , width - border);
                    fill(255);
                    text(i, border * 0.5f, x);
                    i -= 9;
                }
                
                // Y-axis markers
                for (int i = 120; i >= 0; i--) {
                    float x = map(i, 120, 0, border, width - border);
                    fill(255);
                    line(45, x, 50, x);
                    i -= 9;
                }
                
                // X-axis month lables
                for (int i = 0; i < rainfall.length; i++) {
                    fill(255);
                    float x = map(i, 0, rainfall.length, 65, 470);
                    text(months[i], x, 475);
                }

                fill(255);
                // Chart title
                text("Rainfall Bar Chart", 250, 30);
                textAlign(CENTER);
                line(50, 50, 50, 450);

                // Colourful bars
                colorMode(HSB);
                float w = 400 / (float) rainfall.length;
                for (int i = 0; i < rainfall.length; i++) {
                    stroke(255);
                    fill(i * 21, 255, 255);
                    float x = map(i, 0, rainfall.length, 50, 450);
                    
                    // Bryan's code
                    float h = map(rainfall[i], 0, 120, 0, -(height - (border * 2)));
                    rect(x, height - border - 1, w, h);

                    // My code
                    //rect(x, 450, w, -rainfall[i] * 3.3f);
                }
                break;
            }
            // Trend line
            case 1: {
                // Y-axis numbers
                float border = width * 0.1f;
                for (int i = 120; i >= 0; i--) {
                    float x = map(i, 120, 1.5f, border + 5 , width - border);
                    fill(255);
                    text(i, border * 0.5f, x);
                    i -= 9;
                }
                
                // Y-axis markers
                for (int i = 120; i >= 0; i--) {
                    float x = map(i, 120, 0, border, width - border);
                    fill(255);
                    line(45, x, 50, x);
                    i -= 9;
                }
                
                // X-axis month lables
                for (int i = 0; i < rainfall.length; i++) {
                    fill(255);
                    float x = map(i, 0, rainfall.length, 65, 470);
                    text(months[i], x, 475);
                }

                fill(255);
                // Chart title
                text("Rainfall Trend Chart", 250, 30);
                textAlign(CENTER);
                
                // Axis boundaries
                int minSize = 50;
                int maxSize = 450;
                
                // Y-axis line
                line(minSize, minSize, minSize, maxSize);

                // X-axis line
                line(minSize, maxSize, maxSize, maxSize);

                // Trend line
                for (int i = 1; i < rainfall.length; i++) {
                    stroke(255);
                    float x = map(i, 0, rainfall.length, 30, 440);
                    line(x, maxSize - (rainfall[i - 1] * 3.3f), x + 34, maxSize - (rainfall[i] * 3.3f));
                }
                break;
            }
            // Pie chart
            case 2: {
                fill(255);
                // Chart title
                text("Rainfall Pie Chart", 250, 30);
                textAlign(CENTER);

                float sum = 0;
                int minIndex = 0;
                int maxIndex = 0;

                // Calculating sum of anual temp
                for (int i = 0; i < rainfall.length; i++) {
                    if (rainfall[i] < rainfall[minIndex]) {
                        minIndex = i;
                    }
                    if (rainfall[i] > rainfall[maxIndex]) {
                        maxIndex = i;
                    }
                    sum += rainfall[i];
                }
                
                colorMode(HSB);
                for (int i = 0; i < rainfall.length; i++) {
                    stroke(255);
                    float angle = map(rainfall[i], 0, sum, 0, TWO_PI);
                    fill(i * 21, 255, 255);
                    arc(250, 250, 250, 250, 0, angle);
                    
                }
                break;
            }
        }
    }
}
