package jto.colorscheme;

import processing.core.PApplet;

import java.net.URL;

/**
 * Created by joconnor on 4/5/15.
 */
public class PalettonTest extends PApplet {

    ColorScheme colorScheme;

    @Override
    public void setup() {
        size(500, 500);

        URL colorXmlUrl = Thread.currentThread().getContextClassLoader().getResource("colors.xml");
        colorScheme = new ColorScheme(colorXmlUrl.getFile(), this);

        System.exit(0);
    }

    public static void main(String[] args) {
        PApplet.main(PalettonTest.class.getName());
    }
}
