package theatre

import grails.gorm.services.Service

@Service(Directors)
interface DirectorsService {

    Directors get(Serializable id)

    List<Directors> list(Map args)

    Long count()

    void delete(Serializable id)

    Directors save(Directors directors)

}