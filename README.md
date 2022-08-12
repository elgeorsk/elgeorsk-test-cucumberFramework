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
* [ ] Create Gherkin keyword (Scenario, Given, When, Then and And).
* [ ] Create cucumber hooks (Two types of hooks: Before and After).
* [ ] Create cucumber integration with extent report.
* [ ] Create Listener class to get the logs.
* [ ] Run the project in different environments by using selenium grid.
* [ ] Create and build Jenkins job for the project.
* [ ] Run the project in Jenkins and Extent report will be generated.
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
> HOST: valid choices are: "host.localhost", "host.docker.container", "host.docker.selenium.grid"
>
> BROWSER: valid choices are: "chrome", "firefox", "opera", "edge"
>
> HEADLESS: browser run mode. Valid choices are: "true", "false"

### 

### About Docker container and Docker selenium grid

First should be installed [Docker](https://docs.docker.com/desktop/) software.

> Edit file main > resources > choices.conf
>
> HOST: valid choices are: "host.localhost", "host.docker.container", "host.docker.selenium.grid"

If HOST="host.localhost" the tests will run locally

if HOST="host.docker.container" the tests will run in a docker container.

if HOST="host.docker.selenium.grid" the test will run in selenium grid.


