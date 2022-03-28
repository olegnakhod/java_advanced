let studentsObj = null;

$.get('/profile', function(data) {
	if (data !== '') {
		studentsObj = data;
	}
}).done(function() {
	let studentContent = "";
		studentContent += "<p>First name: "+ studentsObj.firstName +"</p>" +
						 "<p>Last name: "+ studentsObj.lastName +"</p>" +
						 "<p>Age: "+ studentsObj.age +"</p>"
$('#studentCards').html(studentContent);
})

$('button.switch').click(function() {
	$('div.show_profile').toggleClass('invisible');
	$('div.registration').toggleClass('invisible');
});

