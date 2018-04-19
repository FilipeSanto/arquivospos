package br.edu.unitri.optionsmenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch(id) {
            case R.id.action_item2:
                Intent intent = new Intent(getBaseContext(), CallActivity.class);
                this.startActivity(intent);
                break;
            case R.id.action_item3:
                Intent intent2 = new Intent(this, DialActivity.class);
                this.startActivity(intent2);
                break;
            case R.id.action_item4:
                Intent intent3 = new Intent(this, MailActivity.class);
                this.startActivity(intent3);
                break;
            case R.id.action_item5:
                Intent intent4 = new Intent(this, MapActivity.class);
                this.startActivity(intent4);
                break;
            case R.id.action_item6:
                Intent intent5 = new Intent(this, WebActivity.class);
                this.startActivity(intent5);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;

        //noinspection SimplifiableIfStatement
       // if (id == R.id.action_item2) {

        //    Toast.makeText(getApplicationContext(), "Setting selected", Toast.LENGTH_SHORT).show();
          //  Intent intent = new Intent(this, CallActivity.class);
            //this.startActivity(intent);

       // }

        //return super.onOptionsItemSelected(item);
    }
}


