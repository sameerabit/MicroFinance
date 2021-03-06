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
public class InstallmentPayment {
    private int id;
    private int loanId;
    private BigDecimal interest;
    private BigDecimal capital;
    private BigDecimal fee;
    private Byte status;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Loan_id")
    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    @Basic
    @Column(name = "interest")
    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    @Basic
    @Column(name = "capital")
    public BigDecimal getCapital() {
        return capital;
    }

    public void setCapital(BigDecimal capital) {
        this.capital = capital;
    }

    @Basic
    @Column(name = "fee")
    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    @Basic
    @Column(name = "status")
    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InstallmentPayment that = (InstallmentPayment) o;

        if (id != that.id) return false;
        if (loanId != that.loanId) return false;
        if (interest != null ? !interest.equals(that.interest) : that.interest != null) return false;
        if (capital != null ? !capital.equals(that.capital) : that.capital != null) return false;
        if (fee != null ? !fee.equals(that.fee) : that.fee != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + loanId;
        result = 31 * result + (interest != null ? interest.hashCode() : 0);
        result = 31 * result + (capital != null ? capital.hashCode() : 0);
        result = 31 * result + (fee != null ? fee.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
