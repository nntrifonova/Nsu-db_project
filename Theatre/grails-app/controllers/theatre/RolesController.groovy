package theatre

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class RolesController {

    RolesService rolesService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond rolesService.list(params), model:[rolesCount: rolesService.count()]
    }

    def show(Long id) {
        respond rolesService.get(id)
    }

    def create() {
        respond new Roles(params)
    }

    def save(Roles roles) {
        if (roles == null) {
            notFound()
            return
        }

        try {
            rolesService.save(roles)
        } catch (ValidationException e) {
            respond roles.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'roles.label', default: 'Roles'), roles.id])
                redirect roles
            }
            '*' { respond roles, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond rolesService.get(id)
    }

    def update(Roles roles) {
        if (roles == null) {
            notFound()
            return
        }

        try {
            rolesService.save(roles)
        } catch (ValidationException e) {
            respond roles.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'roles.label', default: 'Roles'), roles.id])
                redirect roles
            }
            '*'{ respond roles, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        rolesService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'roles.label', default: 'Roles'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'roles.label', default: 'Roles'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
