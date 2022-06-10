<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <asset:stylesheet src="application.css"/>
    <title>Theatre info</title>
    
</head>
<body>
<content tag="nav">
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Application Status <span class="caret"></span></a>
        <ul class="dropdown-menu">
            <li class="dropdown-item"><a href="#">Environment: ${grails.util.Environment.current.name}</a></li>
            <li class="dropdown-item"><a href="#">App profile: ${grailsApplication.config.grails?.profile}</a></li>
            <li class="dropdown-item"><a href="#">App version:
                <g:meta name="info.app.version"/></a>
            </li>
            <li role="separator" class="dropdown-divider"></li>
            <li class="dropdown-item"><a href="#">Grails version:
                <g:meta name="info.app.grailsVersion"/></a>
            </li>
            <li class="dropdown-item"><a href="#">Groovy version: ${GroovySystem.getVersion()}</a></li>
            <li class="dropdown-item"><a href="#">JVM version: ${System.getProperty('java.version')}</a></li>
            <li role="separator" class="dropdown-divider"></li>
            <li class="dropdown-item"><a href="#">Reloading active: ${grails.util.Environment.reloadingAgentEnabled}</a></li>
        </ul>
    </li>
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Artefacts <span class="caret"></span></a>
        <ul class="dropdown-menu">
            <li class="dropdown-item"><a href="#">Controllers: ${grailsApplication.controllerClasses.size()}</a></li>
            <li class="dropdown-item"><a href="#">Domains: ${grailsApplication.domainClasses.size()}</a></li>
            <li class="dropdown-item"><a href="#">Services: ${grailsApplication.serviceClasses.size()}</a></li>
            <li class="dropdown-item"><a href="#">Tag Libraries: ${grailsApplication.tagLibClasses.size()}</a></li>
        </ul>
    </li>
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Installed Plugins <span class="caret"></span></a>
        <ul class="dropdown-menu dropdown-menu-right">
            <g:each var="plugin" in="${applicationContext.getBean('pluginManager').allPlugins}">
                <li class="dropdown-item"><a href="#">${plugin.name} - ${plugin.version}</a></li>
            </g:each>
        </ul>
    </li>
</content>

<%-- <div class="svg" role="presentation">
    <div class="grails-logo-container">
        <asset:image src="grails-cupsonly-logo-white.svg" class="grails-logo"/>
    </div>
</div> --%>

<div id="content" role="main">
    <div class="container">
        <section class="section-controller">
            <h1 class="section-heading">Welcome to my tasks!</h1>
            <style>
            div.paragraph {
             text-align: center;
            }
         </style>
            <div class="paragraph">
                <p class="section-description">
                    Some like text or something dono
                </p>
            </div>

            <div id="controllers" role="navigation">
                <h2 class="controller-heading">All information:</h2>
                <ul class="controller-list">
                    <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
                        <li class="controller controller-item">
                            <g:link class="controller-link" controller="${c.logicalPropertyName}">
                            <div class="controller-card">
                                <h2 class="controller-heading">
                                    ${c.name}
                                </h2>
                            </div>
                            </g:link>
                        </li>
                    </g:each>
                </ul>
            </div>
        </section>
    </div>
</div>

</body>
</html>
