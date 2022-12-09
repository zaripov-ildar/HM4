angular.module('store', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8081/store';
    $scope.loadProducts = function () {
        $http.get(contextPath + "/products")
            .then(function (response) {
                $scope.productList = response.data;
            })
    };
    $scope.deleteProduct = function (productId) {
        $http.get(contextPath + "/products/delete/" + productId)
            .then(function () {
                $scope.loadProducts();
            })

    };
    $scope.product = {
        id: -1,
        name: null,
        price: null
    }
    $scope.changePrice = function (productId, delta) {
        $http({
            url: contextPath + '/products/changePrice',
            method: 'GET',
            params: {
                productId: productId,
                delta: delta
            }
        }).then(function (){
            $scope.loadProducts();
        })
    };
    $scope.addProduct = function (product) {
        $http.post(contextPath + "/products/add", JSON.stringify(product))
            .then(function () {
                $scope.loadProducts();
            });
    };

    $scope.loadProducts();
})
;