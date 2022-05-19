package theatre

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class MusiciansServiceSpec extends Specification {

    MusiciansService musiciansService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Musicians(...).save(flush: true, failOnError: true)
        //new Musicians(...).save(flush: true, failOnError: true)
        //Musicians musicians = new Musicians(...).save(flush: true, failOnError: true)
        //new Musicians(...).save(flush: true, failOnError: true)
        //new Musicians(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //musicians.id
    }

    void "test get"() {
        setupData()

        expect:
        musiciansService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Musicians> musiciansList = musiciansService.list(max: 2, offset: 2)

        then:
        musiciansList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        musiciansService.count() == 5
    }

    void "test delete"() {
        Long musiciansId = setupData()

        expect:
        musiciansService.count() == 5

        when:
        musiciansService.delete(musiciansId)
        sessionFactory.currentSession.flush()

        then:
        musiciansService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Musicians musicians = new Musicians()
        musiciansService.save(musicians)

        then:
        musicians.id != null
    }
}
