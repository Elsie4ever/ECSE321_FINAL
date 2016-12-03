package ca.mcgill.ecse321.ftms321;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
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
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.List;

import ftms.controller.FTMSController;
import ftms.model.Food;
import ftms.model.Manager;
import ftms.model.Staff;

public class STAFFVIEW extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staffview);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // display staff list from backend
        FTMSController pc = new FTMSController();
        TableLayout table;
        try {
            pc.showStaff();
            Manager m = Manager.getInstance();
            List<Staff> stafflist = m.getStaffs();
            table = (TableLayout) findViewById(R.id.table_staff);
            table.setColumnStretchable(0,true);
            table.setColumnStretchable(1,true);
            table.setColumnStretchable(2,true);
            for(int i=0; i<stafflist.size(); i++) {
                String name = stafflist.get(i).getNAME();
                String position = stafflist.get(i).getROLE();
                Log.d("name:",name);
                TableRow row = new TableRow(this);
//                row.setId(100+i);
//                row.setLayoutParams(new TableRow.LayoutParams(
//                        TableRow.LayoutParams.FILL_PARENT,
//                        TableRow.LayoutParams.WRAP_CONTENT));
                View v = new ImageView(getBaseContext());
                ImageView image;
                image = new ImageView(v.getContext());
                image.setImageDrawable(v.getResources().getDrawable(R.drawable.profilepic));
                image.setMaxHeight(30);
                image.setMaxWidth(30);
                row.addView(image);

                TextView label_name = new TextView(this);
                label_name.setText(name);
                label_name.setTextColor(Color.WHITE);

//                    label_name.setPadding(5, 5, 5, 5);
                row.addView(label_name);
                TextView label_position = new TextView(this);
                label_position.setText(position);
                label_position.setTextColor(Color.WHITE);
//                    label_quantity.setPadding(5, 5, 5, 5);
                row.addView(label_position);

//
                Button delete_name = new Button(this);
                delete_name.setText("DELETE");
                delete_name.setId(1000+i);
                delete_name.setPadding(0,0,0,0);
                row.addView(delete_name);

                table.addView(row);

//                TextView food_name = (TextView) findViewById(R.id.textView132);
//                food_name.setText(name);
//                TextView food_quantity = (TextView) findViewById(R.id.textView133);
//                food_quantity.setText(quantity);
//                TextView food_price = (TextView) findViewById(R.id.textView134);
//                food_quantity.setText(Float.toString(price));
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
        getMenuInflater().inflate(R.menu.staffview, menu);
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

    public void clickProfile(View view) {

        Intent intent = new Intent(this, STAFFMAIN.class);
        startActivity(intent);

    }
    public void clickStaff(View view) {

        Intent intent = new Intent(this, STAFFVIEW.class);
        startActivity(intent);

    }

    public void clickFood(View view) {

        Intent intent = new Intent(this, FOOD.class);
        startActivity(intent);

    }

    public void clickEquip(View view) {

        Intent intent = new Intent(this, EQUIPMENT.class);
        startActivity(intent);

    }

    public void clickMenu(View view) {

        Intent intent = new Intent(this, FTMSMENU.class);
        startActivity(intent);

    }

    public void clickOrder(View view) {

        Intent intent = new Intent(this, ORDER.class);
        startActivity(intent);

    }

    public void addStaff(View view) {

        Intent intent = new Intent(this, STAFFADD.class);
        startActivity(intent);

    }


    public void clickStaffmain(View view) {

        Intent intent = new Intent(this, STAFFMAIN.class);
        startActivity(intent);

    }
}
