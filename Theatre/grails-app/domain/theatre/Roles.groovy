package theatre

class Roles {
    Performance performance
    String ceracter 
    String sex
    int age
    int height
    String vocals
    static constraints = {
        performance nullable: false
        ceracter nullable: false, blank: false
        sex nullable: false, blank: false
        age nullable: false
        height nullable: false
        vocals nullable: false, blank: false
    }
}
