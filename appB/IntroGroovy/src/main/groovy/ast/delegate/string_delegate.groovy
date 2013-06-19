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
package ast.delegate

class WrappedString {
    @Delegate String string
}

WrappedString s = new WrappedString(string:'hello')
println s.metaClass.methods.name
try {
    println s.size()
} catch (MissingMethodException e) {
    System.err.println e
}
assert s.length() == 5
def str = "hello"
assert !("hello".metaClass.methods.name.findAll { it =~ /size/ })
assert str.size() == 5
