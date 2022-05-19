package theatre

class Actors_perform {
    Actors actor
    Roles role
    Performance performance
    static constraints = {
        actor nullable: false
        role nullable: false
        performance nullable: false
    }
}
