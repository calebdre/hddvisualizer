package com.hddv;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hddv.value.HDDVFile;
import spark.Spark;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

public class App {

	public static void main(String[] args) {
        Spark.staticFiles.location("/public");

        Spark.before((req, res) -> {
            // for testing because the front-end needs to be able
            // to communicate w/o being rendered by the server
            res.header("Access-Control-Allow-Origin", "*");
            res.header("Content-Type", "application/json");
        });

        Spark.get("/analyze", (request, response) -> {
            // just for testing...also, this is platform independent
            String path = request.queryParams("path");
            return new Parser().parse(path);
        }, new JsonTransformer<List<HDDVFile>>());

        Spark.put("/file/permission", ((request, response) -> {
            String path = request.params("path");
            String permission = request.params("permission");

            FileOperator.changePermission(path, permission);
            return true;
        }));

        Spark.post("/file/delete", (request, response) -> {
            String path = request.queryParams("path");
            FileOperator.delete(path);
            return true;
        });

        Spark.get("/settings", ((request, response) -> {
            String settingsPathName = Util.getUserDataPath() + "/currentSettings.json";
            File settingsFile = new File(settingsPathName);
            if(!settingsFile.exists()){
                return "{}";
            }

            return Util.readFile(settingsFile);
        }));

        Spark.put("/settings", (request, response) -> {
            String settingsPathName = Util.getUserDataPath() + "/currentSettings.json";
            File settingsFile = new File(settingsPathName);
            if(!settingsFile.exists()){
                settingsFile.createNewFile();
            }
            Gson gson = new Gson();
            String settingsUpdateJson = request.queryParams("changed");

            List<Setting> changedSettings = gson.fromJson(settingsUpdateJson, new TypeToken<List<Setting>>(){}.getType());

            PrintWriter printWriter = new PrintWriter(settingsPathName, "UTF-8");
            printWriter.write(gson.toJson(changedSettings));
            printWriter.close();
            return true;
        });

        System.out.println("Please visit http://localhost:4567");
	}
}
