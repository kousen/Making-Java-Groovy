AntBuilder ant = new AntBuilder()

String srcDir = 'src'
String buildDir = 'build'
String classesDir = "${buildDir}/classes"
String jarDir = "${buildDir}/jar"
String reportDir = "${buildDir}/reports"
String libDir = 'lib'

ant.with {
    path(id:'classpath') {
        fileset dir:libDir, includes:"**/*.jar"
    }
    
    path id:'application', location:"$jarDir/HelloAntBuilder.jar"
    
    // compile java
    delete dir:buildDir
    mkdir dir:classesDir
    javac(srcdir:srcDir, destDir:classesDir, 
        includeantruntime:false, classpathref:'classpath') 

    // build jar
    mkdir dir:jarDir
    jar(destfile:"${jarDir}/HelloAntBuilder.jar", basedir:classesDir) {
        manifest {
            attribute name:'Main-Class', value:'mjg.HelloWorld'
        }
    }

    // run tests
    mkdir dir:reportDir
    junit(printsummary:'yes') {
        classpath {
            path refid:'classpath'
            path refid:'application'
        }
        formatter type:'xml'
        batchtest(fork:'yes', todir:reportDir) {
            fileset dir:srcDir, includes:"**/*Test.java"
        }

    }

    // generate test report
    junitreport(todir:reportDir) {
        fileset dir:reportDir, includes:"TEST-*.xml"
        report todir:reportDir
    }

    // execute main method
    java(jar:"$jarDir/HelloAntBuilder.jar", fork:'true') {
        classpath {
            path refid:'classpath'
            path refid:'application'
        }
    }
}
