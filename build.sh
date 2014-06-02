#!/bin/bash

echo ' -- building with maven'
mvn clean install
echo ' -- generating javadocs'
mvn javadoc:javadoc

echo ' -- moving javadocs'
cd reference
cp -rv apidocs/* .
rm -rf apidocs
cd ..

echo ' -- copying jar to library folder'
cp -v ./target/*.jar ./library/

echo ' -- move everything to target/ColorScheme'
mkdir target/ColorScheme
cp -r src target/ColorScheme/
cp -r reference target/ColorScheme/
cp -r examples target/ColorScheme/
cp -r library target/ColorScheme/

echo ' -- generate zip file '
cd target
zip -r ColorScheme.zip ColorScheme



