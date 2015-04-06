import jto.colorscheme.*;

ColorScheme cs;

ArrayList<Integer> colors;

void setup() {
  size(500, 500);
  background(255);
  
  cs = new ColorScheme("threeSets.xml", this);
  
  colors = cs.toIntArray();
}

void draw() {
    for(int i = 0; i < 100; i++) {
      int index = (int) random(colors.size());
      stroke(colors.get(index));
      line(0, random(width), width, random(height));
    }
}
