package theatre

import grails.gorm.services.Service
import java.text.SimpleDateFormat

@Service(Employee)
abstract class EmployeeService {

    abstract Employee get(Serializable id)

    abstract List<Employee> list(Map args)

    List<Employee> listWithParams(Map args){
        Date fromDate = parseDate(args.get("fromDate"))
        Date toDate = parseDate(args.get("toDate"))

        Date fromDate_h = parseDate(args.get("fromDate_h"))
        Date toDate_h = parseDate(args.get("toDate_h"))

        String full_name = args.get("full_name") as String
        if (full_name.toString().empty) {
            full_name = null
        }
        String sex = args.get("sex")
        if (sex.toString().empty) {
            sex = null
        }
        Long fromPoint = null
        if (!args.get("fromPoint").toString().empty) {
            fromPoint = args.get("fromPoint") as Long
        }
        Long toPoint = null
        if (!args.get("toPoint").toString().empty) {
            toPoint = args.get("toPoint") as Long
        }
        if (fromPoint != null && toPoint != null && fromPoint > toPoint) {
            throw new IllegalArgumentException("Kids FROM must be less than or equal Kids TO")
        }
        Long fromPoint_s = null
        if (!args.get("fromPoint_s").toString().empty) {
            fromPoint_s = args.get("fromPoint_s") as Long
        }
        Long toPoint_s = null
        if (!args.get("toPoint_s").toString().empty) {
            toPoint_s = args.get("toPoint_s") as Long
        }
        if (fromPoint_s != null && toPoint_s != null && fromPoint_s > toPoint_s) {
            throw new IllegalArgumentException("Salary FROM must be less than or equal Salary TO")
        }

        return Employee.list(args).findAll {
            (full_name != null && it.full_name == full_name || full_name == null)
        }.findAll {
            (sex != null && it.sex == sex || sex == null)
        }.findAll {
            (fromPoint_s != null && it.salary >= fromPoint_s || fromPoint_s == null)
        }.findAll {
            (toPoint_s != null && it.salary <= toPoint_s || toPoint_s == null)
        }.findAll {
            (fromPoint != null && it.kids >= fromPoint || fromPoint == null)
        }.findAll {
            (toPoint != null && it.kids <= toPoint || toPoint == null)
        }.findAll {
            (fromDate != null && it.birth_date.after(fromDate) || fromDate == null)
        }.findAll {
            (toDate != null && it.birth_date.before(toDate) || toDate == null)
        }.findAll {
            (fromDate_h != null && it.hired.after(fromDate_h) || fromDate_h == null)
        }.findAll {
            (toDate_h != null && it.hired.before(toDate_h) || toDate_h == null)
        }

    }

    abstract Long count()

    abstract void delete(Serializable id)

    abstract Employee save(Employee employee)

    private static Date parseDate(Object stringObject) {
        if (stringObject == null || stringObject.toString().empty) {
            return null
        }
        try {
            String pattern = "yyyy-MM-dd"
            return new SimpleDateFormat(pattern).parse(stringObject.toString())
        } 
        catch(Exception ignored) {
            return null
        }
    }
}