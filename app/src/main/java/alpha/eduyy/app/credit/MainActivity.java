package alpha.eduyy.app.credit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import alpha.eduyy.app.credit.creditRequest.CreditRequestActivity;

public class MainActivity extends AppCompatActivity {
    Button btnToRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find views
        btnToRequest = this.findViewById(R.id.button_to_request);

        // listeners
        btnToRequest.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,CreditRequestActivity.class));
            }
        });
    }
}
