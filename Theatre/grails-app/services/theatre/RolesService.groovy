package theatre

import grails.gorm.services.Service

@Service(Roles)
interface RolesService {

    Roles get(Serializable id)

    List<Roles> list(Map args)

    Long count()

    void delete(Serializable id)

    Roles save(Roles roles)

}