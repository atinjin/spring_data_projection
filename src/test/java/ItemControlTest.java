import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.ryanjin.example.Application;
import com.ryanjin.example.ItemRepository;
import com.ryanjin.example.ShoppingItem;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static com.jayway.restassured.RestAssured.given;

/**
 * Created by Donghyun Ryan Jin [https://github.com/atinjin]
 * spring_data_projection on 2016. 4. 8..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class ItemControlTest {

    @Autowired
    ItemRepository itemRepository;

    @Value("${local.server.port}")
    int port;


    List<String> names = new ArrayList<>();

    @Before
    public void setUp() {
        // Add items
        for(int i=0; i<5; i++) {
            ShoppingItem item = new ShoppingItem();
            String name = "Mouse_"+i;
            names.add(name);
            item.setName(name);
            item.setDescription("This is a gaming mouse.");
            item.setPrice(10);
            item.setSeller("MouseTech");
            item.setCategory("Computer");
            itemRepository.save(item);
        }

        RestAssured.port = port;
    }

    @Test
    public void getOnlyItemsName() {
        Response response =
        given().
            accept(ContentType.JSON).
        when().
            get("/item-names").
        then().
            statusCode(HttpStatus.SC_OK).
                body("content.name", Matchers.is(names)).
                body("content.category[0]", Matchers.nullValue()).
        extract().response();
        ;

        response.getBody().print();
    }


}
