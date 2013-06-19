/* ===================================================
 * Copyright 2012 Kousen IT, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ========================================================== */
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
    assert true
    echo 'deleting the copied file'
    delete file:"$dir/antbuildercopy.groovy"
}