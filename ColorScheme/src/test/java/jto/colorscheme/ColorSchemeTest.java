package jto.colorscheme;

import processing.core.PApplet;
import processing.core.PImage;

import java.util.List;

/**
 * Created by Taylor on 6/2/2014.
 */
public class ColorSchemeTest extends PApplet {

    private static final String FILE = "http://scontent-b.cdninstagram.com/hphotos-xfp1/t51.2885-15/10375585_1496539287230596_700211060_n.jpg";
    private ColorScheme cs;

    public static void main(String[] args) {
        PApplet.main("jto.colorscheme.ColorSchemeTest");
    }

    @Override
    public void setup() {
        background(255);
        noStroke();
        rectMode(CORNERS);

        PImage image = loadImage(FILE);
        size(image.width, image.height + image.height / 3);

        cs = new ColorScheme(FILE, this);

        List<Color> colors = cs.getColors();
        image(image, 0, 0);
        for (Color c : colors) {
            print(c.red + ", ");
            print(c.green + ", ");
            print(c.blue + "\n");
        }
        int middleIndex = colors.size() / 2;
        int widthOfBox = image.width / colors.size() * 2;
        for (int i = 0; i < middleIndex; i++) {
            int y = image.height;
            int y2 = image.height + image.height / 6;
            int x = i * widthOfBox;
            fill(colors.get(i).toInt());
            rect(x, y, x + widthOfBox, y2);
        }

        for (int i = middleIndex; i < colors.size(); i++) {
            int y = image.height + image.height / 6;
            int y2 = height;
            int x = (i - middleIndex) * widthOfBox;
            fill(colors.get(i).toInt());
            rect(x, y, x + widthOfBox, y2);
        }
    }

    @Override
    public void draw() {
        //saveFrame("testing" + (int) random(Integer.MAX_VALUE) + ".png");
        noLoop();
    }

}
