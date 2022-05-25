package theatre

import groovy.sql.Sql
import javax.sql.DataSource

class QueriesController {
	def dataSource

	def index(){
	}
	def filteringAndSorting = {
        params.salaryFrom = params.salaryFrom ?: 10000
        int salaryFrom = params.salaryFrom as int
        def results = Employee.listOrderByFull_name(order: 'asc').findAll {
            it.salary >= salaryFrom
        }

        render(view: 'filteringAndSorting',
                model: [results: results, salaryFrom: salaryFrom, resultCount: results.size()])
    }

    def groupBy = {
        def results = Directors.findAll().groupBy {
            it.occupation
        }

        render(view: 'groupBy',
                model: [results: results, resultCount: results.size()])
    }
    def innerJoin = {
        List<Musicians> results = new ArrayList<Musicians>()
        Music_perform.list().each {
            results.add(it.musician)
        }

        render(view: 'innerJoin',
                model: [results: results, resultCount: results.size()])
    }


}
