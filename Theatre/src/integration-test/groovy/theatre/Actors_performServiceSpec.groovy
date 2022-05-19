package theatre

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class Actors_performServiceSpec extends Specification {

    Actors_performService actors_performService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Actors_perform(...).save(flush: true, failOnError: true)
        //new Actors_perform(...).save(flush: true, failOnError: true)
        //Actors_perform actors_perform = new Actors_perform(...).save(flush: true, failOnError: true)
        //new Actors_perform(...).save(flush: true, failOnError: true)
        //new Actors_perform(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //actors_perform.id
    }

    void "test get"() {
        setupData()

        expect:
        actors_performService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Actors_perform> actors_performList = actors_performService.list(max: 2, offset: 2)

        then:
        actors_performList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        actors_performService.count() == 5
    }

    void "test delete"() {
        Long actors_performId = setupData()

        expect:
        actors_performService.count() == 5

        when:
        actors_performService.delete(actors_performId)
        sessionFactory.currentSession.flush()

        then:
        actors_performService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Actors_perform actors_perform = new Actors_perform()
        actors_performService.save(actors_perform)

        then:
        actors_perform.id != null
    }
}
