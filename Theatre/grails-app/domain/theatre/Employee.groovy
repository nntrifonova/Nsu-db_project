package theatre

class Employee {
    String full_name
    String sex
    Date birth_date
    Date hired
    int salary
    int kids        
    
    static constraints = {
        full_name nullable: false, blank: false
        sex nullable: false, blank: false
        birth_date nullable: false
        hired nullable: false
        salary nullable: false
        kids nullable: false
    }

}
