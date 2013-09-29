app = angular.module('myapp', ['ngResource']);

function MoviesCtrl($scope, $resource) {
	
	$scope.newMovie = {"director":"","title":""};	
	var movieResource = $resource('/api/v1/catalogue/movies');
			
	$scope.loadMovies = function() {
		$scope.movies = movieResource.get(); //GET movie collection from server	
	};
	
	$scope.addMovie = function() {
		$scope.movies.items.push({director:$scope.newMovie.director,title:$scope.newMovie.title});
		$scope.movies.$save(); //POST updated movie collection to server
		$scope.newMovie.director = '';
		$scope.newMovie.title = '';
	};
}

function BooksCtrl($scope, $resource) {
	
	$scope.newBook = {"author":"","title":""};
	var bookResource = $resource('/api/v1/catalogue/books');
	
	$scope.loadBooks = function() {
		$scope.books = bookResource.get();
	};
	
	$scope.addBook = function() {
		$scope.books.items.push({author:$scope.newBook.author,title:$scope.newBook.title});
		$scope.books.$save();
		$scope.newBook.author = '';
		$scope.newBook.title = '';
	};
}