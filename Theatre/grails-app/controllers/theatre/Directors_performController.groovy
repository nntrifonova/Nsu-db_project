package theatre

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class Directors_performController {

    Directors_performService directors_performService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond directors_performService.list(params), model:[directors_performCount: directors_performService.count()]
    }

    def show(Long id) {
        respond directors_performService.get(id)
    }

    def create() {
        respond new Directors_perform(params)
    }

    def save(Directors_perform directors_perform) {
        if (directors_perform == null) {
            notFound()
            return
        }

        try {
            directors_performService.save(directors_perform)
        } catch (ValidationException e) {
            respond directors_perform.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'directors_perform.label', default: 'Directors_perform'), directors_perform.id])
                redirect directors_perform
            }
            '*' { respond directors_perform, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond directors_performService.get(id)
    }

    def update(Directors_perform directors_perform) {
        if (directors_perform == null) {
            notFound()
            return
        }

        try {
            directors_performService.save(directors_perform)
        } catch (ValidationException e) {
            respond directors_perform.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'directors_perform.label', default: 'Directors_perform'), directors_perform.id])
                redirect directors_perform
            }
            '*'{ respond directors_perform, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        directors_performService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'directors_perform.label', default: 'Directors_perform'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'directors_perform.label', default: 'Directors_perform'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
