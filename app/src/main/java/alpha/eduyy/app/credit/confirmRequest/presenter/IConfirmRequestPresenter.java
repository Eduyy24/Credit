package alpha.eduyy.app.credit.confirmRequest.presenter;

import android.content.Context;
import android.view.View;

import alpha.eduyy.app.credit.creditRequest.model.CreditRequestModel;

public interface IConfirmRequestPresenter {
    CreditRequestModel loadCreditRequest(Context context);
}
