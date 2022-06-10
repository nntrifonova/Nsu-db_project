package theatre

class Employee {
    String full_name
    String sex
    Date birth_date
    Date hired
    int salary
    int kids        
    
    static constraints = {
        full_name blank: false
        sex nullable: false, blank: false, size: 1..2
        birth_date nullable: false
        hired nullable: false
        salary nullable: false
        kids nullable: false
    }
     String toString(){
        full_name
    }

}
