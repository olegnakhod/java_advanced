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
		$.post("article", product,
			function(data) {
				if (data == 'Success') {
					alert('Success');
				}
			});

	});

$("button.buy-product").click(function() {
	let articleId = jQuery(this).attr("data-article");


	$.post("bucket", { 'articleId': articleId },
		function(data) {
			if (data == 'Success') {
				$('[data-dismiss=modal]').trigger({ type: 'click' });
			}
		});
});
