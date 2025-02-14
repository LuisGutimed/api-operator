package mx.com.system.api.operator.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Promotion implements Serializable {

  @Serial
  private static final long serialVersionUID = -1299074921205373769L;

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  private String name;
  private String description;
  private String image;
  private Date startDate;
  private Date endDate;
  private boolean status;

  @PrePersist
  protected void onCreate() {
    startDate = new Date();
    status = true;
  }

}
