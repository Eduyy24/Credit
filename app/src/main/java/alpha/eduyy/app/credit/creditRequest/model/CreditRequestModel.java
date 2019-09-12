package alpha.eduyy.app.credit.creditRequest.model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class CreditRequestModel extends ClienteModel implements ICreditRequest{
    private int plazo;
    private int monto;
    private String tipoCredito;
    SharedPreferences myPreferences;
    SharedPreferences.Editor editor;

    public CreditRequestModel(int ingresos, int gastos, int plazo, int monto, String tipoCredito, Context context) {
        super(ingresos, gastos);
        this.plazo = plazo;
        this.monto = monto;
        this.tipoCredito = tipoCredito;
        this.myPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public CreditRequestModel(Context context) {
        super();
        this.myPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getTipoCredito() {
        return tipoCredito;
    }

    public void setTipoCredito(String tipoCredito) {
        this.tipoCredito = tipoCredito;
    }

    @Override
    public boolean validatePlazo() {
        return this.plazo > 12 && this.plazo < 60;
    }

    @Override
    public boolean validateIngresosMayorGastos() {
        return this.getIngresos()>this.getGastos();
    }

    @Override
    public boolean validateFields() {
        return !(this.tipoCredito==null || this.monto==0 || this.plazo==0 || this.getIngresos()==0 || this.getGastos()==0);
    }

    @SuppressLint("CommitPrefEdits")
    @Override
    public void saveFields() {
        this.editor= myPreferences.edit();
        editor.putString("tipoCredito",this.tipoCredito);
        editor.putInt("ingresos",this.getIngresos());
        editor.putInt("monto",this.monto);
        editor.putInt("plazo",this.plazo);
        editor.putInt("gastos",this.getGastos());

        this.editor.apply();
    }

    @Override
    public void loadFields() {
        this.tipoCredito = myPreferences.getString("tipoCredito","");
        this.monto = myPreferences.getInt("monto",0);
        this.plazo = myPreferences.getInt("plazo",0);
        this.setGastos(myPreferences.getInt("gastos",0));
        this.setIngresos(myPreferences.getInt("ingresos",0));
    }
}
