package mx.com.system.api.operator.model;

import java.io.Serial;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Setter
@Getter
@Document(indexName = "item-index")
public class Item implements Serializable {

  @Serial
  private static final long serialVersionUID = 8599497093237275538L;

  @Id
  private String id;

  @Field(type = FieldType.Text)
  private String name;
  @Field(type = FieldType.Text)
  private String description;
  @Field(type = FieldType.Text)
  private String image;
  @Field(type = FieldType.Boolean)
  private boolean status;
  @Field(type = FieldType.Double)
  private double price;

  @Field(type = FieldType.Object)
  private Category category;

}
