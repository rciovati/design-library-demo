package it.rciovati.designlibrarydemo;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class SnackbarActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_snackbar);

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    final Button button = (Button) findViewById(R.id.show_snackbar_button);
    button.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        Snackbar snackbar = Snackbar.make(button, "Hello!", Snackbar.LENGTH_SHORT);
        snackbar.setAction("Undo", new View.OnClickListener() {
          @Override public void onClick(View v) {
            //Undo clicked
          }
        });
        snackbar.show();
      }
    });
  }
}
