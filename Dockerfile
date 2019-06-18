
#Get Maven 3.5.2 with java 8 from docker hub
FROM maven:3.5.2-jdk-8-slim

#Create work dir 
WORKDIR /usr/src/app

#Copy everything from current root directory to work dir
COPY . /usr/src/app
