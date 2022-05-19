package theatre

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class DirectorsController {

    DirectorsService directorsService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond directorsService.list(params), model:[directorsCount: directorsService.count()]
    }

    def show(Long id) {
        respond directorsService.get(id)
    }

    def create() {
        respond new Directors(params)
    }

    def save(Directors directors) {
        if (directors == null) {
            notFound()
            return
        }

        try {
            directorsService.save(directors)
        } catch (ValidationException e) {
            respond directors.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'directors.label', default: 'Directors'), directors.id])
                redirect directors
            }
            '*' { respond directors, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond directorsService.get(id)
    }

    def update(Directors directors) {
        if (directors == null) {
            notFound()
            return
        }

        try {
            directorsService.save(directors)
        } catch (ValidationException e) {
            respond directors.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'directors.label', default: 'Directors'), directors.id])
                redirect directors
            }
            '*'{ respond directors, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        directorsService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'directors.label', default: 'Directors'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'directors.label', default: 'Directors'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
