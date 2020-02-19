package com.gb.img_reader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

@SpringBootApplication
public class ImgReaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImgReaderApplication.class, args);
	}

	@Bean
	public ITesseract tesseract() {
		return new Tesseract();
	}

}
