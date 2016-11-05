package com.hddv;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import spark.ResponseTransformer;

public class JsonTransformer<T> implements ResponseTransformer {

    private Gson gson = new Gson();

    @Override
    public String render(Object model) {
        return gson.toJson(model, new TypeToken<T>(){}.getType());
    }
}
