<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="layout" content="main" />
    <style type="text/css" media="screen">
        #container {
            margin-top:20px;
            margin-left:30px;
            padding:10px;
            background-color: #FBFCD0;
            width:600px;
            border:5px solid #EECD7E;
        }
        #title {
          color: #666666;
          font-family: 'Century Gothic', sans-serif;
          font-size:2em;
          margin:10px;
        }
        textarea {
          width: 90%;
          height: 125px;
          margin: 10px;
        }
        #translation {
          background-color: #FFF3A1;
          border: 4px solid #EECD7E;
          padding: 5px;
        }
        #tab {
          margin: 5px;
          background-color: #EECD7E;
          display: inline;
          padding-left: 5px;
          padding-right: 5px;
          color:#666333;
        }
        #error {
          color:WHITE;
          background-color: RED;
          margin:2px;
          padding:5px;
        }
        
        p {
          margin:5px;
        }
    </style>
    <title>grails-random plugin</title>
  </head>
  <body>
    <g:set var="pluginManager" value="${applicationContext.getBean('pluginManager')}"></g:set>
<div id="container">
  <div id="title">grails-random v<a href="https://github.com/boatmeme/grails-random/tree/${pluginManager?.getGrailsPlugin('random')?.version}">${pluginManager?.getGrailsPlugin('random')?.version}</a></div>
            
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
            
</div>
  </body>
</html>
