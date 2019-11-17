package vincere.etl.entity.vinc;


import javax.persistence.*;

@Entity
@Table(name="company_fee_model_amount")
public class CompanyFeeModelAmount {


  @Id
  @Column(name="id")
  private long id;

  @Column(name="company_fee_model_id")
  private long companyFeeModelId;

  @Column(name="amount")
  private double amount;

  @Column(name="invoice_date")
  private java.sql.Timestamp invoiceDate;

  @Column(name="description")
  private String description;

  @Column(name="insert_timestamp")
  private java.sql.Timestamp insertTimestamp;


  public long getId() {
    return this.id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getCompanyFeeModelId() {
    return this.companyFeeModelId;
  }

  public void setCompanyFeeModelId(long companyFeeModelId) {
    this.companyFeeModelId = companyFeeModelId;
  }

  public double getAmount() {
    return this.amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public java.sql.Timestamp getInvoiceDate() {
    return this.invoiceDate;
  }

  public void setInvoiceDate(java.sql.Timestamp invoiceDate) {
    this.invoiceDate = invoiceDate;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public java.sql.Timestamp getInsertTimestamp() {
    return this.insertTimestamp;
  }

  public void setInsertTimestamp(java.sql.Timestamp insertTimestamp) {
    this.insertTimestamp = insertTimestamp;
  }
}