package theatre

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TheatresController {

    TheatresService theatresService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond theatresService.list(params), model:[theatresCount: theatresService.count()]
    }

    def show(Long id) {
        respond theatresService.get(id)
    }

    def create() {
        respond new Theatres(params)
    }

    def save(Theatres theatres) {
        if (theatres == null) {
            notFound()
            return
        }

        try {
            theatresService.save(theatres)
        } catch (ValidationException e) {
            respond theatres.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'theatres.label', default: 'Theatres'), theatres.id])
                redirect theatres
            }
            '*' { respond theatres, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond theatresService.get(id)
    }

    def update(Theatres theatres) {
        if (theatres == null) {
            notFound()
            return
        }

        try {
            theatresService.save(theatres)
        } catch (ValidationException e) {
            respond theatres.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'theatres.label', default: 'Theatres'), theatres.id])
                redirect theatres
            }
            '*'{ respond theatres, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        theatresService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'theatres.label', default: 'Theatres'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'theatres.label', default: 'Theatres'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
