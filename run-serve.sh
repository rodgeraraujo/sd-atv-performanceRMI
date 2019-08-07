#!/usr/bin/env bash

echo "EXECUTANDO IDENTITY MANAGER"

cd identitymanager/

echo "CONSTRUINDO PROJETO"
mvn clean package

clear

cd ..

echo "EXECUTANDO..."

java -jar identitymanager/target/identitymanager-jar-with-dependencies.jar
