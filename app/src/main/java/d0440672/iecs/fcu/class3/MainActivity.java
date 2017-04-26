package d0440672.iecs.fcu.class3;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_NAME="KEY_NAME";
    EditText submitName;
    Button helloButton;
    Button hiButton;
    final int Activity_name=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        submitName=(EditText)findViewById(R.id.sub_name);
        helloButton=(Button)findViewById(R.id.name_btn);
        helloButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                String name=submitName.getText().toString();
                intent.setClass(MainActivity.this,Main2Activity.class);
                intent.putExtra(KEY_NAME,name);
                submitName.setText("");
                startActivity(intent);
            }
        });
        hiButton=(Button)findViewById(R.id.toPage3_btn);
        hiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(MainActivity.this,Main3Activity.class);
                startActivityForResult(intent,Activity_name);
            }
        });
    }

    protected void onActivityResult(int requestCode,int resultCode,Intent intent){
        if(intent==null){
            return;
        }

        super.onActivityResult(resultCode,resultCode,intent);
        if(requestCode==Activity_name){
            String name=intent.getStringExtra(Main3Activity.KEY_NAME3);
            Toast.makeText(MainActivity.this,name,Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
