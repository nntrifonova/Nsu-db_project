package theatre

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ActorsServiceSpec extends Specification {

    ActorsService actorsService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Actors(...).save(flush: true, failOnError: true)
        //new Actors(...).save(flush: true, failOnError: true)
        //Actors actors = new Actors(...).save(flush: true, failOnError: true)
        //new Actors(...).save(flush: true, failOnError: true)
        //new Actors(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //actors.id
    }

    void "test get"() {
        setupData()

        expect:
        actorsService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Actors> actorsList = actorsService.list(max: 2, offset: 2)

        then:
        actorsList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        actorsService.count() == 5
    }

    void "test delete"() {
        Long actorsId = setupData()

        expect:
        actorsService.count() == 5

        when:
        actorsService.delete(actorsId)
        sessionFactory.currentSession.flush()

        then:
        actorsService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Actors actors = new Actors()
        actorsService.save(actors)

        then:
        actors.id != null
    }
}
