package theatre

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class Actors_performController {

    Actors_performService actors_performService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond actors_performService.list(params), model:[actors_performCount: actors_performService.count()]
    }

    def show(Long id) {
        respond actors_performService.get(id)
    }

    def create() {
        respond new Actors_perform(params)
    }

    def save(Actors_perform actors_perform) {
        if (actors_perform == null) {
            notFound()
            return
        }

        try {
            actors_performService.save(actors_perform)
        } catch (ValidationException e) {
            respond actors_perform.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'actors_perform.label', default: 'Actors_perform'), actors_perform.id])
                redirect actors_perform
            }
            '*' { respond actors_perform, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond actors_performService.get(id)
    }

    def update(Actors_perform actors_perform) {
        if (actors_perform == null) {
            notFound()
            return
        }

        try {
            actors_performService.save(actors_perform)
        } catch (ValidationException e) {
            respond actors_perform.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'actors_perform.label', default: 'Actors_perform'), actors_perform.id])
                redirect actors_perform
            }
            '*'{ respond actors_perform, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        actors_performService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'actors_perform.label', default: 'Actors_perform'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'actors_perform.label', default: 'Actors_perform'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
