alert('JS is linked to page!');

function Article(id = 1, title = "", authors="", content = "", genre = "", date = 1497484623) {
   	console.log("JavaScript file loaded successfully");
    var self = this;
    self.Id = id;
    self.Title = title;
    self.Authors = authors;
    self.Content = content;
    self.Genre = genre;
    self.Date = date;
    self.Save = function() {
        var settings = {
            url: 'http://localhost/articles/submitJS',
            method: 'POST',
            dataType: "json",
              beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
            }
        };
        var myData = {
			"Id" : self.Id,
            "Title": self.Title,
            "Authors": self.Authors,
            "Content": self.Content,
            "Genre": self.Genre,
            "Date": self.Date
        };
        settings.data = myData;
 
        $.ajax(settings).done(function(article) {
         var myArticle = new Article(article.Id, article.Title, article.Authors,
                article.Content, article.Genre, article.Date);
        });
    };
}



function addArticle(Article) {
    alert('addArticle Activated');
    var settings = {
        url: 'http://localhost/articles/submitJS',
        method: 'POST',
        dataType: "json",
          beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
            }
    };
    var myData = {		
		"Title": Article.Title,     
		"Authors" : Article.Authors,
		"Content": Article.Content,
		"Genre" : Article.Genre,
		"Date": Article.Date 
    };
    settings.data = myData;
 
    $.ajax(settings).done(function(Article) {
        var myArticle = new Article(article.Id, article.Title, article.Authors, article.Content,
            article.Genre, article.Date);
        console.log("Article Created");
    });
}

$(document).ready(function() {

    $(document).on("submit", "#add-Article", function(e) {
        e.preventDefault();
        var title, authors, genre, content;
        title = $("#Title").val();
        director = $("#Authors").val();
        rating = $("#Genre").val();
        notes = $("#Content").val();
        var myArticle = new Article(0, title, authors, genre, content, 1497484623);
        alert(myArticle.Title);
         alert('submit Activated');
        addArticle(myArticle);
        $("#add-Article")[0].reset();
        $("#title").focus();
 
    });

});


 
