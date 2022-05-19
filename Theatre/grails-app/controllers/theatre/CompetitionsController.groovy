package theatre

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class CompetitionsController {

    CompetitionsService competitionsService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond competitionsService.list(params), model:[competitionsCount: competitionsService.count()]
    }

    def show(Long id) {
        respond competitionsService.get(id)
    }

    def create() {
        respond new Competitions(params)
    }

    def save(Competitions competitions) {
        if (competitions == null) {
            notFound()
            return
        }

        try {
            competitionsService.save(competitions)
        } catch (ValidationException e) {
            respond competitions.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'competitions.label', default: 'Competitions'), competitions.id])
                redirect competitions
            }
            '*' { respond competitions, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond competitionsService.get(id)
    }

    def update(Competitions competitions) {
        if (competitions == null) {
            notFound()
            return
        }

        try {
            competitionsService.save(competitions)
        } catch (ValidationException e) {
            respond competitions.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'competitions.label', default: 'Competitions'), competitions.id])
                redirect competitions
            }
            '*'{ respond competitions, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        competitionsService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'competitions.label', default: 'Competitions'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'competitions.label', default: 'Competitions'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
