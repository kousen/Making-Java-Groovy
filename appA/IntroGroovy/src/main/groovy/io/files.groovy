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
package io

def files = []
new File('.').eachFileRecurse { file ->
    if (file.name.endsWith('.groovy')) {
        files << file
    }
}
assert files
println "There are ${files.size()} groovy files"

def base = 'src/main/groovy/io'

String data = new File(base + '/files.groovy').text
assert data.contains('text')

List<String> lines = new File("$base/files.groovy").readLines()*.trim()
assert lines[15] == "package io"

lines.reverse().each { println it }

List dataLines = []
new File("$base/data.txt").splitEachLine(',') {
    dataLines << it
}
assert dataLines == [['1','2','3'],['a','b','c']]


File f = new File("$base/output.dat")
f.write('Hello, Groovy!')

assert f.text == 'Hello, Groovy!'
f.delete()

File temp = new File("$base/temp.txt")

// Don't really need parens here, so why use them?
temp.write 'Groovy Kind of Love'
assert temp.readLines().size() == 1

// Need to start with a carriage return
temp.append "\nGroovin', on a Sunday afternoon..."

// Note use of overloaded << operator
temp << "\nFeelin' Groovy"
assert temp.readLines().size() == 3
temp.delete()