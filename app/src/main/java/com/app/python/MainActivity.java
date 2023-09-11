package com.app.python;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if( !Python.isStarted() ) {
            Python.start( new AndroidPlatform( getApplicationContext()) );
        }
        Python py = Python.getInstance();
        PyObject module = py.getModule( "my_module" );
        PyObject object=module.callAttr("main");
        Toast.makeText(this, object.toString(), Toast.LENGTH_SHORT).show();



    }
}