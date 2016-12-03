package ca.mcgill.ecse321.ftms321;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutCompat;
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
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import ftms.controller.FTMSController;
import ftms.model.Food;
import ftms.model.Manager;
import ftms.model.Schedule;
import ftms.model.Staff;

public class STAFFMAIN extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staffmain);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        // display login staff's information and schedule from backend
        TableLayout table;
        try{
            FTMSController pc = new FTMSController();
            Log.d("staff id is:",LOGIN.userID);
            Manager m = Manager.getInstance();
            pc.setUserID(LOGIN.userID);
            table = (TableLayout) findViewById(R.id.table_schedule);
            table.setColumnStretchable(0,true);
            Staff staff=pc.showProfile();
            List<Schedule> schedule=staff.getSchedules();

            TextView staffName = (TextView) findViewById(R.id.textView136);
            TextView staffGender = (TextView) findViewById(R.id.textView138);
            TextView staffAge = (TextView) findViewById(R.id.textView132);
            TextView staffID = (TextView) findViewById(R.id.textView133);
            TextView staffPosition = (TextView) findViewById(R.id.textView134);
            TextView staffNum = (TextView) findViewById(R.id.textView135);
            staffName.setText(staff.getNAME());
            staffGender.setText(staff.getGENDER());
            staffAge.setText(Integer.toString(staff.getAGE()));
            staffID.setText(staff.getID());
            staffPosition.setText(staff.getROLE());
            staffNum.setText(Long.toString(staff.getTEL()));

            for(int i=0;i<schedule.size();i++){
                String getSchedule="Start time: " + schedule.get(i).getSTART_TIME()+", \nEnd time: "+schedule.get(i).getEND_TIME()+"\n";
                TableRow row = new TableRow(this);

                TextView label_schedule = new TextView(this);
                label_schedule.setText(getSchedule);
                label_schedule.setTextSize(12);
                label_schedule.setGravity(1);
                label_schedule.setTextColor(Color.WHITE);


                row.addView(label_schedule);
                table.addView(row);
            }
        }catch(Exception e){
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
        getMenuInflater().inflate(R.menu.staffmain, menu);
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

    public void clickStaffmain(View view) {
        Intent intent = new Intent(this, STAFFMAIN.class);
        startActivity(intent);


    }
}
