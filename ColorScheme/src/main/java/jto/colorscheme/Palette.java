package jto.colorscheme;

import java.util.ArrayList;

/**
 * This class represents a palette of colors. It maintains a list of {@link
 * jto.colorscheme.ColorSet} objects.
 *
 * @author J. Taylor O'Connor (jtomusic@gmail.com)
 * @version 2013.08.15
 */
public class Palette {

  private ArrayList<ColorSet> colorSets = new ArrayList<ColorSet>();

  /**
   * default constructor for Palette objects.
   */
  public Palette() {

  }

  /**
   * Adds a ColorSet to the palette.
   *
   * @param colorSet the color set.
   */
  public void addColorSet(ColorSet colorSet) {
    this.colorSets.add(colorSet);
  }

  /**
   * Returns the list of colorSets in the palette.
   *
   * @return colorSets the color sets.
   */
  public ArrayList<ColorSet> getColorSets() {
    return colorSets;
  }
}
