package theatre

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class RolesServiceSpec extends Specification {

    RolesService rolesService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Roles(...).save(flush: true, failOnError: true)
        //new Roles(...).save(flush: true, failOnError: true)
        //Roles roles = new Roles(...).save(flush: true, failOnError: true)
        //new Roles(...).save(flush: true, failOnError: true)
        //new Roles(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //roles.id
    }

    void "test get"() {
        setupData()

        expect:
        rolesService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Roles> rolesList = rolesService.list(max: 2, offset: 2)

        then:
        rolesList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        rolesService.count() == 5
    }

    void "test delete"() {
        Long rolesId = setupData()

        expect:
        rolesService.count() == 5

        when:
        rolesService.delete(rolesId)
        sessionFactory.currentSession.flush()

        then:
        rolesService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Roles roles = new Roles()
        rolesService.save(roles)

        then:
        roles.id != null
    }
}
