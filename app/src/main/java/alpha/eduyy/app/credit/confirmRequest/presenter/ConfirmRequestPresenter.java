package alpha.eduyy.app.credit.confirmRequest.presenter;


import android.content.Context;

import alpha.eduyy.app.credit.creditRequest.model.CreditRequestModel;

public class ConfirmRequestPresenter implements IConfirmRequestPresenter {

    CreditRequestModel creditRequestModel;
    @Override
    public CreditRequestModel loadCreditRequest(Context context) {
        creditRequestModel= new CreditRequestModel(context);
        creditRequestModel.loadFields();
        return creditRequestModel;
    }
}
