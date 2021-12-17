package org.example.factory.abstractx;


import org.example.factory.abstractx.fastfactory.FastFactory;
import org.example.factory.abstractx.goodfactory.GoodFactory;
import org.example.factory.abstractx.service.AbstractFactory;
import org.example.factory.abstractx.service.HtmlDocument;
import org.example.factory.abstractx.service.WordDocument;

import java.io.IOException;
import java.nio.file.Paths;



public class Main {

	public static void main(String[] args) throws IOException {
		AbstractFactory fastFactory = new FastFactory();
		HtmlDocument fastHtml = fastFactory.createHtml("#Hello\nHello, world!");
		System.out.println(fastHtml.toHtml());
		fastHtml.save(Paths.get(".", "fast.html"));
		WordDocument fastWord = fastFactory.createWord("#Hello\nHello, world!");
		fastWord.save(Paths.get(".", "fast.doc"));

		AbstractFactory goodFactory = new GoodFactory();
		HtmlDocument goodHtml = goodFactory.createHtml("#Hello\nHello, world!");
		System.out.println(goodHtml.toHtml());
		goodHtml.save(Paths.get(".", "good.html"));
		WordDocument goodWord = goodFactory.createWord("#Hello\nHello, world!");
		goodWord.save(Paths.get(".", "good.doc"));
	}
}
