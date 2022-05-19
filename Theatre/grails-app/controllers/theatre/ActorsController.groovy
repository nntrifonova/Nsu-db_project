package theatre

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ActorsController {

    ActorsService actorsService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond actorsService.list(params), model:[actorsCount: actorsService.count()]
    }

    def show(Long id) {
        respond actorsService.get(id)
    }

    def create() {
        respond new Actors(params)
    }

    def save(Actors actors) {
        if (actors == null) {
            notFound()
            return
        }

        try {
            actorsService.save(actors)
        } catch (ValidationException e) {
            respond actors.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'actors.label', default: 'Actors'), actors.id])
                redirect actors
            }
            '*' { respond actors, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond actorsService.get(id)
    }

    def update(Actors actors) {
        if (actors == null) {
            notFound()
            return
        }

        try {
            actorsService.save(actors)
        } catch (ValidationException e) {
            respond actors.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'actors.label', default: 'Actors'), actors.id])
                redirect actors
            }
            '*'{ respond actors, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        actorsService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'actors.label', default: 'Actors'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'actors.label', default: 'Actors'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
