package org.example.factory.abstractx.goodfactory;

import org.example.factory.abstractx.service.HtmlDocument;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class GoodHtmlDocument implements HtmlDocument {

	private String md;

	public GoodHtmlDocument(String md) {
		this.md = md;
	}

	@Override
	public String toHtml() {
		return "html";
	}

	@Override
	public void save(Path path) throws IOException {
		Files.write(path, toHtml().getBytes("UTF-8"));
	}
}
