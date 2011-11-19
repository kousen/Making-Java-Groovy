Groovy Baseball, a web application that displays
the results of MLB games on a given date.

Info is downloaded from box score data at MLB,
parsed using Groovy, then loaded into a Google Map.

Mostly used as a demo project for my book,
Making Java Groovy, http://manning.com/kousen .
An earlier version is running online at
http://www.kousenit.com/groovybaseball ,
assuming my laptop in my office is still up. :)

If gradle is installed on your machine, execute:
> gradle build

If not, run:
> gradlew build
to download gradle, then build, test, and generate
a deployable war file.

The build process generates a local, H2 database of
stadium locations using the Google Geocoder service.
It therefore needs Internet access to run successfully.

The generated database is stored as a file in the build
directory (which is also used for testing), and is then
copied to the src/main/webapps directory for deployment.

The clean task triggers a task that removes
the generated database.