package theatre

class Plays {
    String name
    static hasOne = [author: Authors]
    static belongsTo = Authors
    //Authors author
    String genre
    String age_category
    int creation_year
    static constraints = {
        name nullable: false, blank: false
    //    author nullable: false
        genre nullable: false, blank: false
        age_category nullable: false, blank: false
        creation_year nullable: false
    }
     String toString(){
        name
    }
}
