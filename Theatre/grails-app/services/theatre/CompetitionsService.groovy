package theatre

import grails.gorm.services.Service

@Service(Competitions)
interface CompetitionsService {

    Competitions get(Serializable id)

    List<Competitions> list(Map args)

    Long count()

    void delete(Serializable id)

    Competitions save(Competitions competitions)

}