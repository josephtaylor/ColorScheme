package jto.colorscheme;

import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This creates palettes based on image files.
 */
class ImageColorSchemeGenerator {

    private static final int THRESHOLD = 10;
    private static final int GRAY_THRESHOLD = 5;

    private static final int NUM_COLORS = 10;

    static Palette readFile(String fileName, PApplet parent) {
        PImage image = parent.loadImage(fileName);
        image.loadPixels();

        Map<Integer, List<Integer>> colorMap = generateColorMap(image.pixels, parent);

        List<Integer> tempTopColors = new ArrayList<Integer>();
        List<Integer> topColors = randomTopColors(colorMap, tempTopColors, parent, NUM_COLORS);

        ColorSet colorSet = new ColorSet();
        for (Integer color : topColors) {
            Color c = new Color();
            c.red = (int) parent.red(color);
            c.green = (int) parent.green(color);
            c.blue = (int) parent.blue(color);
            c.setRgb(color);
            colorSet.addColor(c);
        }
        Palette palette = new Palette();
        palette.addColorSet(colorSet);

        return palette;
    }

    private static List<Integer> randomTopColors(final Map<Integer, List<Integer>> colorMap, List<Integer> topColors, final PApplet parent, final int numColors) {
        List<Integer> colors = new ArrayList<Integer>();
        findTopColors(colorMap, topColors, parent, numColors * 4);
        for (int i = 0; i < numColors; i++) {
            int index = (int) parent.random(topColors.size());
            colors.add(topColors.get(index));
            topColors.remove(index);
        }
        return colors;
    }

    private static void findTopColors(final Map<Integer, List<Integer>> colorMap,
                                      List<Integer> topColors, final PApplet parent, int numColors) {
        if (numColors == 0) {
            return;
        }
        int longest = 0;
        Integer longestKey = -1;
        for (Integer key : colorMap.keySet()) {
            List<Integer> colors = colorMap.get(key);
            if (colors.size() > longest) {
                longest = colors.size();
                longestKey = key;
            }
        }
        topColors.add(longestKey);
        colorMap.remove(longestKey);
        findTopColors(colorMap, topColors, parent, numColors - 1);
    }

    private static Map<Integer, List<Integer>> generateColorMap(final int[] pixels,
                                                                final PApplet parent) {
        Map<Integer, List<Integer>> colorMap = new HashMap<Integer, List<Integer>>();
        for (int color : pixels) {
            if (isGray(color, parent)) {
                continue;
            }
            boolean categoryExists = false;
            for (Integer key : colorMap.keySet()) {
                if (isCloseToColor(key, color, parent)) {
                    colorMap.get(key).add(color);
                    categoryExists = true;
                    break;
                }
            }
            if (!categoryExists) {
                List<Integer> colorList = new ArrayList<Integer>();
                colorList.add(color);
                colorMap.put(color, colorList);
            }
        }
        return colorMap;
    }

    private static boolean isGray(final int color, final PApplet parent) {
        if (parent.abs(parent.red(color) - parent.blue(color)) < GRAY_THRESHOLD
                && parent.abs(parent.blue(color) - parent.green(color)) < GRAY_THRESHOLD) {
            return true;
        }
        return false;
    }

    private static boolean isCloseToColor(final int color, final int colorToTest,
                                          final PApplet parent) {
        if ((parent.abs(parent.red(color) - parent.red(colorToTest)) < THRESHOLD) &&
                (parent.abs(parent.green(color) - parent.green(colorToTest)) < THRESHOLD) &&
                (parent.abs(parent.blue(color) - parent.blue(colorToTest)) < THRESHOLD)) {
            return true;
        }
        return false;
    }

}
