#!/bin/bash

echo 'cd ../../../'
cd ../../../

echo 'java -Dspring.profiles.active=local -Dfile.encoding=utf-8 -jar auth-server/build/libs/basic-auth-server-0.0.1.jar'
java -Dspring.profiles.active=local -Dfile.encoding=utf-8 -jar auth-server/build/libs/basic-auth-server-0.0.1.jar
