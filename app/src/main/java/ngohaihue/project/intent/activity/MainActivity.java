package ngohaihue.project.intent.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ngohaihue.project.intent.R;

public class MainActivity extends AppCompatActivity {
    private Button btnResult;
    private EditText edtNumberA, edtNumberB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnResult = (Button) findViewById(R.id.btnResult);
        edtNumberA = (EditText) findViewById(R.id.edtNumberA);
        edtNumberB = (EditText) findViewById(R.id.edtNumberB);

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // check if user not input data
                if (!edtNumberA.getText().toString().isEmpty() && !edtNumberB.getText().toString().isEmpty()) {
                    Intent resultIntent = new Intent(MainActivity.this, ResultActivity.class);
                    int a = Integer.parseInt(edtNumberA.getText().toString());
                    int b = Integer.parseInt(edtNumberB.getText().toString());
                    Bundle bundle = new Bundle();
                    bundle.putInt("numberA", a);
                    bundle.putInt("numberB", b);
                    resultIntent.putExtra("package", bundle);
                    startActivity(resultIntent);
                    startActivity(resultIntent);
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng Nhập Số", Toast.LENGTH_SHORT).show();
                }

            }

        });
    }
}
