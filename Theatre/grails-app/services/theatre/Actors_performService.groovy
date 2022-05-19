package theatre

import grails.gorm.services.Service

@Service(Actors_perform)
interface Actors_performService {

    Actors_perform get(Serializable id)

    List<Actors_perform> list(Map args)

    Long count()

    void delete(Serializable id)

    Actors_perform save(Actors_perform actors_perform)

}