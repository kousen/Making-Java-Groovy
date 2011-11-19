package beans;

class GameResult {
    String home
    String away
    String hScore
    String aScore
    Stadium stadium

    String toString() { "$home $hScore, $away $aScore" }
}
