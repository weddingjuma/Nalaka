package com.example.otvisa.nalaka;


import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.otvisa.nalaka.amica.AmicaHandler;
import com.example.otvisa.nalaka.amica.AmicaJsonObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    AmicaJsonObject dataSource;
    Context context;
    boolean veganFilter;

    public RecyclerAdapter(AmicaJsonObject ajo, Context c) {
        dataSource = ajo;
        context = c;
        veganFilter = false;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_main, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setIsRecyclable(false);

        //Some lunchtimes are set to null
        if(dataSource.getMenusForDays().get(position).getLunchTime() != null) {
            holder.weekday.setText(formatDate(position) + "\n(Lounasaika: " +
                   dataSource.getMenusForDays().get(position).getLunchTime() + ")\n");
        } else {
            holder.weekday.setText(formatDate(position) + "\n");
        }

        //Check if current day's menulist is empty (restaurant is closed etc..)
        if(dataSource.getMenusForDays().get(position).getSetMenus().isEmpty()) {
            TextView mainFood = new TextView(context);
            mainFood.setTypeface(null, Typeface.BOLD);
            TextView subFood = new TextView(context);

            mainFood.setText("Ravintola ei tarjoa ruokalistaa tälle päivälle");

            holder.cardLayout.addView(mainFood);
            holder.cardLayout.addView(subFood);

        } else {

            //Go through all meal options for one day
            for (int i = 0; i < dataSource.getMenusForDays().get(position).getSetMenus().size(); i++) {
                TextView mainFood = new TextView(context);
                TextView subFood = new TextView(context);
                TextView price = new TextView(context);
                mainFood.setTypeface(null, Typeface.BOLD);
                price.setTypeface(null, Typeface.BOLD_ITALIC);


                if(veganFilter) {
                    subFood.setAllCaps(true);
                }

                //if (!dataSource.getMenusForDays().get(position).getSetMenus().isEmpty()) { not sure if needed .. ?

                    //Amica has some weird empty component lists in middle of json, so this must be checked!
                    if (!dataSource.getMenusForDays().get(position).getSetMenus().get(i).
                            getComponents().isEmpty()) {

                        mainFood.setText(dataSource.getMenusForDays().get(position).getSetMenus().get(i).
                                getComponents().get(0));

                        //All meal options doesn't have price, so this must be also checked
                        if(dataSource.getMenusForDays().get(position).getSetMenus().get(i).getPrice() != null) {
                            price.setText("" + dataSource.getMenusForDays().get(position).getSetMenus().get(i).getPrice());
                            holder.cardLayout.addView(price);
                        }
                        holder.cardLayout.addView(mainFood);
                        holder.cardLayout.addView(subFood);
                    }

                    //All meal options doesn't have subfood, so once again... this must be checked
                    if (dataSource.getMenusForDays().get(position).getSetMenus().get(i).
                            getComponents().size() > 1) {

                        //If there are subfoods, go through them
                        for (int j = 1; j < dataSource.getMenusForDays().get(position).getSetMenus().get(i).
                                getComponents().size(); j++) {

                            subFood.setText(subFood.getText() + dataSource.getMenusForDays().get(position).
                                    getSetMenus().get(i).getComponents().get(j) + "\n");
                        }
                    }
                }
            }
        }
    //}

    @Override
    public int getItemCount() {
        return dataSource.getMenusForDays().size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView weekday;
        protected LinearLayout cardLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            weekday = itemView.findViewById(R.id.weekday);
            cardLayout = itemView.findViewById(R.id.cardLayout);
        }
    }

    public static String formatDate(int i) {
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
