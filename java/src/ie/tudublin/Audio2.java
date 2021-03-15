package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import processing.core.PApplet;

public class Audio2 extends PApplet {

    Minim minin;
    AudioPlayer ai;
    AudioBuffer ab;
    FFT fft;

    public void settings() {
        // size(512, 512, P3D);
        fullScreen(P3D, SPAN); // Try this for full screen multiple monitor support :-) Be careful of exceptions!
    }

    float y = 200;
    float lerpedY = y;

    int which = 0;

    public void setup() {         
        colorMode(HSB);
        
        Minim minim = new Minim(this);
        AudioPlayer ap = minim.loadFile("heroplanet.mp3", width);
        ab = ap.mix;


    }

    public void keyPressed() {
        if (keyCode >= '0' && keyCode <= '5') {
            which = keyCode - '0';
        }
    }

    float lerpedAverage = 0;

    public void draw() {
        background(0);
        stroke(255);

        float halfHeight = height / 2;
        for(int i = 0; i < ab.size; i++) {
            stroke(map(i, 0, ab.size(i), 0, 255), 255, 255);
            line(i, halfHeight + (ab.get(i) * halfHeight), i, halfHeight + (ab.get(i) * halfHeight));

        }

        fft.window(FFT.HAMMING);
        fft.forward(ab);

        for(int i = 0; i < fft.specSize(); i++) {
            stroke(map(i, 0, fft.specSize(), 0, 255), 255, 255);
            line(i, 0, i, fft.getBand(i) * halfHeight);
        }
    }
}