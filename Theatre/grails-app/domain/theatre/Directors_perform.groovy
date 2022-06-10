package theatre

class Directors_perform {
    Directors director
    Performance performance
    static constraints = {
        director nullable: false
        performance nullable: false
    }
     String toString(){
        director
    }
}
