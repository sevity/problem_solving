#!/bin/bash
FILENAME=$1
kotlinc $FILENAME -include-runtime -d out.jar && java -jar out.jar

