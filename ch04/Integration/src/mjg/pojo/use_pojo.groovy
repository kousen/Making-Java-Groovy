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
package mjg.pojo

def buffy = new Person(name:'Buffy')
assert buffy.id == 0
assert buffy.name == 'Buffy'

def faith = new Person(name:'Faith',id:1)
assert faith.id == 1
assert faith.name == 'Faith'

def willow = [name:'Willow',id:2] as Person
assert willow.id == 2
assert willow.name == 'Willow'

def slayers = [buffy, faith]
assert ['Buffy','Faith'] == slayers*.name
assert slayers.class == java.util.ArrayList

def characters = slayers + willow
assert ['Buffy','Faith','Willow'] == characters*.name
def doubles = characters.findAll { it.name =~ /([a-z])\1/ }
assert ['Buffy','Willow'] == doubles*.name