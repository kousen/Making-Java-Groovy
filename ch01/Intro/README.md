Source code for Chapter 1 of _Making Java Groovy_ by Ken Kousen.

The project is set up in typical Maven structure, with the
Java source and the Groovy source separated in both the src
and test folders. This is unlike the rest of the book, where
both are merged together.

The source includes a Gradle build file that will compile
all the code and run all the tests, ultimately producing HTML
output in build/reports/test/index.html.

If you have gradle installed, run
> gradle build

otherwise, the wrapper will download and install gradle for you:

> gradlew build
