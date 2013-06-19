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
package mjg.jdk

println 'Groundhog sees shadow --> 6 more weeks of Winter'
def c = Calendar.instance
c.set 2013, Calendar.FEBRUARY, 2
def groundHogDay = c.time
c.set 2013, Calendar.MARCH, 20
def firstDayOfSpring = c.time
def days = firstDayOfSpring - groundHogDay
assert days == (firstDayOfSpring..groundHogDay).size() - 1
println """
There are ${(int)(days/7)} weeks and ${days % 7} days between GroundHog Day 
and the first day of Spring (March 20), so Spring 
comes early if the groundhog sees his shadow.
"""