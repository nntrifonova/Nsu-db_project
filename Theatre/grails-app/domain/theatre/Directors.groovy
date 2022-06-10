package theatre

class Directors {
    Employee director
    String occupation
    int premia

    static constraints = {
        director nullable: false
        occupation nullable: false, blank: false
        premia nullable: false
    }
     String toString(){
        //occupation
        director
    }
}
