<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'employee.label', default: 'Employee')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
        <style>
            label {
                width: auto;
            }
        </style>
    </head>
    <body onload="initFields">
        <a href="#list-employee" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="list-employee" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:table collection="${employeeList}" />

            <div class="pagination">
                <g:paginate total="${employeeCount ?: 0}" />
            </div>
        </div>
        <form action="index" method="get" name="filters" id="filters">
    <fieldset class="form">
        <div class="fieldcontain required">
            <h4 class="fieldcontain required">Фильтры</h4>
        </div>
        <div style="margin-bottom: 14px">
            <div style="display: inline ;margin-right: 20px;" class="fieldcontain required">
                <label for="fromDate">Birth from</label>
                <input  type="date" id="fromDate" name="fromDate" placeholder="from" value="${params.fromDate}"/>
            </div>

            <div style="display: inline;"  class="fieldcontain required">
                <label style="width: 50px;" for="toDate">Birth to</label>
                <input type="date" id="toDate" name="toDate" placeholder="to" value="${params.toDate}"/>
            </div>
        </div>
        <div style="display: inline; margin-right: 20px;" class="fieldcontain required">
            <label for="fromDate_h">Hired from from</label>
            <input  type="date" id="fromDate_h" name="fromDate_h" placeholder="from" value="${params.fromDate_h}"/>
        </div>

        <div style="display: inline;" class="fieldcontain required">
            <label style="width: 50px;" for="toDate_h">Hired to</label>
            <input type="date" id="toDate_h" name="toDate_h" placeholder="to" value="${params.toDate_h}"/>
        </div>

        <div class="fieldcontain required">
            <label for="full_name">Name</label>
            <input type="text" name="full_name" maxlength="50" id="full_name" value="${params.full_name}">
        </div>

        <div style="margin-bottom: 14px" class="fieldcontain required">
            <label for="sex"> Sex </label>
            <input type="text" name="sex" maxlength="50" id="sex" value="${params.sex}">
        </div>

        <div style="margin-bottom: 14px">
            <div style="display: inline; margin-right: 20px;" class="fieldcontain required">
                <label for="fromPoint_s">Salary from</label>
                <input type="number" name="fromPoint_s" min="0"
                    max="1000000" id="fromPoint_s" value="${params.fromPoint_s}">
            </div>

            <div style="display: inline;" class="fieldcontain required">
                <label style="width: 56px;" for="toPoint_s">Salary to</label>
                <input type="number" name="toPoint_s" value="${params.toPoint_s}"
                    min="0" max="1000000" id="toPoint_s">
            </div>
        </div>

        <div style="display: inline; margin-right: 20px;" class="fieldcontain required">
            <label for="fromPoint">Kids from</label>
            <input type="number" name="fromPoint" min="0"
                   max="15" id="fromPoint" value="${params.fromPoint}">
        </div>

        <div style="display: inline;" class="fieldcontain required">
            <label style="width: 56px;" for="toPoint">Kids to</label>
            <input type="number" name="toPoint" value="${params.toPoint}"
                   min="0" max="15" id="toPoint">
        </div>



        <div class="fieldcontain">
            <input type="button" name="create" class="save" value="Применить" id="create" onclick="validateAndSend()">
            <input type="button" name="reset" value="Сбросить" onclick="resetFilterForm()">
        </div>
    </fieldset>
</form>
<script>
    function resetFilterForm() {
        document.querySelector('#full_name').value = ""
        document.querySelector('#sex').value = ""
        document.querySelector('#fromPoint').value = ""
        document.querySelector('#toPoint').value = ""
        document.querySelector('#fromPoint_s').value = ""
        document.querySelector('#toPoint_s').value = ""
        document.querySelector('#fromDate').value = ""
        document.querySelector('#toDate').value = ""
        document.querySelector('#fromDate_h').value = ""
        document.querySelector('#toDate_h').value = ""
    }
    function validateAndSend() {
        const filters = document.querySelector('#filters')
        const toPoint = filters.toPoint.value
        const fromPoint = filters.fromPoint.value
        if (toPoint !== '' && fromPoint !== '' && parseInt(toPoint) < parseInt(fromPoint)) {
            alert('\'Point from\' должен быть меньше \'Point to\'!')
            return false
        }
        const toPoint_s = filters.toPoint_s.value
        const fromPoint_s = filters.fromPoint_s.value
        if (toPoint_s !== '' && fromPoint_s !== '' && parseInt(toPoint_s) < parseInt(fromPoint_s)) {
            alert('\'Point from\' должен быть меньше \'Point to\'!')
            return false
        }
        const fromDate = document.querySelector('#fromDate').value
        const toDate = document.querySelector('#toDate').value
        if (fromDate !== '' && toDate !== '') {
            var d1 = new Date(fromDate);
            var d2 = new Date(toDate);
            if (d1.getTime() > d2.getTime()) {
                alert('Birth date from должен быть раньше, чем Birth date to!')
                return false
            }
        }
        const fromDate_h = document.querySelector('#fromDate_h').value
        const toDate_h = document.querySelector('#toDate_h').value
        if (fromDate_h !== '' && toDate_h !== '') {
            var d3 = new Date(fromDate_h);
            var d4 = new Date(toDate_h);
            if (d3.getTime() > d4.getTime()) {
                alert('Hired date from должен быть раньше, чем Hired date to!')
                return false
            }
        }
        filters.submit();
    }
</script>
<script>
    setTimeout(initFields, 10)
    function initFields() {
        const http = new XMLHttpRequest();
        http.open();
        http.send();
    }
    function getUrlVars() {
        var vars = {};
        var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function (m, key, value) {
            vars[key] = value;
        });
        return vars;
    }
    function initWorking() {
        const workingSelector = document.querySelector('#working')
        var working = getUrlVars()["working"]
        if (working === undefined) {
            working = -1
        }
        for (var i = 0, len = workingSelector.options.length; i < len; i++) {
            var opt = workingSelector.options[i];
            if (opt.value.toString() === working.toString()) {
                console.log(i)
                workingSelector.selectedIndex = i
                break
            }
        }
    }
    initWorking()
</script>
</body>
</html>