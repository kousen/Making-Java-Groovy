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
package metaprogramming

Expando ex = new Expando()
ex.name = 'Fido'
ex.speak = { println "$name says Woof!" }
ex.speak()

class Cat {}
Cat.metaClass.name = 'Garfield'
Cat.metaClass.says = 'wants lasagna'
Cat.metaClass.speak { println "$name $says" }
Cat c = new Cat()
c.speak()

c.name = 'Fluffy'
c.says = 'meow'
c.speak()