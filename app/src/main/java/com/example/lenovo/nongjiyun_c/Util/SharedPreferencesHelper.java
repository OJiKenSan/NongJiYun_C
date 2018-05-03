package com.example.lenovo.nongjiyun_c.Util;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.content.SharedPreferencesCompat;

import java.util.Map;

public class SharedPreferencesHelper {
    public static  SharedPreferences sharedPreferences;
    public static final String FILE_NAME="shared_data";
    private  static  SharedPreferences.Editor editor;

    public SharedPreferencesHelper(Context context){
               sharedPreferences=context.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
    }
    //存数据
    public  void put(String key,Object object){
        if (object instanceof String) {
            editor.putString(key, (String) object);
        } else if (object instanceof Integer) {
            editor.putInt(key, (Integer) object);
        } else if (object instanceof Boolean) {
            editor.putBoolean(key, (Boolean) object);
        } else if (object instanceof Float) {
            editor.putFloat(key, (Float) object);
        } else if (object instanceof Long) {
            editor.putLong(key, (Long) object);
        } else {
            editor.putString(key, object.toString());
        }
      editor.commit();
    }

    //获取数据
    public Object get(String key, Object defaultObject) {
        if (defaultObject instanceof String) {
            return sharedPreferences.getString(key, (String) defaultObject);
        } else if (defaultObject instanceof Integer) {
            return sharedPreferences.getInt(key, (Integer) defaultObject);
        } else if (defaultObject instanceof Boolean) {
            return sharedPreferences.getBoolean(key, (Boolean) defaultObject);
        } else if (defaultObject instanceof Float) {
            return sharedPreferences.getFloat(key, (Float) defaultObject);
        } else if (defaultObject instanceof Long) {
            return sharedPreferences.getLong(key, (Long) defaultObject);
        } else {
            return sharedPreferences.getString(key, null);
        }
    }
    //移除某个值
    public  void remove(String key) {
        editor.remove(key);
        editor.commit();
    }
    //移除所有值
    public void clear() {
        editor.clear();
        editor.commit();
    }
    //查询某个值是否存在
    public Boolean contain(String key) {
        return sharedPreferences.contains(key);
    }
//
    //返回所有的键值对
    public Map<String, ?> getAll() {
        return sharedPreferences.getAll();
    }


}
