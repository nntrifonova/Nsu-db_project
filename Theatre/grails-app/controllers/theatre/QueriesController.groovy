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

}	
