#!/bin/bash

TARGET="target"

if [ -z ${JAVA_HOME+x} ]; then
    echo "Please set JAVA_HOME variable"
else
    echo "==== Cleaning"
    rm -rf ${TARGET}

    echo "==== Building"
    $JAVA_HOME/bin/javac -d ${TARGET} Main.java

    echo "==== Running"
    $JAVA_HOME/bin/java -cp ${TARGET} Main
fi
