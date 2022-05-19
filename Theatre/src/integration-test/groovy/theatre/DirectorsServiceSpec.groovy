package theatre

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class DirectorsServiceSpec extends Specification {

    DirectorsService directorsService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Directors(...).save(flush: true, failOnError: true)
        //new Directors(...).save(flush: true, failOnError: true)
        //Directors directors = new Directors(...).save(flush: true, failOnError: true)
        //new Directors(...).save(flush: true, failOnError: true)
        //new Directors(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //directors.id
    }

    void "test get"() {
        setupData()

        expect:
        directorsService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Directors> directorsList = directorsService.list(max: 2, offset: 2)

        then:
        directorsList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        directorsService.count() == 5
    }

    void "test delete"() {
        Long directorsId = setupData()

        expect:
        directorsService.count() == 5

        when:
        directorsService.delete(directorsId)
        sessionFactory.currentSession.flush()

        then:
        directorsService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Directors directors = new Directors()
        directorsService.save(directors)

        then:
        directors.id != null
    }
}
