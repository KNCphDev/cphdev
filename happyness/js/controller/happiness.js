var happinessControllers = angular.module('happinessControllers', []);

happinessControllers.controller('HappinessCtrl', ['$scope', '$http',
    function ($scope, $http) {
        $scope.vote = function (voteValue) {
            $http.post('http://localhost:8080/happiness/vote', '{"voteValue":'+voteValue+'}')
                .success(function(data) {
                    console.log("success: " + data.voteValue + ", " + data.created)
                })
                .error(function() {
                    console.log("error")
                });
        }
    }]);