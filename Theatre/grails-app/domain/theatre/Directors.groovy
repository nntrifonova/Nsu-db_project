package theatre

class Directors {
    Employee director
    String occupation

    static constraints = {
        director nullable: false
        occupation nullable: false, blank: false
    }
     String toString(){
        name
    }
}
