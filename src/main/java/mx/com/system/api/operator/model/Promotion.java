package mx.com.system.api.operator.model;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Setter
@Getter
@Document(indexName = "promotion-index")
public class Promotion implements Serializable {

  @Serial
  private static final long serialVersionUID = -1299074921205373769L;

  @Id
  private String id;

  @Field(type = FieldType.Text)
  private String name;
  @Field(type = FieldType.Text)
  private String description;
  @Field(type = FieldType.Text)
  private String image;
  @Field(type = FieldType.Date)
  private Date startDate;
  @Field(type = FieldType.Date)
  private Date endDate;
  @Field(type = FieldType.Boolean)
  private boolean status;

}
