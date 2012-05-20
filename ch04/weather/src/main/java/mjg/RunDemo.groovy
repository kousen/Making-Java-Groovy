package mjg

// Marlborough, CT:  2445916
// York, PA       :  2524847
// Boston, MA     :  2367105
// London, UK     :  44418
// Paris, FR      :  615702
// Los Angeles, CA:  2442047
// Brisbane, AU   :  1100661

def woeid = args.size() ? args[0] : '2445916'
println new YahooParser(woeid:woeid).weather
