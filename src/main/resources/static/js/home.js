class Home{
	constructor(){
		console.log("コンストラクタきました");
		var thisClass = this;

		$(".ajax-search-btn").click(function(e) {
			e.preventDefault();
			var searchWord = $(".search-box").val();
			var criteriaSearchWord = $(".criteria-search-box").val();
			if (criteriaSearchWord) {
				searchWord = criteriaSearchWord;
			}
			thisClass.searchUser(searchWord);
		});

		$('.js-modal-open').on('click',function(){
	        $('.js-modal').fadeIn();
	        return false;
    	});
	    $('.js-modal-close').on('click',function(){
	        $('.js-modal').fadeOut();
	        return false;
	    });
	}

	searchUser(searchWord) {
		console.log("searchUserきました");
		var callback = this.rebuildSearchResult();
		this.ajaxGet(callback, searchWord);
	}

	rebuildSearchResult() {

		return function(data) {
			$(".search-result").empty();
			var searchResult = $(".search-result");
			data.posts.forEach(function(post) {
				var cardDeck = $('<div class="card-deck"></div>').appendTo(searchResult);
				var card = $('<div class="card"></div>').appendTo(cardDeck);
				var cardBody = $('<div class="card-body"></div>').appendTo(card);
				cardBody.append('<h5 class="card-title font-weight-bold">' + post.title + '</h5>');
				cardBody.append('<p class="card-text">' + post.content + '</p>');
				var row = $('<div class="row"></div>').appendTo(cardBody);
				row.append('<p class="card-text mx-3"><small class="text-muted">' + post.createBy + '</small></p>');
				row.append('<p class="card-text"><small class="text-muted">' + post.creationDate + '</small></p>');
				var wrapEditDeleteRow = $('<div class="row py-2"></div>').appendTo(cardBody);
				var editForm = $('<form action="/edit" method="get" class="px-2">').appendTo(wrapEditDeleteRow);
				editForm.append('<input type="submit" value="編集" class="btn btn-outline-primary">');
				var hidden = $('<input type="hidden" name="id">').appendTo(editForm);
				hidden.attr('value', post.id);
				var deleteForm = $('<form action="/delete" method="get" class="px-2">').appendTo(wrapEditDeleteRow);
				deleteForm.append('<input type="submit" value="削除" class="btn btn-outline-danger">');
				var hidden = $('<input type="hidden" name="id">').appendTo(deleteForm);
				hidden.attr('value', post.id);
			});
		}
	}

	ajaxGet(callback, searchWord) {
		console.log("ajaxGetきました");
		$.ajax({
			url: "search",
			type: "Get",
			data: { title: searchWord},
			dataType: "Json",
			timeout: 30000,
			success: function(data) {
				if(callback) {
					console.log("ajax成功しました")
					callback(data);
				}
			},
			error: function(data) {
				console.log("エラーです");
			}
		});
	}

}

