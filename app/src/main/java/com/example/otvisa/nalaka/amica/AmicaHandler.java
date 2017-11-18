package com.example.otvisa.nalaka.amica;

import android.content.Context;

import com.google.gson.Gson;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.Map;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class AmicaHandler {

    private Context context;
    private static final String API_BASE_URL = "http://www.amica.fi/";
    public static final String EMPTY_COMPONENT = "EMPTY COMPONENT";



    public AmicaHandler(Context context) {
        this.context = context;
    }

    public void fetchJson(String kitchenId, Callback<String> callback) {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        Retrofit.Builder builder = new Retrofit.Builder().baseUrl(API_BASE_URL).addConverterFactory(ScalarsConverterFactory.create());

        Retrofit retrofit = builder.client(httpClient.build()).build();
        AmicaClient client = retrofit.create(AmicaClient.class);

        Map<String, String> data = new LinkedHashMap<>();
        data.put("costNumber", kitchenId);
        data.put("language", "fi");

        Call<String> call = client.amicaJSONObject(data);
        call.enqueue(callback);
    }

    public AmicaJsonObject getMealsList(String json) {
        Gson gson = new Gson();
        AmicaJsonObject ajo = gson.fromJson(json, AmicaJsonObject.class);

        return ajo;
//        ArrayList<MealObject> allMeals = new ArrayList<>();
//
//        for(int i = 0; i < ajo.getMenusForDays().size(); i++) {
//            ArrayList<ArrayList<String>> oneDayMeals = new ArrayList<>();
//
//            if(!ajo.getMenusForDays().get(i).getSetMenus().isEmpty()) {
//                for(int j = 0; j < ajo.getMenusForDays().get(i).getSetMenus().size(); j++) {
//                    ArrayList<String> meal = new ArrayList<>();
//
//                    if(!ajo.getMenusForDays().get(i).getSetMenus().get(j).getComponents().isEmpty()) {
//                        for(int z = 0; z < ajo.getMenusForDays().get(i).getSetMenus().get(j).getComponents().size(); z++) {
//                            meal.add(ajo.getMenusForDays().get(i).getSetMenus().get(j).getComponents().get(z));
//                        }
//                        oneDayMeals.add(meal);
//
//                    } else {
//                        meal.add(EMPTY_COMPONENT);
//                        oneDayMeals.add(meal);
//                    }
//                }
//
//            } else {
//                ArrayList<String> meal = new ArrayList<>();
//                meal.add("Ravintola ei tarjoa ruokalistaa tälle päivälle.");
//                oneDayMeals.add(meal);
//            }
//
//            MealObject mo = new MealObject(oneDayMeals, formatDateToCardObject(i));
//            allMeals.add(mo);
//        }
//
//        return allMeals;
    }

    public String formatDateToCardObject(int i) {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM");
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        int day = calendar.get(Calendar.DAY_OF_WEEK) - 2 + i;
        System.out.println(day);
        String weekday = "";

        switch (day) {
            case 6:
                weekday = "SUNNUNTAI";
                break;

            case 0:
                weekday = "MAANANTAI";
                break;

            case 1:
                weekday = "TIISTAI";
                break;

            case 2:
                weekday = "KESKIVIIKKO";
                break;

            case 3:
                weekday = "TORSTAI";
                break;

            case 4:
                weekday = "PERJANTAI";
                break;

            case 5:
                weekday = "LAUANTAI";
                break;
        }

        calendar.add(Calendar.DATE, i);

        return weekday + " " + dateFormat.format(calendar.getTime());
    }
}
