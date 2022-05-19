package theatre

import grails.gorm.services.Service

@Service(Musicians)
interface MusiciansService {

    Musicians get(Serializable id)

    List<Musicians> list(Map args)

    Long count()

    void delete(Serializable id)

    Musicians save(Musicians musicians)

}