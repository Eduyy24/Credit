package alpha.eduyy.app.credit.creditRequest.model;

public class ClienteModel {
    private int ingresos;
    private int gastos;

    public ClienteModel(int ingresos, int gastos) {
        this.ingresos = ingresos;
        this.gastos = gastos;
    }

    public ClienteModel() {
    }

    public int getIngresos() {
        return ingresos;
    }

    public void setIngresos(int ingresos) {
        this.ingresos = ingresos;
    }

    public int getGastos() {
        return gastos;
    }

    public void setGastos(int gastos) {
        this.gastos = gastos;
    }
}
