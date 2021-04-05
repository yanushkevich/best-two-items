## Project Description
Promontory Mortgage Path Best Two Items

## How to build the project
The recommended way will be to use "Gradle build tool" (https://gradle.org) to build the project.
Please use the gradle wrapper (invoke by running 'gradlew' in a bash)

## How to execute the project
- Inside of container: Upon Request will send you containerized version of the assessment

Jar file is provided, but if you would like to build it by yourself, please execute the following - 
navigate to project directory and run in a bash : "./gradlew clean build" or "gradlew clean build"

## Important!!
- User can provide as well program args, as mention in Option 1. Program will be executed only once in that case.
- Input, e.g. C:/Users/dataset 1000.00, where C:/Users/dataset/.... - absolute path to data set, 1000.00 - balance of gift card
- To exit the program provide in one of the passed argument key word "Exit" or press Ctrl + C

Option 1. User can request data and pass parameters to the program only once
navigate to project directory and run in a bash :
java -jar build/libs/BestItems-1.0-SNAPSHOT.jar C:/Users/dataset 1000


Option 2. User can continuously request data and pass parameters to the program.
navigate to project directory and run in a bash :
java -jar build/libs/OrderBook-1.0-SNAPSHOT.jar
   2a. first arg - absolute path to data set
   2.b second arg - balance of gift card


## How to run tests
- navigate to project directory and run in a bash : "gradlew clean test" or "gradlew clean build"
  Test result report could be found in dir:
  BestItems/build/reports/tests/test/index.html

  

## Pointers of relevant code logic
1. Start point - BestItemsApplication class. Loading data from datasource,
   calculates and prints 2 best items
2. LoadManager - class responsible for loading data from data set
3. ItemsStorageManager - class responsible for storing data set in collection
4. test package - some junit tests