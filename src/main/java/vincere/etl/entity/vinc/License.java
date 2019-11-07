package vincere.etl.entity.vinc;


import javax.persistence.*;

@Entity
@Table(name="license")
public class License {


  @Id
  @Column(name="key")
  private String key;

  @Column(name="value")
  private String value;

  @Column(name="insert_timestamp")
  private java.sql.Timestamp insertTimestamp;


  public String getKey() {
    return this.key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getValue() {
    return this.value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public java.sql.Timestamp getInsertTimestamp() {
    return this.insertTimestamp;
  }

  public void setInsertTimestamp(java.sql.Timestamp insertTimestamp) {
    this.insertTimestamp = insertTimestamp;
  }
}
