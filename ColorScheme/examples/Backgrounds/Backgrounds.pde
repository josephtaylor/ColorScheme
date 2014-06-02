import jto.colorscheme.*;

ColorScheme cs;

ArrayList<Color> colors;

int counter = 0;

void setup() {
  size(500, 500);
  background(0);
  
  cs = new ColorScheme("complement.xml", this);
  
  colors = cs.getColors();
  
  frameRate(1);
}

void draw() {
    background(colors.get(counter).toInt());
    
    counter = (counter + 1) % colors.size();
}
