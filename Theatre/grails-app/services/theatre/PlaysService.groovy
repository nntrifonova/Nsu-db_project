package theatre

import grails.gorm.services.Service

@Service(Plays)
interface PlaysService {

    Plays get(Serializable id)

    List<Plays> list(Map args)

    Long count()

    void delete(Serializable id)

    Plays save(Plays plays)

}