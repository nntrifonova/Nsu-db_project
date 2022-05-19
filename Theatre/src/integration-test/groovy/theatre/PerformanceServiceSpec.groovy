package theatre

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PerformanceServiceSpec extends Specification {

    PerformanceService performanceService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Performance(...).save(flush: true, failOnError: true)
        //new Performance(...).save(flush: true, failOnError: true)
        //Performance performance = new Performance(...).save(flush: true, failOnError: true)
        //new Performance(...).save(flush: true, failOnError: true)
        //new Performance(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //performance.id
    }

    void "test get"() {
        setupData()

        expect:
        performanceService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Performance> performanceList = performanceService.list(max: 2, offset: 2)

        then:
        performanceList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        performanceService.count() == 5
    }

    void "test delete"() {
        Long performanceId = setupData()

        expect:
        performanceService.count() == 5

        when:
        performanceService.delete(performanceId)
        sessionFactory.currentSession.flush()

        then:
        performanceService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Performance performance = new Performance()
        performanceService.save(performance)

        then:
        performance.id != null
    }
}
