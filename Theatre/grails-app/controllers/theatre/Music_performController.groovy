package theatre

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class Music_performController {

    Music_performService music_performService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond music_performService.list(params), model:[music_performCount: music_performService.count()]
    }

    def show(Long id) {
        respond music_performService.get(id)
    }

    def create() {
        respond new Music_perform(params)
    }

    def save(Music_perform music_perform) {
        if (music_perform == null) {
            notFound()
            return
        }

        try {
            music_performService.save(music_perform)
        } catch (ValidationException e) {
            respond music_perform.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'music_perform.label', default: 'Music_perform'), music_perform.id])
                redirect music_perform
            }
            '*' { respond music_perform, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond music_performService.get(id)
    }

    def update(Music_perform music_perform) {
        if (music_perform == null) {
            notFound()
            return
        }

        try {
            music_performService.save(music_perform)
        } catch (ValidationException e) {
            respond music_perform.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'music_perform.label', default: 'Music_perform'), music_perform.id])
                redirect music_perform
            }
            '*'{ respond music_perform, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        music_performService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'music_perform.label', default: 'Music_perform'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'music_perform.label', default: 'Music_perform'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
