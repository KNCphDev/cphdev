/**
 * Created by kim on 03-10-2014.
 */
var happinessControllers = angular.module('happinessControllers', []);

happinessControllers.controller('HappinessCtrl', ['$scope', '$http',
    function ($scope, $http) {
        $scope.vote = function () {
            $http.post('http://localhost:8080/happiness/vote')
                .success(function(data, status, headers, config) {
                    alert("success" + data + " " + status + " " + headers + " " + config)
                })
                .error(function(data, status, headers, config) {
                    alert("error\n" + data + "\n" + status + "\n" + headers + "\n" + config)
                });
        }

    }]);
