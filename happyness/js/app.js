var happinessApp = angular.module('happinessApp', [
    'ngRoute',
    'happinessControllers'
]);

happinessApp.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
            when('/happiness', {
                templateUrl: 'view/happiness.html',
                controller: 'HappinessCtrl'
            }).
            otherwise({
                redirectTo: '/happiness'
            });
    }]);