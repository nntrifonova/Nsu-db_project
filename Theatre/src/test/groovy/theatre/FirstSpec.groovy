package theatre

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class FirstSpec extends Specification implements DomainUnitTest<First> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
