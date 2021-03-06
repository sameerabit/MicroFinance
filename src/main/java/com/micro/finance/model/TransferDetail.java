package com.micro.finance.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ssvh on 4/20/16.
 */
@Entity
@Table(name="TransferDetail")
public class TransferDetail implements Serializable {
    private String reason;
    private String date;

    private FieldOfficer fieldOfficer;

    @Id
    @ManyToOne
    public FieldOfficer getFieldOfficer() {
        return fieldOfficer;
    }

    public void setFieldOfficer(FieldOfficer fieldOfficer) {
        this.fieldOfficer = fieldOfficer;
    }

    private Loan loan;

    @Id
    @ManyToOne()
    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }


    @Basic
    @Column(name = "Reason")
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }
}
