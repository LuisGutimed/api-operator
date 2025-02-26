package mx.com.system.api.operator.model;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Setter
@Getter
@Document(indexName = "movie-index")
public class Movie implements Serializable {

  private static final long serialVersionUID = 8599497093237275538L;

  @Id
  private String id;

  @Field(type = FieldType.Text)
  private String title;
  @Field(type = FieldType.Text)
  private String genre;
  @Field(type = FieldType.Text)
  private String director;
  @Field(type = FieldType.Text)
  private String description;
  @Field(type = FieldType.Double)
  private double rentPrice;
  @Field(type = FieldType.Text)
  private String coverImageUrl;
  @Field(type = FieldType.Text)
  private String thrillerUrl;


}
