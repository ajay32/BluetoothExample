package com.hackingbuzz.bluetoothexample;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_ENABLE_BT =0;
    private static final int REQUEST_DISCOVERABLE_BT = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tt =(TextView) findViewById(R.id.textView);
        final Button b1 =(Button) findViewById(R.id.button);
        final Button b2 = (Button) findViewById(R.id.button2);
        final Button b3 =(Button) findViewById(R.id.button3);
        final BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
        if(adapter == null) {
            tt.append("device not support");
        }
        b1.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                if(!adapter.isEnabled()) {
                    Intent enableTooth = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(enableTooth, REQUEST_ENABLE_BT);
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(!adapter.isDiscovering()) {
                    Toast.makeText(getApplicationContext(), "Making your Device DISCOVERABLE",Toast.LENGTH_LONG).show();
                    Intent enableTooth2 = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                    startActivityForResult(enableTooth2,REQUEST_DISCOVERABLE_BT);
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                adapter.disable();
                Toast.makeText(getApplicationContext(),"Turning of Bluetooth",Toast.LENGTH_LONG).show();
            }
        });
    }
}
