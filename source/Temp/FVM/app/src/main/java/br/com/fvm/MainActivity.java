package br.com.fvm;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "br.com.fvm.MESSAGE";
    public final static String BR_COM_FVM_PREFERENCES= "br.com.fvm.preferences";
    public final static String BR_COM_FVM_NUMBER = "br.com.fvm.number";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view) {

        SharedPreferences preferences = this.getSharedPreferences(BR_COM_FVM_PREFERENCES,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(BR_COM_FVM_NUMBER, 120);
        editor.commit();

        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

}
