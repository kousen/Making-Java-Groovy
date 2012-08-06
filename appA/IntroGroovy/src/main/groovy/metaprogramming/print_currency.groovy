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

import java.text.NumberFormat;

Number.metaClass.asCurrency = {
    NumberFormat nf = NumberFormat.getCurrencyInstance()
    nf.format(delegate)
} 

Number.metaClass.asCurrency = { Locale loc ->
    NumberFormat nf = NumberFormat.getCurrencyInstance(loc)
    nf.format(delegate)
}


def amount = 123456.7890
Locale.default = Locale.US
assert amount.asCurrency() == '$123,456.79'
//assert amount.asCurrency(Locale.FRANCE) == "123 456,79 \u20AC"