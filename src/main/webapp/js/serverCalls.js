$("button.addArticle").click(
	function() {
		let name = $("form.add-form input.nameArticle").val();
		let description = $("form.add-form input.descriptionArticle").val();
		let price = $("form.add-form input.priceArticle").val();

		let product = {
			name: name,
			description: description,
			price: price
		};
		$.post("addArticle", product,
			function(data) {
				if (data == 'Success') {
					alert('Success');
				}
			});

	});