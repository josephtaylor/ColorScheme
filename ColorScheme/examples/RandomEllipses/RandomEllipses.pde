import jto.colorscheme.*;

ColorScheme cs;

ArrayList<Color> colors;

void setup() {
  size(500, 500);
  background(0);
  
  cs = new ColorScheme("test.ase", this);
  
  colors = cs.getColors();
}

void draw() {
    int index = (int) random(colors.size());
    Color c = colors.get(index);
    fill(c.toInt());
    float radius = random(20, 100);
    ellipse(random(width), random(height), radius, radius);
}
