/*  
 *   This is an example illustrating the use of an image file.
 *   You must be connected to the internet for this to work.
 *
 *   This displays a grid of the colorScheme below the source image.
 */
import jto.colorscheme.*;

ColorScheme cs;

// an image from pexels
static final String FILE = "https://images.pexels.com/photos/417344/pexels-photo-417344.jpeg";

void setup() {
  size(640, 854);
  background(255);
  noStroke();
  rectMode(CORNERS);
  
  //load the image
  PImage image = loadImage(FILE);
  
  //create our color scheme object
  cs = new ColorScheme(FILE, this);
  
  //get the list of colors from the color scheme
  color[] colors = cs.toArray();
  
  //draw the image
  image(image, 0, 0);
  
  //draw grid on the bottom of the image
  int middleIndex = colors.length / 2;
  int widthOfBox = image.width / colors.length * 2;
  for (int i = 0; i < middleIndex; i++) {
    int y = image.height;
    int y2 = image.height + image.height / 6;
    int x = i * widthOfBox;
    
    //accessing a color from our color scheme
    fill(colors[i]);
    rect(x, y, x + widthOfBox, y2);
  }

  for (int i = middleIndex; i < colors.length; i++) {
    int y = image.height + image.height / 6;
    int y2 = height;
    int x = (i - middleIndex) * widthOfBox;
    fill(colors[i]);
    rect(x, y, x + widthOfBox, y2);
  }
}

void draw() {
  noLoop();  
}
