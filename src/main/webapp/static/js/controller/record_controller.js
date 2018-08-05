'use strict';

angular.module('myApp').controller('RecordController', ['$scope', '$filter', 'RecordService', function ($scope, $filter, RecordService) {
    var self = this;
    self.record = {email: '', start: '', startFormated: '', end: '', endFormated: ''};
    self.records = [];
    self.email = '';


    self.submit = submit;
    self.submitSearch = submitSearch;
    self.reset = reset;
    self.searchByEmail = searchByEmail;


    function searchByEmail(email) {
        console.log('Search by email', email);
        RecordService.findByEmail(email)
            .then(
                function (d) {
                    self.records = d;
                },
                function (errResponse) {
                    console.error('Error while fetching Records');
                }
            );
    }

    function createRecord(record) {
        RecordService.createRecord(record)
            .then(
                reset(),
                function (errResponse) {
                    console.error('Error while creating Record');
                }
            );
    }

    function submit() {
        console.log('Saving New Record', self.record);
        createRecord(self.record);
        reset();
    }

    function submitSearch() {
        console.log('Searching records', self.email);
        searchByEmail(self.email);
        reset();
    }


    function reset() {
        self.record = {email: '', start: '', startFormated: '', end: '', endFormated: ''}
        self.email = '';
        $scope.myForm.$setPristine(); //reset Form

    }

}]);
