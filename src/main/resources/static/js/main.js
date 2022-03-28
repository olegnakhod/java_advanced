$('button.register').click(function() {
	let firstName = $("form.register-form input.firstName").val();
	let lastName = $("form.register-form input.lastName").val();
	let age = $("form.register-form input.age").val();
	let userObj = {
		firstName: firstName,
		lastName: lastName,
		age: age
	};
	$.post("/registration", userObj, function(data) {
		if (data == 'Sucsess') {
			$("form")[0].reset();
			$("form")[1].reset();
		}
	});
});


let singleUploadForm = document.querySelector('#singleUploadForm');
let singleFileUploadInput = document.querySelector('#singleFileUploadInput');
let singleFileUploadError = document.querySelector('#singleFileUploadError');
let singleFileUploadSuccess = document
	.querySelector('#singleFileUploadSuccess');

function uploadSingleFile(file) {
	let formData = new FormData();
	formData.append("file", file);

	let xhr = new XMLHttpRequest();
	xhr.open("POST", "/uploadFile");

	xhr.onload = function() {
		console.log(xhr.responseText);
		let response = JSON.parse(xhr.responseText);
		if (xhr.status == 200) {
			singleFileUploadError.style.display = "none";
			singleFileUploadSuccess.innerHTML = "<img src='"
					+ response.fileDownloadUri
					+ "' target='_blank'>";
			singleFileUploadSuccess.style.display = "block";
		} else {
			singleFileUploadSuccess.style.display = "none";
			singleFileUploadError.innerHTML = (response && response.message)
					|| "Some Error Occurred";
		}
	}

	xhr.send(formData);
}

singleUploadForm.addEventListener('submit', function(event) {
	let files = singleFileUploadInput.files;
	if (files.length === 0) {
		singleFileUploadError.innerHTML = "Please select a file";
		singleFileUploadError.style.display = "block";
	}
	uploadSingleFile(files[0]);
	event.preventDefault();
}, true);

