package builders

def ant = new AntBuilder()
String dir = 'src/main/groovy/builders'

assert !(new File("$dir/antbuildercopy.groovy").exists())

ant.echo 'about to copy the source code'
ant.copy file:"$dir/antbuilder.groovy", 
	tofile:"$dir/antbuildercopy.groovy"
	
assert (new File("$dir/antbuildercopy.groovy").exists())

ant.echo 'deleting the copied file'
ant.delete file:"$dir/antbuildercopy.groovy"

// simpler syntax
ant.with {
    echo 'about to copy the source code'
    copy file:"$dir/antbuilder.groovy", tofile:"$dir/antbuildercopy.groovy"
    echo 'deleting the copied file'
    delete file:"$dir/antbuildercopy.groovy"
}