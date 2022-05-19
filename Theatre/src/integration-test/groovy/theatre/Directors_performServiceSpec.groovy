package theatre

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class Directors_performServiceSpec extends Specification {

    Directors_performService directors_performService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Directors_perform(...).save(flush: true, failOnError: true)
        //new Directors_perform(...).save(flush: true, failOnError: true)
        //Directors_perform directors_perform = new Directors_perform(...).save(flush: true, failOnError: true)
        //new Directors_perform(...).save(flush: true, failOnError: true)
        //new Directors_perform(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //directors_perform.id
    }

    void "test get"() {
        setupData()

        expect:
        directors_performService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Directors_perform> directors_performList = directors_performService.list(max: 2, offset: 2)

        then:
        directors_performList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        directors_performService.count() == 5
    }

    void "test delete"() {
        Long directors_performId = setupData()

        expect:
        directors_performService.count() == 5

        when:
        directors_performService.delete(directors_performId)
        sessionFactory.currentSession.flush()

        then:
        directors_performService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Directors_perform directors_perform = new Directors_perform()
        directors_performService.save(directors_perform)

        then:
        directors_perform.id != null
    }
}
