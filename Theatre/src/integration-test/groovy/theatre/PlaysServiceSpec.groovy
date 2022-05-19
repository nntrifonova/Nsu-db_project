package theatre

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PlaysServiceSpec extends Specification {

    PlaysService playsService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Plays(...).save(flush: true, failOnError: true)
        //new Plays(...).save(flush: true, failOnError: true)
        //Plays plays = new Plays(...).save(flush: true, failOnError: true)
        //new Plays(...).save(flush: true, failOnError: true)
        //new Plays(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //plays.id
    }

    void "test get"() {
        setupData()

        expect:
        playsService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Plays> playsList = playsService.list(max: 2, offset: 2)

        then:
        playsList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        playsService.count() == 5
    }

    void "test delete"() {
        Long playsId = setupData()

        expect:
        playsService.count() == 5

        when:
        playsService.delete(playsId)
        sessionFactory.currentSession.flush()

        then:
        playsService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Plays plays = new Plays()
        playsService.save(plays)

        then:
        plays.id != null
    }
}
