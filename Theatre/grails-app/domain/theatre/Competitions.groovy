package theatre

class Competitions {
    String name
    Date start_date
    Date end_date
    static constraints = {
        name nullable: false, blank: false
        start_date nullable: false
        end_date nullable: false
    }
}
