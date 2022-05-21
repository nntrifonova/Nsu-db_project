package theatre

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PlaysController {
    static scaffold = Plays

    PlaysService playsService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond playsService.list(params), model:[playsCount: playsService.count()]
    }

    def show(Long id) {
        respond playsService.get(id)
    }

    def create() {
        respond new Plays(params)
    }

    def save(Plays plays) {
        if (plays == null) {
            notFound()
            return
        }

        try {
            playsService.save(plays)
        } catch (ValidationException e) {
            respond plays.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'plays.label', default: 'Plays'), plays.id])
                redirect plays
            }
            '*' { respond plays, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond playsService.get(id)
    }

    def update(Plays plays) {
        if (plays == null) {
            notFound()
            return
        }

        try {
            playsService.save(plays)
        } catch (ValidationException e) {
            respond plays.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'plays.label', default: 'Plays'), plays.id])
                redirect plays
            }
            '*'{ respond plays, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        playsService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'plays.label', default: 'Plays'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'plays.label', default: 'Plays'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
