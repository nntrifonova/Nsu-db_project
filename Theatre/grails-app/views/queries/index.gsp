<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'queries.label', default: 'Query')}"/>
    <asset:stylesheet src="application.css"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
    </ul>
</div>

<div id="list-department" class="content scaffold-list" role="main">
    <h1><g:message code="default.list.label" args="[entityName]"/></h1>
</div>

<%-- <div style="margin-left: 40px">
    <div class="fieldcontain required">
        <a href="filteringAndSorting">Filtring and sorting</a>
    </div>
    <div>
        <a class="fieldcontain required" href="groupBy">Group by</a>
    </div>
    <div>
        <a class="fieldcontain required" href="having">Having</a>
    </div>
    <div>
        <a class="fieldcontain required" href="innerJoin">Inner Join</a>
    </div>
    <div>
        <a class="fieldcontain required" href="outerJoin">Outer Join</a>
    </div>
    <div>
        <a class="fieldcontain required" href="subQuery"> Sub Query</a>
    </div>
</div> --%>

<ul class="controller-list">
    <li class="controller-item">
        <a class="fieldcontain required controller-link" href="groupBy">
            <div class="controller-card queries-card">
                                <h2 class="controller-heading">
                                    Group by
                                </h2>
                            </div>
        </a>
    </li>
    <li class="controller-item">
        <a class="fieldcontain required controller-link" href="having">
            <div class="controller-card queries-card">
                                <h2 class="controller-heading">
                                    Having
                                </h2>
                            </div>
        </a>
    </li>
    <li class="controller-item">
        <a class="fieldcontain required controller-link" href="subQuery">
            <div class="controller-card queries-card">
                                <h2 class="controller-heading">
                                    Sub Query
                                </h2>
                            </div>
        </a>
    </li>
    <li class="controller-item">
        <a class="fieldcontain required controller-link" href="filteringAndSorting">
            <div class="controller-card queries-card">
                                <h2 class="controller-heading">
                                    Filtering And Sorting
                                </h2>
                            </div>
        </a>
    </li>
    <li class="controller-item">
        <a class="fieldcontain required controller-link" href="innerJoin">
            <div class="controller-card queries-card">
                                <h2 class="controller-heading">
                                    Inner Join
                                </h2>
                            </div>
        </a>
    </li>
        <li class="controller-item">
        <a class="fieldcontain required controller-link" href="CrossJoin">
            <div class="controller-card queries-card">
                                <h2 class="controller-heading">
                                    Cross Join
                                </h2>
                            </div>
        </a>
    </li>
    <li class="controller-item">
        <a class="fieldcontain required controller-link" href="outerJoin">
            <div class="controller-card queries-card">
                                <h2 class="controller-heading">
                                    Outer Join
                                </h2>
                            </div>
        </a>
    </li>
</ul>
</body>
</html>