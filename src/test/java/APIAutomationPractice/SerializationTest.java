package APIAutomationPractice;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;
import pojo.PetStoreCategoryPojo;
import pojo.PetStorePojo;
import pojo.PetStoreTagsPojo;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class SerializationTest {

    @Test
    public void serialization() throws IOException {
        PetStorePojo petStorePojo=new PetStorePojo();//create object to access variable
        PetStoreCategoryPojo petStoreCategoryPojo=new PetStoreCategoryPojo();
        PetStoreTagsPojo petStoreTagsPojo=new PetStoreTagsPojo();
        ObjectMapper objectMapper=new ObjectMapper();//to do serialization (JAVA CODE -> JSON OBJECT)
        File file=new File("src/test/resources/pet.json");//location of serialized json object


        petStorePojo.setName("Queen");//I am assigning new value for variable (Setter)
        petStorePojo.setId(15);
        petStorePojo.setStatus("OnHold");
        petStoreCategoryPojo.setId(99);
        petStoreCategoryPojo.setName("AWESOME");
        petStoreTagsPojo.setId(123);
        petStoreTagsPojo.setName("Jungle");
//        petStorePojo.setTags(petStoreTagsPojo);
        petStorePojo.setCategory(petStoreCategoryPojo);
        objectMapper.writeValue(file,petStorePojo);
    }
}
