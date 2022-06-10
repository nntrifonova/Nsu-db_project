package theatre

class Actors {
    Employee actor
    String vocals
    int age
    int height
    String rang
    Date rang_date
    String competition_prizes
    static constraints = {
        actor nullable: false
        vocals nullable: false , blank: false, size: 2..30
        age min:18
        height nullable: false
        rang nullable: true, blank: true
        rang_date nullable: true
        competition_prizes nullable: true, blank: true
    }
     String toString(){
        actor
    }
}
