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
        def que = "SELECT Plays.name, Performance.date FROM Plays inner join Performance on (Performance.play_id = Plays.id)" +
         "WHERE Plays.genre like 'drama'"
         def sql = new Sql(dataSource as DataSource)
        List<Plays> results = new ArrayList<Plays>()
        sql.rows(que).each {
            results.add(Plays.findByName(it.name))

        }

        render(view: 'innerJoin',
                model: [results: results, resultCount: results.size()])
    }


}

