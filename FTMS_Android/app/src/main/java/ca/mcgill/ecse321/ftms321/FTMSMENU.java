package ca.mcgill.ecse321.ftms321;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import ftms.model.Menus;

import java.util.List;

import ftms.controller.FTMSController;
import ftms.model.Food;
import ftms.model.Manager;
import ftms.model.Order;

public class FTMSMENU extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ftmsmenu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //get the controller
        FTMSController pc = new FTMSController();
        //create a tablelayout
        TableLayout table;
        try {
            //call the showMenu method
            pc.showMenu();
            //get the manager
            Manager m = Manager.getInstance();
            //get all the menus from backend
            List<Menus> menulist = m.getMenus();
            //find the tablelayout in frontend in order to create things in it later
            table = (TableLayout) findViewById(R.id.table_menu);
            table.setColumnStretchable(0,true);
            table.setColumnStretchable(1,true);
            table.setColumnStretchable(2,true);
            //create name, price and popularity in each row, the number of row is same as quantity of menu the backend has
            for(int i=0; i<menulist.size(); i++) {
                String name = menulist.get(i).getNAME();
                float price = menulist.get(i).getPRICE();
                int popularity = menulist.get(i).getPOPULARITY();

                TableRow row = new TableRow(this);
                TextView label_name = new TextView(this);
                label_name.setText(name);
                label_name.setTextSize(10);
                label_name.setTextColor(Color.WHITE);

                row.addView(label_name);
                TextView label_price = new TextView(this);
                label_price.setText(Float.toString(price));
                label_price.setTextSize(10);
                label_price.setTextColor(Color.WHITE);

                row.addView(label_price);
                TextView label_popularity = new TextView(this);
                label_popularity.setText(Integer.toString(popularity));
                label_popularity.setTextSize(10);
                label_popularity.setTextColor(Color.WHITE);

                row.addView(label_popularity);

                Button delete_name = new Button(this);
                delete_name.setText("DELETE");
                delete_name.setId(1000+i);
                delete_name.setPadding(0,0,0,0);
                row.addView(delete_name);

                table.addView(row);

            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.ftmsmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    //onClick method: go to STAFFVIEW page
    public void clickStaff(View view) {

        Intent intent = new Intent(this, STAFFVIEW.class);
        startActivity(intent);

    }
    //onClick method: go to FOOD page
    public void clickFood(View view) {

        Intent intent = new Intent(this, FOOD.class);
        startActivity(intent);

    }
    //onClick method: go to EQUIPMENT page
    public void clickEquip(View view) {

        Intent intent = new Intent(this, EQUIPMENT.class);
        startActivity(intent);

    }
    //onClick method: go to FTMSMENU page
    public void clickMenu(View view) {

        Intent intent = new Intent(this, FTMSMENU.class);
        startActivity(intent);

    }
    //onClick method: go to ADDMENU page
    public void addMenu(View view) {

        Intent intent = new Intent(this, ADDMENU.class);
        startActivity(intent);

    }
    //onClick method: go to ORDER page
    public void clickOrder(View view) {

        Intent intent = new Intent(this, ORDER.class);
        startActivity(intent);

    }
    //onClick method: go to MENU_RECIPE page
    public void viewRecipe(View view) {

        Intent intent = new Intent(this, MENU_RECIPE.class);
        startActivity(intent);

    }
    //onClick method: go to STAFFMAIN page
    public void clickStaffmain(View view) {

        Intent intent = new Intent(this, STAFFMAIN.class);
        startActivity(intent);

    }
}
