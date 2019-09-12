package alpha.eduyy.app.credit.confirmRequest;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import alpha.eduyy.app.credit.MainActivity;
import alpha.eduyy.app.credit.R;
import alpha.eduyy.app.credit.confirmRequest.presenter.ConfirmRequestPresenter;
import alpha.eduyy.app.credit.confirmRequest.view.IConfirmRequestView;
import alpha.eduyy.app.credit.creditRequest.CreditRequestActivity;
import alpha.eduyy.app.credit.creditRequest.model.CreditRequestModel;

public class ConfirmRequest extends AppCompatActivity implements IConfirmRequestView {

    CreditRequestModel creditRequestModel;
    ConfirmRequestPresenter confirmRequestPresenter = new ConfirmRequestPresenter();
    private TextView textMonto;
    private TextView textPlazo;
    private TextView textIngresos;
    private TextView textGastos;
    private Button btnConfirmar;
    private TextView textTipoCredito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_request);
        creditRequestModel = confirmRequestPresenter.loadCreditRequest(ConfirmRequest.this);



        // find Views
        textMonto =  this.findViewById(R.id.text_monto);
        textPlazo =  this.findViewById(R.id.text_plazo);
        textIngresos =  this.findViewById(R.id.text_ingresos);
        textGastos =  this.findViewById(R.id.text_gastos);
        textTipoCredito =  this.findViewById(R.id.text_tipo_credito);
        btnConfirmar =  this.findViewById(R.id.button_confirm);

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Snackbar.make(v, "Solicitud realizada exitosamente", Snackbar.LENGTH_LONG).show();
            }
        });

        setDatosFields();
    }

    @Override
    public void setDatosFields() {
        textMonto.setText(String.valueOf(creditRequestModel.getMonto()));
        textPlazo.setText(String.valueOf(creditRequestModel.getPlazo()));
        textIngresos.setText(String.valueOf(creditRequestModel.getIngresos()));
        textGastos.setText(String.valueOf(creditRequestModel.getGastos()));
        textTipoCredito.setText(String.valueOf(creditRequestModel.getTipoCredito()));
    }
}
