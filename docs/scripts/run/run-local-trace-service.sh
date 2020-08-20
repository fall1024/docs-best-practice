#!/bin/bash

echo 'cd ../../../'
cd ../../../

echo 'java -Dspring.profiles.active=local -Dfile.encoding=utf-8 -jar trace-service/build/libs/basic-trace-webservice-0.0.1.jar'
java -Dspring.profiles.active=local -Dfile.encoding=utf-8 -jar trace-service/build/libs/basic-trace-webservice-0.0.1.jar
