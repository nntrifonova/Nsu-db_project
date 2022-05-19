package theatre

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class MusiciansController {

    MusiciansService musiciansService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond musiciansService.list(params), model:[musiciansCount: musiciansService.count()]
    }

    def show(Long id) {
        respond musiciansService.get(id)
    }

    def create() {
        respond new Musicians(params)
    }

    def save(Musicians musicians) {
        if (musicians == null) {
            notFound()
            return
        }

        try {
            musiciansService.save(musicians)
        } catch (ValidationException e) {
            respond musicians.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'musicians.label', default: 'Musicians'), musicians.id])
                redirect musicians
            }
            '*' { respond musicians, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond musiciansService.get(id)
    }

    def update(Musicians musicians) {
        if (musicians == null) {
            notFound()
            return
        }

        try {
            musiciansService.save(musicians)
        } catch (ValidationException e) {
            respond musicians.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'musicians.label', default: 'Musicians'), musicians.id])
                redirect musicians
            }
            '*'{ respond musicians, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        musiciansService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'musicians.label', default: 'Musicians'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'musicians.label', default: 'Musicians'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
