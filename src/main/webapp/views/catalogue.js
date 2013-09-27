function MoviesCtrl($scope) {
	
	$scope.newMovie = {"director":"","title":""};
			
	$scope.loadMovies = function() {
		$scope.movies = {"name":"My Movies","items":[
		                                             {"director":"Quentin Tarantino","title":"Pulp Fiction"},
		                                             {"director":"Stanley Kubrick","title":"Spartacus"},
		                                             {"director":"Sean Penn","title":"Into the Wild"}],
		                                             "parametricType":"trotterj.catalogue.api.domain.Movie"};		
	};
	
	$scope.addMovie = function() {
		$scope.movies.items.push({director:$scope.newMovie.director,title:$scope.newMovie.title});
		$scope.newMovie.director = '';
		$scope.newMovie.title = '';
	};
}

function BooksCtrl($scope) {
	
	$scope.newBook = {"author":"","title":""};
	
	$scope.loadBooks = function() {
		$scope.books = {"name":"My Books","items":[
		                                           {"title":"The Power of One","author":"Bryce Courtenay"},
		                                           {"title":"One Flew Over the Cuckoo's Nest","author":"Ken Kesey"},
		                                           {"title":"When the lion feeds","author":"Wilbur Smith"}],
		                                           "parametricType":"trotterj.catalogue.api.domain.Book"};
	};
	
	$scope.addBook = function() {
		$scope.books.items.push({author:$scope.newBook.author,title:$scope.newBook.title});
		$scope.newBook.author = '';
		$scope.newBook.title = '';
	};
}