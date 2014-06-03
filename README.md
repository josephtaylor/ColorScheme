ColorScheme
===========

A color scheme importing library for Processing.
 
To download the library for use with Processing visit the [website](http://josephtaylor.github.io/ColorScheme).
 
## Features
This allows you to load ColorSchemes in a number of ways:

1. .xml files generated from [colorschemedesigner.com](http://colorschemedesigner.com)
you will get back a Pallete which contains ColorSets of Colors, much like what you see displayed on the website.
2. .ase files generated from Adobe products.
only RGB colors are supported, currently.
3. by passing in an image file.
a ColorScheme will be generated based on the most common colors in the image (with a bit of randomness so you won't get the same one every time).


## Usage
To use the library, instantiate a ColorScheme object in your setup() method like so:
```java
ColorScheme colorScheme = new ColorScheme("theFileToLoad.xml", this);
```
Now you have access to the palette which you can get by calling:
```java
colorScheme.getPalette();
```
Alternately, you can access a java.util.List of Color objects by calling:
```java
colorScheme.getColors();
```

## Building the library
There is a script to run maven on the project, generate the documentation, and jar/zip everything up in the target directory.

To run it from the root directory of the project:
```
./build.sh
```
## Installation
to install the library, unzip the archive in the target folder called ColorScheme.zip in the libraries folder of your Processing sketchbook.
 

