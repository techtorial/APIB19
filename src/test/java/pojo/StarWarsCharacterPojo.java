package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter @JsonIgnoreProperties(ignoreUnknown = true)
public class StarWarsCharacterPojo {

  private String name;
  private String height;
  private String mass;
  private String hair_color;
  private String skin_color;
  private String eye_color;
  private String birth_year;
  private String gender;
  private String homeworld;
  private List<String> films;
}
