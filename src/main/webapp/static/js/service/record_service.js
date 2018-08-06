'use strict';

angular.module('myApp').factory('RecordService', ['$http', '$q', function ($http, $q) {

    var REST_SERVICE_URI_RECORD = 'http://localhost:8080/record/';

    var factory = {
        createRecord: createRecord,
        findByEmail: findByEmail
    };

    return factory;


    function createRecord(record) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI_RECORD, record)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function (errResponse) {
                    console.error('Error while creating Record');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }

    function findByEmail(email) {
        console.log('findByEmail', email);
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI_RECORD + email)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function (errResponse) {
                    console.error('Error while fetching Records');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }

}]);
