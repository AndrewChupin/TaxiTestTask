package com.example.scope.taxitesttask.controllers;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.example.scope.taxitesttask.R;

/**
 * Created by scope on 31.03.16.
 */
public class TabController {

    private Context context;
    private TabLayout tabLayout;

    public TabController(Context context, TabLayout tabLayout) {
        this.context = context;
        this.tabLayout = tabLayout;
    }


    /**
     * Initialize Tabs Items
     */
    public void setupMainTabLayout() {
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());


        TextView tabOne = (TextView) LayoutInflater.from(context).inflate(R.layout.tab_item, null);
        tabOne.setText("Оплата");
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_pencil_box_outline, 0, 0);
        tabLayout.getTabAt(0).setCustomView(tabOne);

        TextView tabTwo = (TextView) LayoutInflater.from(context).inflate(R.layout.tab_item, null);
        tabTwo.setText("Эконом");
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.economy_car, 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabTwo);

        TextView tabThree = (TextView) LayoutInflater.from(context).inflate(R.layout.tab_item, null);
        tabThree.setText("Комфорт");
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.comfort_car, 0, 0);
        tabLayout.getTabAt(2).setCustomView(tabThree);

        TextView tabFour = (TextView) LayoutInflater.from(context).inflate(R.layout.tab_item, null);
        tabFour.setText("Бизнес");
        tabFour.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.buisnes_car, 0, 0);
        tabLayout.getTabAt(3).setCustomView(tabFour);

        tabLayout.getTabAt(1).select();

    }


}
