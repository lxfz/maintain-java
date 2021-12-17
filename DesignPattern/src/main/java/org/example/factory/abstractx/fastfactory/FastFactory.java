package org.example.factory.abstractx.fastfactory;

import org.example.factory.abstractx.service.AbstractFactory;
import org.example.factory.abstractx.service.HtmlDocument;
import org.example.factory.abstractx.service.WordDocument;

public class FastFactory implements AbstractFactory {

	@Override
	public HtmlDocument createHtml(String md) {
		return new FastHtmlDocument(md);
	}

	@Override
	public WordDocument createWord(String md) {
		return new FastWordDocument(md);
	}
}
