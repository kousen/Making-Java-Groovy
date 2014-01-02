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
package sorting

def strings = ['this','is','a','list','of','strings']

// sort lexicographically
assert strings.sort() == ['a','is','list','of','strings','this']

// sort using closure coerced to Comparator
Collections.sort(strings, 
    {s1, s2 -> s2.size() - s1.size()} as Comparator)
assert strings*.size() == [7, 4, 4, 2, 2, 1]

// reverse sort using sort() method on Collection
strings.sort { -it.size() }
assert strings*.size() == [7, 4, 4, 2, 2, 1]