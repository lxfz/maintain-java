package org.example.factory.abstractx.goodfactory;


import org.example.factory.abstractx.service.AbstractFactory;
import org.example.factory.abstractx.service.HtmlDocument;
import org.example.factory.abstractx.service.WordDocument;

public class GoodFactory implements AbstractFactory {

	@Override
	public HtmlDocument createHtml(String md) {
		return new GoodHtmlDocument(md);
	}

	@Override
	public WordDocument createWord(String md) {
		return new GoodWordDocument(md);
	}
}
