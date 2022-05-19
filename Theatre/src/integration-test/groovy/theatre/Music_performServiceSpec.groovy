package theatre

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class Music_performServiceSpec extends Specification {

    Music_performService music_performService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Music_perform(...).save(flush: true, failOnError: true)
        //new Music_perform(...).save(flush: true, failOnError: true)
        //Music_perform music_perform = new Music_perform(...).save(flush: true, failOnError: true)
        //new Music_perform(...).save(flush: true, failOnError: true)
        //new Music_perform(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //music_perform.id
    }

    void "test get"() {
        setupData()

        expect:
        music_performService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Music_perform> music_performList = music_performService.list(max: 2, offset: 2)

        then:
        music_performList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        music_performService.count() == 5
    }

    void "test delete"() {
        Long music_performId = setupData()

        expect:
        music_performService.count() == 5

        when:
        music_performService.delete(music_performId)
        sessionFactory.currentSession.flush()

        then:
        music_performService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Music_perform music_perform = new Music_perform()
        music_performService.save(music_perform)

        then:
        music_perform.id != null
    }
}
