package org.example.factory.abstractx.goodfactory;

import org.example.factory.abstractx.service.WordDocument;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class GoodWordDocument implements WordDocument {

	private String md;

	public GoodWordDocument(String md) {
		this.md = md;
	}

	@Override
	public void save(Path path) throws IOException {
	}
}
