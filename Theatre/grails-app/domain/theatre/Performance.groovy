package theatre

class Performance {
    Plays play
    Theatres theatre
    Competitions competition
    Boolean premier
    Date date
    int number_of_free_places

    static constraints = {
        play nullable: false
        theatre nullable: false
        competition nullable: true
        premier nullable: false
        date nullable: false
        number_of_free_places nullable: false
    }
     String toString(){
        play
    }
}
