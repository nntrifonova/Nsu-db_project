package theatre

import groovy.sql.Sql
import javax.sql.DataSource

class QueriesController {
	def dataSource

	def index(){
	}

	def filteringAndSorting = {
		params.salaryFrom = params.salaryFrom ?: 1000
		int salaryFrom = params.salaryFrom as int
		def results = Emloyee.lastOrderByName(order: 'asc').findAll{
			it.salary >= salaryFrom
		}
	}
	render(view: 'filteringAndSorting'), model: [results:results, resultCount:results.size()])
}