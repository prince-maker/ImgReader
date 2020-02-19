package com.gb.img_reader.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.TesseractException;

@RestController
public class OcrController {

	@Autowired
	private ITesseract tesseract;

	@PostMapping("/read")
	public String readImage(@RequestParam MultipartFile file) throws IOException, TesseractException {

		// byte[] imageBytes = Base64.getEncoder().encode(file.getBytes());
		ByteArrayInputStream bis = new ByteArrayInputStream(file.getBytes());
		BufferedImage image;
		String content = null;
		image = ImageIO.read(bis);
		tesseract.setDatapath("ImgReader/src/main/resources/tessdata/");
		content = tesseract.doOCR(image);

		System.out.println(content);
		return content;

	}
}
