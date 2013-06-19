Source code for Chapter 7, SOAP-based Web Services, 
of Making Java Groovy by Ken Kousen, http://manning.com/kousen.

The source includes a Gradle build file that will compile
all the code and run all the tests, ultimately producing HTML
output in build/reports/test/index.html.

If you have gradle installed, run
> gradle build

otherwise, the wrapper will download and install gradle for you:

> gradlew build

Notes:
    1. In order for the tests to work, one of the servers in the
    Ch07_GenericCalculatorService has to be running.  This project
    generates its stubs from the deployed application, which is
    running on http://localhost:1234/calc
