package alpha.eduyy.app.credit.creditRequest.presenter;

import android.support.design.widget.Snackbar;
import android.view.View;

import alpha.eduyy.app.credit.creditRequest.model.CreditRequestModel;

public class CreditRequestPresenter implements ICreditRequestPresenter{

    @Override
    public boolean creditRequest(CreditRequestModel mCreditRequestModel, View view) {
        if(mCreditRequestModel.validateFields()){
            if(mCreditRequestModel.validatePlazo()){
                if(mCreditRequestModel.validateIngresosMayorGastos()){
                    mCreditRequestModel.saveFields();
                    return true;
                }else{
                    setMsg(view,"Los ingresos deben ser mayores a los gastos");
                }
            }else{
                setMsg(view,"El plazo debe ser mayor a 12 y menor a 60");
            }
        }else{
            setMsg(view,"Faltan campos por diligenciar");
        }
        return false;
    }

    private void setMsg(View view, String msg){
        Snackbar.make(view, msg, Snackbar.LENGTH_LONG).show();
    }

}
