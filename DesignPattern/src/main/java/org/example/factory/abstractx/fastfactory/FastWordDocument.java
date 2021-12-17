package org.example.factory.abstractx.fastfactory;


import org.example.factory.abstractx.service.WordDocument;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class FastWordDocument implements WordDocument {

	private String md;

	public FastWordDocument(String md) {
		this.md = md;
	}

	@Override
	public void save(Path path) throws IOException {
	}
}
