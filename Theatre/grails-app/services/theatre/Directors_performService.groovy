package theatre

import grails.gorm.services.Service

@Service(Directors_perform)
interface Directors_performService {

    Directors_perform get(Serializable id)

    List<Directors_perform> list(Map args)

    Long count()

    void delete(Serializable id)

    Directors_perform save(Directors_perform directors_perform)

}