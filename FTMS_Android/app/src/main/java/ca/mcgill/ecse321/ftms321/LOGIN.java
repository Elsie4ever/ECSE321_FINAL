package ca.mcgill.ecse321.ftms321;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

import ftms.controller.FTMSController;
import ftms.controller.InvalidInputException;
import ftms.model.Staff;
import ftms.persistence.HTTPconnector;

public class LOGIN extends AppCompatActivity {

    public static String userID = "";
    public static String position = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    public void clickStaffmain(View view) {
        //initialize the varible
        String error = "";
        //get the input box
        TextView username = (TextView) findViewById(R.id.username);
        TextView password = (TextView) findViewById(R.id.password);
        //get the controller
        FTMSController pc = new FTMSController();
        try{
            //call the log in function in the controller
            pc.login( username.getText().toString(),password.getText().toString());
            //get the user id and position of the log in user
            this.userID = pc.getUserID();
            this.position = pc.getPosition();
            //catch error if the user is invalid
            //catch error if there is no internet connection
        } catch(InvalidInputException e) {
            error = e.getMessage();
        }catch (Exception e) {
            error = e.getMessage();
        }
        //show the error message in the frontend
        TextView errorMessage = (TextView) findViewById(R.id.errorMessage);
        errorMessage.setText(error);
        //if there is no error, go to STAFFMAIN class
        if(error.length()==0){
            Intent intent = new Intent(this, STAFFMAIN.class);
            startActivity(intent);

        }



    }


    public class LoginEvent extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String[] params) {
            String error = "";
            FTMSController pc = new FTMSController();
            try{
                pc.login(params[0], params[1]);
            } catch(InvalidInputException e) {
                error = e.getMessage();
            }catch (Exception e) {
               error = e.getMessage();
            }
            return error;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }
}
