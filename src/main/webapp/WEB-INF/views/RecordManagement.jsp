<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Time tracking app</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
<body ng-app="myApp" class="ng-cloak">
<div class="generic-container" ng-controller="RecordController as ctrl">
    <div class="panel panel-default">
        <div class="panel-heading"><span class="lead">Insert new time tracking record </span></div>
        <div class="formcontainer">
            <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable">Email</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="ctrl.record.email" name="recordEmail"
                                   class="username form-control input-sm" placeholder="Enter email" required/>
                        </div>
                    </div>
                </div>


                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable">Start</label>
                        <div class="col-md-7">
                            <input class="form-control"
                                   ng-model="ctrl.record.startFormated"
                                   ng-model-options="{ updateOn: 'blur' }"
                                   placeholder="Select a date..."
                                   moment-picker="ctrl.record.start"
                                   format="DD.MM.YYYY HH:mm"
                                   required
                            >
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable">End</label>
                        <div class="col-md-7">
                            <input class="form-control"
                                   ng-model="ctrl.record.endFormated"
                                   ng-model-options="{ updateOn: 'blur' }"
                                   placeholder="Select a date..."
                                   moment-picker="ctrl.record.end"
                                   format="DD.MM.YYYY HH:mm"
                                   required
                            >


                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-actions floatRight">
                        <input type="submit" value="Add" class="btn btn-primary btn-sm">
                    </div>
                </div>
            </form>
        </div>
    </div>

    <div class="panel panel-default">
        <div class="panel-heading"><span class="lead">Search time tracking record </span></div>
        <div class="formcontainer">
            <form ng-submit="ctrl.submitSearch()" name="myForm" class="form-horizontal">

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable">Email</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="ctrl.email" name="searchEmail"
                                   class="username form-control input-sm" placeholder="Enter email" required/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-actions floatRight">
                        <input type="submit" value="Search" class="btn btn-primary btn-sm">
                    </div>
                </div>
            </form>
        </div>
    </div>

    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of time tracking records </span></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Email</th>
                    <th>Start</th>
                    <th>End</th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="r in ctrl.records">
                    <td><span ng-bind="r.email"></span></td>
                    <td><span ng-bind="r.start"></span></td>
                    <td><span ng-bind="r.end"></span></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
<script src="<c:url value='/static/js/app.js' />"></script>
<script src="<c:url value='/static/js/service/record_service.js' />"></script>
<script src="<c:url value='/static/js/controller/record_controller.js' />"></script>

<script src="//cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.6/moment-with-locales.js"></script>
<script src="//cdn.rawgit.com/indrimuska/angular-moment-picker/master/dist/angular-moment-picker.min.js"></script>
<link href="//cdn.rawgit.com/indrimuska/angular-moment-picker/master/dist/angular-moment-picker.min.css"
      rel="stylesheet">


</body>
</html>