package it.rciovati.designlibrarydemo;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.EditText;

public class TextInputLayoutActivity extends AppCompatActivity implements View.OnClickListener {

  private EditText mNameEditText;
  private EditText mSurnameEditText;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_text_input_layout);

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    mNameEditText = (EditText) findViewById(R.id.name_edit_text);
    mSurnameEditText = (EditText) findViewById(R.id.surname_text);

    configure(mNameEditText);
    configure(mSurnameEditText);

    Button button = (Button) findViewById(R.id.button);
    button.setOnClickListener(this);
  }

  private void configure(final EditText editText) {

    final ViewParent parent = editText.getParent();

    if (parent instanceof TextInputLayout) {
      editText.addTextChangedListener(new TextWatcher() {

        @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override public void afterTextChanged(Editable editable) {
          ((TextInputLayout) parent).setError(null);
        }
      });
    }
  }

  @Override public void onClick(View view) {

    String name = mNameEditText.getText().toString();
    String surname = mSurnameEditText.getText().toString();

    if (TextUtils.isEmpty(name)) {
      TextInputLayout nameInputLayout = (TextInputLayout) findViewById(R.id.name_input_layout);
      nameInputLayout.setError("Can't be empty!");
    }

    if (TextUtils.isEmpty(surname)) {
      TextInputLayout surnameInputLayout =
          (TextInputLayout) findViewById(R.id.surname_input_layout);
      surnameInputLayout.setError("Can't be empty!");
    }
  }
}
