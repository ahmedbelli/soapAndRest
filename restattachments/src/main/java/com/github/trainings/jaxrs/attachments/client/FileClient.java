package com.github.trainings.jaxrs.attachments.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.ContentDisposition;

public class FileClient {
	private static final String FILE_PATH = "C:/Users/Jose/Desktop/XMLImage.jpg";

	public static void main(String[] args) throws FileNotFoundException {
		WebClient client = WebClient.create("http://localhost:8080/restattachments/services/fileService/upload");
		client.type("multipart/form-data");
		ContentDisposition cd = new ContentDisposition("attachment;filename=XMLImage.jpg");
		Attachment attachment = new Attachment("root", new FileInputStream(new File(FILE_PATH)), cd);
		client.post(attachment);
	}

}
