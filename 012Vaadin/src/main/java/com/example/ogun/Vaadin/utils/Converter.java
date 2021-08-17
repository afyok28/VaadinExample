package com.example.ogun.Vaadin.utils;

import java.io.ByteArrayInputStream;

import com.vaadin.server.StreamResource;

public class Converter {

	
	public static StreamResource byteToResource(byte[] b,Long id) {
		try {
			StreamResource resource = new StreamResource(() -> new ByteArrayInputStream(b),
					id+".png");
			
			return resource;
		} catch (Exception e) {
			return null;
		}
	}
}
