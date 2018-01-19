#!/bin/bash

#compile sources
javac ./Source/*.java -d ./



#notification
echo "Auxillary Sources Compiled ..."

#compile main sources
javac ./ShapeDemo.java -cp ./

#notification
echo "Main Source Compiled ..."

#run the class file
java ShapeDemo
