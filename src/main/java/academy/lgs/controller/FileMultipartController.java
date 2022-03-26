package academy.lgs.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import academy.lgs.domain.FileMultipart;
import academy.lgs.dto.MultipartUploadResponse;
import academy.lgs.service.FileMultipartService;

@RestController
public class FileMultipartController {
	
	@Autowired
	FileMultipartService fileMultipartService;

	@PostMapping("/uploadFile")
	public MultipartUploadResponse uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
		FileMultipart fileMultipart = fileMultipartService.storeFile(file);

		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
				.path(fileMultipart.getId()).toUriString();

		return new MultipartUploadResponse(fileMultipart.getFileName(), fileDownloadUri, file.getContentType(),
				file.getSize());
	}

	@GetMapping("/downloadFile/{fileId}")
	public ResponseEntity<Resource> downlaodFile(@PathVariable String fileId) throws FileNotFoundException {
		FileMultipart fileMultipart = fileMultipartService.getFile(fileId);

		return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(fileMultipart.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileMultipart.getFileName() + "\"")
                .body(new ByteArrayResource(fileMultipart.getData()));
	}
}
