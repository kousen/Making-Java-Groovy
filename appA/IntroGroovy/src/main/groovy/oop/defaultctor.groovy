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
package oop

class MyBook {
    String isbn
    String title
}

def b1 = new MyBook()
def b2 = new MyBook(isbn:'1-932394-84-2')
def b3 = new MyBook(title:'GinA')
def b4 = new MyBook(isbn:'1-59059-758-3',title:'DGG')

assert b2.isbn == '1-932394-84-2'
assert b3.title == 'GinA'
assert b4.isbn == '1-59059-758-3'
assert b4.title == 'DGG'