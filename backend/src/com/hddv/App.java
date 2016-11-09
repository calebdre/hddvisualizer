package com.hddv;

import com.hddv.value.HDDVFile;
import spark.Spark;

import java.util.List;

public class App {

	public static void main(String[] args) {
        Spark.staticFiles.location("/public");

        Spark.get("/analyze", (request, response) -> {
            // for testing because the front-end needs to be able
            // to communicate w/o being rendered by the server
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Content-Type", "application/json");

            // just for testing...also, this is platform independent
            String path = "/Users/" + System.getProperty("user.name") + "/Downloads";
            return new Parser().parse(path);
        }, new JsonTransformer<List<HDDVFile>>());

        System.out.println("Please visit http://localhost:4567");
	}
}
