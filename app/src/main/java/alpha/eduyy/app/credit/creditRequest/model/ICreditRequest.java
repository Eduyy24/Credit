package alpha.eduyy.app.credit.creditRequest.model;

public interface ICreditRequest {
    boolean validatePlazo();
    boolean validateIngresosMayorGastos();
    boolean validateFields();
    void saveFields();
    void loadFields();
}
