<html>
    <head>
        <title>Welcome to Grails</title>
        <meta name="layout" content="main" />
        <style type="text/css" media="screen">

        #nav {
            margin-top:20px;
            margin-left:30px;
            width:228px;
            float:left;

        }
        .homePagePanel * {
            margin:0px;
        }
        .homePagePanel .panelBody ul {
            list-style-type:none;
            margin-bottom:10px;
        }
        .homePagePanel .panelBody h1 {
            text-transform:uppercase;
            font-size:1.1em;
            margin-bottom:10px;
        }
        .homePagePanel .panelBody {
            background: url(images/leftnav_midstretch.png) repeat-y top;
            margin:0px;
            padding:15px;
        }
        .homePagePanel .panelBtm {
            background: url(images/leftnav_btm.png) no-repeat top;
            height:20px;
            margin:0px;
        }

        .homePagePanel .panelTop {
            background: url(images/leftnav_top.png) no-repeat top;
            height:11px;
            margin:0px;
        }
        h2 {
            margin-top:15px;
            margin-bottom:15px;
            font-size:1.2em;
        }
        #pageBody {
            margin-left:280px;
            margin-right:20px;
        }
        </style>
    </head>
    <body>
        <div id="nav">
            <div class="homePagePanel">
                <div class="panelTop"></div>
                <div class="panelBody">
                    <h1>Application Status</h1>
                    <ul>
                        <li>App version: <g:meta name="app.version"></g:meta></li>
                        <li>Grails version: <g:meta name="app.grails.version"></g:meta></li>
                        <li>Groovy version: ${org.codehaus.groovy.runtime.InvokerHelper.getVersion()}</li>
                        <li>JVM version: ${System.getProperty('java.version')}</li>
                        <li>Controllers: ${grailsApplication.controllerClasses.size()}</li>
                        <li>Domains: ${grailsApplication.domainClasses.size()}</li>
                        <li>Services: ${grailsApplication.serviceClasses.size()}</li>
                        <li>Tag Libraries: ${grailsApplication.tagLibClasses.size()}</li>
                    </ul>
                    <h1>Installed Plugins</h1>
                    <ul>
                        <g:set var="pluginManager"
                               value="${applicationContext.getBean('pluginManager')}"></g:set>

                        <g:each var="plugin" in="${pluginManager.allPlugins}">
                            <li>${plugin.name} - ${plugin.version}</li>
                        </g:each>

                    </ul>
                </div>
                <div class="panelBtm"></div>
            </div>
        </div>
        <div id="pageBody">
            <h1>Welcome to Grails Random</h1>
            <p><b>Using <random:whichRandom/></b></p>
            
            <p><b>Integers</b></p>
            
            <p>Random Integer: <random:nextInteger/></p>
            
            <p>Random Integer (0 - 99): <random:nextInteger ceiling="100"/></p>
  
            <p>Random Integer (1200 - 1500): <random:nextInteger ceiling="1500" floor="1200"/></p>
            
            <p><b>Longs</b></p>
            
            <p>Random Long: <random:nextLong/></p>
            
            <p>Random Long (0 - 4468009000000000000): <random:nextLong ceiling="4468009000000000000"/></p>
            
            <p>Random Long (4468008000000000000 - 4468009000000000000): <random:nextLong ceiling="4468009000000000000" floor="4468008000000000000"/></p>
            
            <p>Random Long (4468008000000000000 - 4468009000000000000): <random:nextLong ceiling="4468009000000000000" floor="4468008000000000000"/></p>
            
            <p><b>Boolean</b></p>
            
            <p>Random Boolean: <random:nextBoolean/></p>
           
            <p><b>List</b></p>
            
            <p>Shuffle List [1,2,3,4,5,6,7,8,9,10]: <random:shuffle list="${[1,2,3,4,5,6,7,8,9,10]}"/></p>
            
            <p>Draw Random [1,2,3,4,5,6,7,8,9,10]: <random:draw list="${[1,2,3,4,5,6,7,8,9,10]}"/></p>
            
            
            <div id="controllerList" class="dialog">
                <h2>Available Controllers:</h2>
                <ul>
                    <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
                        <li class="controller"><g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link></li>
                    </g:each>
                </ul>
            </div>
        </div>
    </body>
</html>
