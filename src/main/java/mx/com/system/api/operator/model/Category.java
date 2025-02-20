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
@Document(indexName = "category-index")
public class Category implements Serializable {


  @Serial
  private static final long serialVersionUID = -2401012312280509003L;
  @Id
  private String id;
  @Field(type = FieldType.Text)
  private String name;
  @Field(type = FieldType.Text)
  private String description;

}
