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
       /*  def having = {
        def results_1 = Directors.findAll().groupBy {
            it.occupation
        }
        def queryString = "SELECT di.performance_id as perform, ARRAY_AGG(di.director_id) as employees " +
                "FROM Directors_perform di JOIN directors d ON d.id = di.director_id " +
                "GROUP BY di.performance_id HAVING (d.premia >= AVG(d.premia))"
        def c = result_1.createCriteria()
        def result_2 = c.list{gt('premia',avg('premia'))} 
        def sql = new Sql(dataSource as DataSource)
        Map<Performance, List<Directors>> results = new HashMap<Performance, List<Directors>>()
        sql.rows(queryString).each {
            results.put(Performance.findById(it.performance_id), Directors.findAllByIdInList(it.directors as List<Long>))
            println(it)
        }

        render(view: 'having',
                model: [results: result_2, resultCount: result_2.size()])

    }
*/
    def innerJoin = {
        def que = "SELECT Plays.name, Performance.date FROM Plays inner join Performance on (Performance.play_id = Plays.id)" +
         "WHERE Plays.genre like 'drama'"
         def sql = new Sql(dataSource as DataSource)
         List<Performance> results = new ArrayList<Performance>()
        sql.rows(que).each {
            results.add(Performance.findByDate(it.date))

        }

        render(view: 'innerJoin',
                model: [results: results, resultCount: results.size()])
    }
    
    def outerJoin = {
        def queryString = "SELECT e.id FROM Employee e LEFT JOIN Musicians m on m.musician_id = e.id " +
                "WHERE m.instrument is not NULL"
        def sql = new Sql(dataSource as DataSource)
        List<Employee> results = new ArrayList<Employee>()
        sql.rows(queryString).each {
            results.add(Employee.findById(it.id))
        }

        render(view: 'outerJoin',
                model: [results: results, resultCount: results.size()])
    }



    def subQuery = {
        def employees = Employee.listOrderById(order: 'asc')
        def employeeId = params.employee
        if (employeeId == null) {
            render(view: 'subQuery',
                    model: [results    : null,
                            resultCount: null,
                            employees  : employees
                    ])
            return
        }
        def queryString = "SELECT e.id FROM Employee e LEFT JOIN Actors a on a.actor_id = e.id " +
                "WHERE a.age > 30 AND " +
                "e.salary > (SELECT e.salary FROM employee e WHERE e.id = ${employeeId})"
        def sql = new Sql(dataSource as DataSource)
        List<Employee> results = new ArrayList<Employee>()
        sql.rows(queryString).each {
            results.add(Employee.findById(it.id))
        }

        render(view: 'subQuery',
                model: [results    : results,
                        resultCount: results.size(),
                        employees  : employees
                ])
    }

    def CrossJoin = {

        def queryString = " SELECT * FROM (SELECT * FROM Actors a) CROSS JOIN (SELECT r.ceracter, r.height FROM Roles r)" 
               + "WHERE a.height > 160 and r.height > 160 "
        def sql = new Sql(dataSource as DataSource)
        List<Actors> results = new ArrayList<Actors>()
        sql.rows(queryString).each {
            results.add(Actors.findById(it.id))
        }

        render(view: 'CrossJoin',
                model: [results: results, resultCount: results.size()])
    }

    def cte = {

        def queryString = "with CTE as (select play, number_of_free_places from Performance)" +
            "select  play, number_of_free_places from CTE where number_of_free_places > 10 "
        def sql = new Sql(dataSource as DataSource)
        List<Performance> results = new ArrayList<Performance>()
        sql.rows(queryString).each {
            results.add(Performance.findByPlay(it.play))
        }

        render(view: 'cte',
                model: [results: results, resultCount: results.size()])
    }

    def recursiv = {

        def queryString = "with recursive t(n) as ( values (0)  union all " +
               "select salary from employee e where e.salary < 40000) " +
               "select sum(n) from t;"

        def sql = new Sql(dataSource as DataSource)
        List<Employee> results = new ArrayList<Employee>()
        sql.rows(queryString).each {
            results.add(Employee.findBySalary(it.salary))
        }

        render(view: 'recursiv',
                model: [results: results, resultCount: results.size()])
    }


}

