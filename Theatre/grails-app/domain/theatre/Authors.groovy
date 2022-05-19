package theatre

class Authors {
    static hasMany = [play: Plays]
    String name
    String country
    Date birth_date
    Date death_date
    static constraints = {
        name nullable: false, blank: false
        country nullable: false, blank: false
        birth_date nullable: false
        death_date nullable: false
    }
}
