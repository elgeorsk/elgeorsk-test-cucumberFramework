# Project Instructions

### Project : Framework to Test the Swiggy Application in Different Environment

A maven project using [BDD](https://cucumber.io/docs/bdd/) with Cucumber Framework to perform the Regression Testing for [Swiggy](https://www.swiggy.com/) application and to generate various reports.

The following requirements should be met:
* [x] Create a Maven Project for Swiggy application.
* [x] Create a TestNG class.
* [x] Create an xml file to enable test cases.
* [x] Create test classes for writing the test methods.
* [x] Create a page object design pattern class to store the web elements of web pages.
* [x] Create an excel file to store the test data.
* [x] Create a class to read/write data from excel file.
* [x] Create Gherkin keyword (Scenario, Given, When, Then and And).
* [x] Create cucumber hooks (Two types of hooks: Before and After).
* [x] Create cucumber integration with extent report.
* [x] Run the project in different environments by using selenium grid.
* [x] Create and build Jenkins job for the project.
* [x] Run the project in Jenkins and Extent report will be generated.
* [x] Push the code to your GitHub repositories.

## Introduction

This project is part of [Simplilearn - Automation Testing Masters Program](https://www.simplilearn.com/automation-testing-masters-program-certification-training-course) and it has to deal with functional testing, Test Driven Development (TDD) and DevOps integration.

## Setting up the project

Using [vanilla](https://github.com/ClipboardHealth/vanilla) starter kit framework and configure accordingly on the project needs.

### Dependencies
* [Java 11](https://openjdk.java.net/projects/jdk/11/)
* [Maven](https://maven.apache.org/download.cgi)
* [Google Chrome latest version](https://www.google.com/chrome/)
* [Docker](https://www.docker.com/get-started/)

## Getting Started

### How to execute the tests
> mvn clean test

### Change testing choices
In order to change testing configuration, should:
> Edit file main > resources > choices.conf
>
> APP_ENV: valid choices are: "app.env.develop", "app.env.staging"
>
> HOST: valid choices are: "host.localhost", "host.docker.selenium.grid"
>
> BROWSER: valid choices are: "chrome"
>
> HEADLESS: browser run mode. Valid choices are: "true", "false"

### Execute tests locally

Firstly edit file main > resources > choices.conf and set:
> HOST="host.localhost"

and secondly run the following command:
> mvn clean test

### About Docker container and Docker selenium grid

First should [Docker](https://docs.docker.com/desktop/) software to be installed.

Then edit file main > resources > choices.conf and set:
> HOST="host.docker.selenium.grid"

Go to the project folder and run the following command:

> docker-compose -f docker-compose-v3.yml up

and then run the following command:
> mvn clean test

### About Docker Jenkins

From the previous sector Docker should be available and the following command to be executed:

> docker-compose -f docker-compose-v3.yml up

After follow the nice [tutorial](https://www.section.io/engineering-education/building-a-java-application-with-jenkins-in-docker/) for Jenkins Maven configuration.