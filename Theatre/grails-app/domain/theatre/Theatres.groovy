package theatre

class Theatres {
    String name
    int seats_number
    int ticket_price
    static constraints = {
        name nullable: false, blank: false
        seats_number nullable: false
        ticket_price nullable: false
    }
     String toString(){
        name
    }
}



