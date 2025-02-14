package mx.com.system.api.operator.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import java.io.Serial;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Item implements Serializable {

  @Serial
  private static final long serialVersionUID = 8599497093237275538L;

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  private String name;
  private String description;
  private String image;
  private boolean status;
  private double price;

  @ManyToOne(fetch = FetchType.EAGER)
  private Category category;

  @PrePersist
  protected void onCreate() {
    status = true;
  }

}
