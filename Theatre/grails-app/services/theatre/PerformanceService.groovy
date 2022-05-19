package theatre

import grails.gorm.services.Service

@Service(Performance)
interface PerformanceService {

    Performance get(Serializable id)

    List<Performance> list(Map args)

    Long count()

    void delete(Serializable id)

    Performance save(Performance performance)

}