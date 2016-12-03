package ca.mcgill.ecse321.ftms321;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.List;

import ftms.controller.FTMSController;
import ftms.model.Equipment;
import ftms.model.Food;
import ftms.model.Manager;

public class EQUIPMENT extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //get the controller
        FTMSController pc = new FTMSController();
        //create a tablelayout
        TableLayout table;
        try {
            //call the showEquipment method
            pc.showEquipment();
            //get the manager
            Manager m = Manager.getInstance();
            //get all the equipments from backend
            List<Equipment> equiplist = m.getEquipments();
            //find the tablelayout in frontend in order to create things in it later
            table = (TableLayout) findViewById(R.id.table_equipments);
            table.setColumnStretchable(0,true);
            table.setColumnStretchable(1,true);
            table.setColumnStretchable(2,true);
            //create name, quantity and price in each row, the number of row is same as quantity of equipment the backend has
            for(int i=0; i<equiplist.size(); i++) {
                String name = equiplist.get(i).getNAME();
                int quantity = equiplist.get(i).getQUANTITY();
                float price = equiplist.get(i).getPRICE();
                Log.d("name:",name);
                TableRow row = new TableRow(this);

                TextView label_name = new TextView(this);
                label_name.setText(name);
                label_name.setTextColor(Color.WHITE);

                row.addView(label_name);
                TextView label_quantity = new TextView(this);
                label_quantity.setText(Integer.toString(quantity));
                label_quantity.setTextColor(Color.WHITE);

                row.addView(label_quantity);
                TextView label_price = new TextView(this);
                label_price.setText(Float.toString(price));
                label_price.setTextColor(Color.WHITE);

                row.addView(label_price);

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
        getMenuInflater().inflate(R.menu.equipment, menu);
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
    //onClick method: go to ADDEQUIP page
    public void addEquip(View view) {

        Intent intent = new Intent(this, ADDEQUIP.class);
        startActivity(intent);

    }
    //onClick method: go to FTMSMENU page
    public void clickMenu(View view) {

        Intent intent = new Intent(this, FTMSMENU.class);
        startActivity(intent);

    }
    //onClick method: go to ORDER page
    public void clickOrder(View view) {

        Intent intent = new Intent(this, ORDER.class);
        startActivity(intent);

    }
    //onClick method: go to STAFFMAIN page
    public void clickStaffmain(View view) {

        Intent intent = new Intent(this, STAFFMAIN.class);
        startActivity(intent);

    }
}
