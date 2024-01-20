// Algebraic Data Types / ADT are ways how we compose different Data Types
// e.g.
object ADTs extends App {
    // Lets say we have sealed Traits
    // A Sealed trait is a trait, which can be extended only in script it is defined.
    sealed trait Weather
    case object Sunny extends Weather
    case object Cloudy extends Weather
    case object Rainy extends Weather
    case object Windy extends Weather

    // Now, there are only 4 possibilities for places we need weather
    // It can be either Sunny, Cloudy, Rainy or Windy
    // In Algebraic term, this kind of or relation is called Sum relation
    // since, Weather = Sunny (or - +) Cloudy (or - +) Rainy (or - +) Windy
    // Sum Types are usually - is a Relationship i.e. Sunny is a Weather

    // Other Type of ADT is PRoduct Type where Cartesian Product is used
    // e.g.
    case class WeatherRequest(lat: Double, lon: Double)
    // Now this case class is dependent on variables, lat: Double and lon: Double
    // Meaning for different values of lat and lon, we will get different Values of Weather Request
    // So Weather Request Type is cartesian product of lan and lon
    // Thats why it is called Product Type
    // Product Types - has a relationship
    // So WeatherRequest has a lat and lon

    // There are hybrid Types as well
    // e.g.
    sealed trait WeatherResponse
    case class GoodWeather(weather: Weather) extends WeatherResponse
    case class BadWeather(weather: Weather) extends WeatherResponse
    case class UglyWeather(weather: Weather) extends WeatherResponse
    case class InvalidWeather(error: String, message: String) extends WeatherResponse
    // Now here Weather Response is Sum Type, since it can either be Good, Bad, Ugly or Invalid
    // But each of Good, Bad, Ugly and Invalid Weathers are Product Type, they are dependent on Weather and String Types
    // So this is a Hybrid Type, specifically Sum-Of-Product Type
    // So GoodWeather has a Weather and GoodWeather is a WeatherResponse
}
