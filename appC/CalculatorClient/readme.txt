Source code for Chapter 8 of Making Java Groovy by Ken Kousen.

The source includes a Gradle build file that will compile
all the code and run all the tests, ultimately producing HTML
output in build/reports/test/index.html.

If you have gradle installed, run
> gradle build

otherwise, the wrapper will download and install gradle for you:

> gradlew build

Notes:
    1. In order for the tests to work in the gradle build, you have 
    to run the mjg.calc.service.CalculatorServer application in the
    Ch07_CalculatorService project using the normal java command. 
    The client project generates its stubs from the deployed 
    application, which is running on http://localhost:1234/calc
