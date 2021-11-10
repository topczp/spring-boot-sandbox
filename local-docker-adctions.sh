#!/bin/bash

if [ "$1" == "BUILD" ]; then
  docker build -t spring-boot-sandbox-gradle .
  s2i build complete/ spring-boot-sandbox-gradle spring-boot-sandbox-gradle-app --loglevel 6 --incremental=true
  docker run -p 8080:8080 spring-boot-sandbox-gradle-app
else
  docker run -d -p 8080:8080 spring-boot-sandbox-gradle-app
fi
