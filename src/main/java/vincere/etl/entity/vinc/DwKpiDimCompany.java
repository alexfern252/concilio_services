package vincere.etl.entity.vinc;


import javax.persistence.*;

@Entity
@Table(name="dw_kpi_dim_company")
public class DwKpiDimCompany {

  @Id
  @Column(name="company_key")
  private long companyKey;

  @Column(name="open_job")
  private long openJob;


  public long getCompanyKey() {
    return this.companyKey;
  }

  public void setCompanyKey(long companyKey) {
    this.companyKey = companyKey;
  }

  public long getOpenJob() {
    return this.openJob;
  }

  public void setOpenJob(long openJob) {
    this.openJob = openJob;
  }
}