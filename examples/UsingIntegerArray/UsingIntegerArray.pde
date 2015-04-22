/**
 * This is an example illustrating the use
 * of the toIntegerArray() method on ColorScheme
 * that returns an ArrayList of Integers
 * which represent the colors in the scheme.
 * 
 * Lines are drawn with random colors from the scheme,
 * accessed by using the ArrayList get() method.
 */
import jto.colorscheme.*;

ColorScheme cs;

ArrayList<Integer> colors;

void setup() {
  size(500, 500);
  background(255);
  
  cs = new ColorScheme("threeSets.xml", this);
  
  //get the colors as an ArrayList of Integers
  colors = cs.toIntegerArray();
}

void draw() {
    for(int i = 0; i < 100; i++) {
      
      int index = (int) random(colors.size());
      
      //accessing the color from the ArrayList
      stroke(colors.get(index));
      
      line(0, random(width), width, random(height));
    }
}