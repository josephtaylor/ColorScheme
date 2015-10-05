ColorScheme
===========

![ColorScheme](https://raw.githubusercontent.com/josephtaylor/ColorScheme/gh-pages/colorWheel-01.png)

A color scheme importing library for Processing.
 
To download the library for use with Processing visit the [website](http://josephtaylor.github.io/ColorScheme).
 
## Features
This allows you to load ColorSchemes in a number of ways:

1. .xml files generated from [paletton.com](http://paletton.com)
2. .ase files generated from Adobe products.
3. by passing in an image file.

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
The colors can be accessed directly as a List of Integers by calling:
```java
colorScheme.toIntegerArray();
```
If you prefer to work with primitive arrays. You can get an array of ints by calling:
```java
colorScheme.toArray();
```

## Building the library
There is a script to run maven on the project, generate the documentation, and jar/zip everything up in the target directory.

To run it from the root directory of the project:
```
./build.sh
```
## Installation
to install the library, unzip the archive in the target folder called ColorScheme.zip in the libraries folder of your Processing sketchbook.
 

