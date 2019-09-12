package alpha.eduyy.app.credit.creditRequest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import alpha.eduyy.app.credit.MainActivity;
import alpha.eduyy.app.credit.R;
import alpha.eduyy.app.credit.confirmRequest.ConfirmRequest;
import alpha.eduyy.app.credit.creditRequest.model.CreditRequestModel;
import alpha.eduyy.app.credit.creditRequest.presenter.CreditRequestPresenter;

public class CreditRequestActivity extends AppCompatActivity {

    private EditText editMonto;
    private EditText editPlazo;
    private EditText editIngresos;
    private EditText editGastos;
    private Button   btnSolicitar;
    private RadioGroup opcionesCredito;
    private CreditRequestPresenter creditRequestPresenter = new CreditRequestPresenter();
    private CreditRequestModel creditRequestModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_request);

        // finds Views
        editMonto =  this.findViewById(R.id.editTextMonto);
        editPlazo =  this.findViewById(R.id.editTextPlazo);
        editIngresos =  this.findViewById(R.id.editTextIngresos);
        editGastos = this.findViewById(R.id.editTextGastos);
        btnSolicitar =  this.findViewById(R.id.buttonSolicitar);
        opcionesCredito = this.findViewById(R.id.radio_group_opc_cred);

        //set listeners
        btnSolicitar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String tipoCredito = "";
                if(opcionesCredito.getCheckedRadioButtonId() == R.id.radio_libre_inversion){
                    tipoCredito = "Libre inversión";
                }else if(opcionesCredito.getCheckedRadioButtonId() == R.id.radio_compra_cartera){
                    tipoCredito = "Compra Cartera";
                }

                // inicializo el objeto de la tranzacción
                creditRequestModel = new CreditRequestModel(
                        formatNumber(editIngresos.getText().toString()),
                        formatNumber(editGastos.getText().toString()),
                        formatNumber(editPlazo.getText().toString()),
                        formatNumber(editMonto.getText().toString()),
                        tipoCredito,
                        CreditRequestActivity.this
                );

                // Realizo la transacción, en caso de ser exitosa pasa a confirmación
                if(creditRequestPresenter.creditRequest(creditRequestModel, v)){
                    startActivity(new Intent(CreditRequestActivity.this,ConfirmRequest.class));
                    System.out.print("entro papa");
                }
            }
        });
    }

    // si la conversion a numero falla, retorna 0, de forma que no realize la transacción sin la información correcta
    private int formatNumber(String num){
        try {
            return Integer.parseInt(num);
        }catch (Exception e){
            return 0;
        }
    }
}
