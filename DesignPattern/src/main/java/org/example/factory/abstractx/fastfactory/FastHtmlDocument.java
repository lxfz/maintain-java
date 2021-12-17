package org.example.factory.abstractx.fastfactory;

import org.example.factory.abstractx.service.HtmlDocument;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class FastHtmlDocument implements HtmlDocument {

	private String md;

	public FastHtmlDocument(String md) {
		this.md = md;
	}

	@Override
	public String toHtml() {
		return null;
	}

	@Override
	public void save(Path path) throws IOException {
	}
}
