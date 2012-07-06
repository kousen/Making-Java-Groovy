import static groovy.io.FileType.*
import static groovy.io.FileVisitResult.*
String license = '''/* ===================================================
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
'''
dir = '/Users/kousen/mjg'
new File(dir).traverse(
    type       : FILES, 
    nameFilter : ~/.*(java|groovy)$/,
    preDir     : { if (it.name == '.metadata') return SKIP_SUBTREE }) { file ->
    println file
    // only add license if not already there
    if (!file.text.contains(license)) {
        def source = file.text
        file.text = "$license$source"
    }
    assert file.text.contains(license)
}