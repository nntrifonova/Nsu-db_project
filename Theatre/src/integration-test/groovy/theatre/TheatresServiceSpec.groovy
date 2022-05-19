package theatre

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TheatresServiceSpec extends Specification {

    TheatresService theatresService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Theatres(...).save(flush: true, failOnError: true)
        //new Theatres(...).save(flush: true, failOnError: true)
        //Theatres theatres = new Theatres(...).save(flush: true, failOnError: true)
        //new Theatres(...).save(flush: true, failOnError: true)
        //new Theatres(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //theatres.id
    }

    void "test get"() {
        setupData()

        expect:
        theatresService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Theatres> theatresList = theatresService.list(max: 2, offset: 2)

        then:
        theatresList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        theatresService.count() == 5
    }

    void "test delete"() {
        Long theatresId = setupData()

        expect:
        theatresService.count() == 5

        when:
        theatresService.delete(theatresId)
        sessionFactory.currentSession.flush()

        then:
        theatresService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Theatres theatres = new Theatres()
        theatresService.save(theatres)

        then:
        theatres.id != null
    }
}
