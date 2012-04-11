package com.testapp.app;
import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;
import android.content.Intent;

public class TabMenu extends TabActivity {
    /** Called when the activity is first created. */
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        TabHost tabHost = getTabHost();       
      
        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("My Closet").setContent(new Intent(this, Gallery.class)));
        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("Add Clothing").setContent(new Intent(this, AddTypeList.class)));
        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("Match").setContent(new Intent(this, MatchClothing.class)));
        tabHost.setCurrentTab(0); 
    }
}