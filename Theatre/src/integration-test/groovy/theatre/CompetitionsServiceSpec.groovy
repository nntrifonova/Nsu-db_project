package theatre

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class CompetitionsServiceSpec extends Specification {

    CompetitionsService competitionsService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Competitions(...).save(flush: true, failOnError: true)
        //new Competitions(...).save(flush: true, failOnError: true)
        //Competitions competitions = new Competitions(...).save(flush: true, failOnError: true)
        //new Competitions(...).save(flush: true, failOnError: true)
        //new Competitions(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //competitions.id
    }

    void "test get"() {
        setupData()

        expect:
        competitionsService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Competitions> competitionsList = competitionsService.list(max: 2, offset: 2)

        then:
        competitionsList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        competitionsService.count() == 5
    }

    void "test delete"() {
        Long competitionsId = setupData()

        expect:
        competitionsService.count() == 5

        when:
        competitionsService.delete(competitionsId)
        sessionFactory.currentSession.flush()

        then:
        competitionsService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Competitions competitions = new Competitions()
        competitionsService.save(competitions)

        then:
        competitions.id != null
    }
}
