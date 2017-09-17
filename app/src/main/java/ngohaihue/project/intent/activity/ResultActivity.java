package ngohaihue.project.intent.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ngohaihue.project.intent.R;

public class ResultActivity extends AppCompatActivity {
    private Button btnBack;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        btnBack = (Button) findViewById(R.id.btnBack);
        textResult=(TextView) findViewById(R.id.textResult);

        Intent receiverIntent = getIntent();
        Bundle receiverBundle = receiverIntent.getBundleExtra("package");
        int a = receiverBundle.getInt("numberA");
        int b = receiverBundle.getInt("numberB");

        if (a == 0) {
            if (b == 0) {
                textResult.setText("Phương trình vô số nghiệm");

            }else{
                textResult.setText("Phương trình vô nghiệm");
            }
        }else {
            textResult.setText(String.valueOf((float) -b/a));
        }

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBack=new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intentBack);

            }
        });
    }
}
