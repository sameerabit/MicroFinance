package com.micro.finance.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by ssvh on 4/20/16.
 */
@Entity
public class PaymentDetail {
    private String id;
    private int installmentPaymentId;
    private BigDecimal total;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "InstallmentPayment_id")
    public int getInstallmentPaymentId() {
        return installmentPaymentId;
    }

    public void setInstallmentPaymentId(int installmentPaymentId) {
        this.installmentPaymentId = installmentPaymentId;
    }

    @Basic
    @Column(name = "total")
    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaymentDetail that = (PaymentDetail) o;

        if (installmentPaymentId != that.installmentPaymentId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (total != null ? !total.equals(that.total) : that.total != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + installmentPaymentId;
        result = 31 * result + (total != null ? total.hashCode() : 0);
        return result;
    }
}
