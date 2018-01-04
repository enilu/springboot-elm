package cn.enilu.elm.api.utils;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created  on 2018/1/3 0003.
 *
 * @author zt
 */
public class Gsons {
    static Gson gson =  new GsonBuilder()
            .registerTypeAdapter(
                    new TypeToken<TreeMap<String, Object>>(){}.getType(),
                    new JsonDeserializer<TreeMap<String, Object>>() {
                        @Override
                        public TreeMap<String, Object> deserialize(
                                JsonElement json, Type typeOfT,
                                JsonDeserializationContext context) throws JsonParseException {

                            TreeMap<String, Object> treeMap = new TreeMap<>();
                            JsonObject jsonObject = json.getAsJsonObject();
                            Set<Map.Entry<String, JsonElement>> entrySet = jsonObject.entrySet();
                            for (Map.Entry<String, JsonElement> entry : entrySet) {
                                if(entry.getValue() instanceof  JsonPrimitive){
                                    treeMap.put(entry.getKey(), entry.getValue().getAsString());
                                }else {
                                    treeMap.put(entry.getKey(), entry.getValue());
                                }
                            }
                            return treeMap;
                        }
                    }).create();
    public static  TreeMap<String,Object> json2Map(String json){
        return gson.fromJson(json,new TypeToken<TreeMap<String,Object>>(){}.getType());
    }
    public static List<Object> json2List(String json){
        return gson.fromJson(json,new TypeToken<List<Object>>(){}.getType());
    }

}
