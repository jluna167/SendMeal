package frsf.isi.lunaojeda.dam.sendmeal.domain;

import java.util.Objects;

public class TarjetaCredito {
    private int id, digitoVerificación;

    public TarjetaCredito(int digitoVerificación, String numero, String vencimiento) {
        this.id = id;
        this.digitoVerificación = digitoVerificación;
        this.numero = numero;
        this.vencimiento = vencimiento;
    }

    private String numero, vencimiento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDigitoVerificación() {
        return digitoVerificación;
    }

    public void setDigitoVerificación(int digitoVerificación) {
        this.digitoVerificación = digitoVerificación;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(String vencimiento) {
        this.vencimiento = vencimiento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TarjetaCredito that = (TarjetaCredito) o;
        return id == that.id &&
                digitoVerificación == that.digitoVerificación &&
                Objects.equals(numero, that.numero) &&
                Objects.equals(vencimiento, that.vencimiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, digitoVerificación, numero, vencimiento);
    }

    @Override
    public String toString() {
        return "TarjetaCredito{" +
                "id=" + id +
                ", digitoVerificación=" + digitoVerificación +
                ", numero='" + numero + '\'' +
                ", vencimiento='" + vencimiento + '\'' +
                '}';
    }
}
