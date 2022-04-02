$('button.register').click(function() {
	let userName = $("form.register-form input.userName").val();
	let password = $("form.register-form input.password").val();
	let email = $("form.register-form input.email").val();
	let enabled = $("form.register-form input.enabled").val()
	 let userObj = {
		userName: userName,
		lastName: password ,
		email: email,
		enabled: enabled
	};
	$.post("/registration", userObj, function(data) {
		if (data == 'Sucsess') {
			$("form")[0].reset();
			$("form")[1].reset();
		}
	});
});