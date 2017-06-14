package com.omicronrobotics.rafaelszuminski.localify;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by rafaelszuminski on 6/13/17.
 */

public class JsoupParser {
        public JsoupParser() throws IOException {

        }

        public Elements getTestData(String link) throws IOException {
                Document testDoc = Jsoup.connect(link).get();
                Elements newsHeadlines = testDoc.select("#mp-itn b a");
                return newsHeadlines;
        }



}
