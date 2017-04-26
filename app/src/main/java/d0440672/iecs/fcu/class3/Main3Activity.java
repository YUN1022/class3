package d0440672.iecs.fcu.class3;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;

public class Main3Activity extends AppCompatActivity {

    EditText inputName;
    Button goBack;
    public static final String KEY_NAME3="KEY_NAME3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
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
        inputName=(EditText)findViewById(R.id.sub3_edit);
        goBack=(Button)findViewById(R.id.back3_btn);
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=inputName.getText().toString();
                Intent intent=new Intent();
                intent.putExtra(KEY_NAME3,name);
                setResult(RESULT_OK,intent);
                finish();
            }
        });

    }

}
