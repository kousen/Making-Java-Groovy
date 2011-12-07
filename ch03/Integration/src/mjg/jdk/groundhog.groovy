package mjg.jdk

println 'Groundhog sees shadow --> 6 more weeks of Winter'
def c = Calendar.instance
c.set 2010, Calendar.FEBRUARY, 2
def groundHogDay = c.time
c.set 2010, Calendar.MARCH, 21
def firstDayOfSpring = c.time
def days = firstDayOfSpring - groundHogDay
assert days == (firstDayOfSpring..groundHogDay).size() - 1
println """
There are ${(int)(days/7)} weeks and ${days % 7} days between GroundHog Day 
and the first day of Spring (March 21), so Spring 
comes early if the groundhog sees his shadow.
"""