#!/usr/bin/env bash

echo "EXECUTANDO CLIENTES"

cd app1/

echo "CONSTRUINDO PROJETO - APP1"
mvn clean package

clear

cd ..

cd app2/

echo "CONSTRUINDO PROJETO - APP2"
mvn clean package

clear

cd ..

echo "EXECUTANDO CLIENTES..."

java -jar app1/target/app1-jar-with-dependencies.jar & java -jar app2/target/app2-jar-with-dependencies.jar

