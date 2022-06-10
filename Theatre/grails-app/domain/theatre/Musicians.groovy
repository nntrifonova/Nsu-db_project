package theatre

class Musicians {
    Employee musician
    String vocals
    String instrument

    static hasOne = Music_perform

    static constraints = {
        musician nullable: false
        vocals nullable: false, blank: false
        instrument nullable: true, blank: true
    }
     String toString(){
        musician
    }
}
