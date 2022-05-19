package theatre

import grails.gorm.services.Service

@Service(Theatres)
interface TheatresService {

    Theatres get(Serializable id)

    List<Theatres> list(Map args)

    Long count()

    void delete(Serializable id)

    Theatres save(Theatres theatres)

}