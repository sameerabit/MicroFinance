package com.micro.finance.model;

import javax.persistence.*;

/**
 * Created by ssvh on 4/20/16.
 */
@Entity
@IdClass(TransferDetailPK.class)
public class TransferDetail {
    private int fieldOfficerId;
    private int loanId;
    private String reason;

    @Id
    @Column(name = "FieldOfficer_id")
    public int getFieldOfficerId() {
        return fieldOfficerId;
    }

    public void setFieldOfficerId(int fieldOfficerId) {
        this.fieldOfficerId = fieldOfficerId;
    }

    @Id
    @Column(name = "Loan_id")
    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    @Basic
    @Column(name = "Reason")
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransferDetail that = (TransferDetail) o;

        if (fieldOfficerId != that.fieldOfficerId) return false;
        if (loanId != that.loanId) return false;
        if (reason != null ? !reason.equals(that.reason) : that.reason != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fieldOfficerId;
        result = 31 * result + loanId;
        result = 31 * result + (reason != null ? reason.hashCode() : 0);
        return result;
    }
}
