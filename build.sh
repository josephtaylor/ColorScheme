#!/bin/bash

echo ' -- building with maven'
mvn clean package
echo ' -- generating javadocs'
mvn javadoc:javadoc

echo ' -- moving javadocs'
cd target/reference
cp -rv apidocs/* .
rm -rf apidocs
cd ../..

echo ' -- copying jar to library folder'
mkdir target/library
cp -v target/ColorScheme.jar target/library/

echo ' -- move everything to target/ColorScheme'
mkdir target/ColorScheme
cp -v library.properties target/ColorScheme/
cp -rv src target/ColorScheme/
cp -rv target/reference target/ColorScheme/
cp -rv examples target/ColorScheme/
cp -rv target/library target/ColorScheme/

echo ' -- generate zip file '
cd target
zip -rv ColorScheme.zip ColorScheme



