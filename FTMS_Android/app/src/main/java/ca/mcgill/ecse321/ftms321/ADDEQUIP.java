package ca.mcgill.ecse321.ftms321;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import ftms.controller.FTMSController;
import ftms.controller.InvalidInputException;

public class ADDEQUIP extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addequip);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
        getMenuInflater().inflate(R.menu.addequi, menu);
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

    public void clickAddEquip(View view) {
        //initialize variables
        String error = "";
        int quantity = 0;
        float price = 0f;
        //get the ids of input box
        TextView equipName = (TextView) findViewById(R.id.equipName);
        TextView equipQuantity = (TextView) findViewById(R.id.equipQuantity);
        TextView equipPrice = (TextView) findViewById(R.id.equipPrice);
        //get the controller
        FTMSController m = new FTMSController();
        //get the equipment name from input box
        String name = equipName.getText().toString();
        //if the inserted quantity is empty, append to error message; otherwise, store the quantity
        if (equipQuantity.getText().toString().length()==0){
            error += " quantity cannot be empty! ";
        }else {
            quantity = Integer.parseInt(equipQuantity.getText().toString());
        }
        //if the inserted price is empty, append to error message; otherwise, store the price
        if (equipPrice.getText().toString().length()==0){
            error += " price cannot be empty! ";
        }else {
            price = Float.parseFloat(equipPrice.getText().toString());
        }
        //if the quantity and price are all inserted, create the equipment and store the equipment to backend
        //catch the error if the name of equipment is not inserted
        if (quantity !=0 && price !=0f) {
            try {
                m.createEquipment(name, quantity, price);
            } catch (InvalidInputException e) {
                error = e.getMessage();
            } catch (Exception e) {
                error = e.getMessage();
            }
        }
        //show the errorMessage in the app frontend
        TextView errorMessage = (TextView) findViewById(R.id.equipError);
        errorMessage.setText(error);
        //if there is no error, go to the EQUIPMENT page to refresh the data
        if(error.length()==0){
            Intent intent = new Intent(this, EQUIPMENT.class);
            startActivity(intent);
        }
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