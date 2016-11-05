package com.hddv;

import com.hddv.value.HDDVFile;
import spark.Spark;

import java.util.List;

public class App {

	public static void main(String[] args) {
        Spark.get("/analyze", (request, response) -> {
            String path = "/Users/caleblewis/downloads/"; // just for testing
            return new Parser().parse(path);
        }, new JsonTransformer<List<HDDVFile>>());
	}
}
