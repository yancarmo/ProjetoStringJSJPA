//Criação do módulo principal da aplicação
var appVasco = angular.module("appVasco", []);

$scope.clientes=[];

//Criação de Controller
appVasco.controller("indexController", function($scope, $http) {

    $scope.clientes=[];

    $http(method: 'GET', url: 'localhost:8080/clientes')
        .then(function (response) {

            $scope.clientes=response.data;

            console.log(response.data);
            console.log(response.status);

        }, function (response) {

            console.log(response.data);
            console.log(response.status);

        })

})