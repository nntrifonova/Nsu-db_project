package theatre

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PerformanceController {

    PerformanceService performanceService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond performanceService.list(params), model:[performanceCount: performanceService.count()]
    }

    def show(Long id) {
        respond performanceService.get(id)
    }

    def create() {
        respond new Performance(params)
    }

    def save(Performance performance) {
        if (performance == null) {
            notFound()
            return
        }

        try {
            performanceService.save(performance)
        } catch (ValidationException e) {
            respond performance.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'performance.label', default: 'Performance'), performance.id])
                redirect performance
            }
            '*' { respond performance, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond performanceService.get(id)
    }

    def update(Performance performance) {
        if (performance == null) {
            notFound()
            return
        }

        try {
            performanceService.save(performance)
        } catch (ValidationException e) {
            respond performance.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'performance.label', default: 'Performance'), performance.id])
                redirect performance
            }
            '*'{ respond performance, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        performanceService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'performance.label', default: 'Performance'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'performance.label', default: 'Performance'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
