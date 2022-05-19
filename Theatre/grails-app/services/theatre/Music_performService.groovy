package theatre

import grails.gorm.services.Service

@Service(Music_perform)
interface Music_performService {

    Music_perform get(Serializable id)

    List<Music_perform> list(Map args)

    Long count()

    void delete(Serializable id)

    Music_perform save(Music_perform music_perform)

}