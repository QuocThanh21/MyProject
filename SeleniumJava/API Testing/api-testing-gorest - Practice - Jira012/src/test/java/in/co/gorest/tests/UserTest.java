package in.co.gorest.tests;

import in.co.gorest.testdatas.UserData;
import in.co.gorest.utils.UserHelper;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.io.FileNotFoundException;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasKey;


//Mỗi endpoint là 1 test suite vì nó có n testcase trong đó,
// tách riêng ra (CreateUserTest, DeleteUserTest, ....) -> Tổng 5 cái

public class UserTest {
    UserHelper userHelper = new UserHelper();
    UserData userData = new UserData("user_data.json");

    public UserTest() throws FileNotFoundException {
    }

    //Nên assert từng dòng cho clear
    @Test (priority = 0)
    public void createNewUserSuccessfully() {
        Response response = userHelper.createNewUser(userData);

        response.then().assertThat().statusCode(200)
                .body("code", equalTo(201))
                .body("data.name", equalTo(userData.getName()))
                .body("data.email", equalTo(userData.getEmail()))
                //Hỏi dev vì s convert chữ hoa cho đầu vào cho các field này
                .body("data.gender", equalToIgnoringCase(userData.getGender()))
                .body("data.status", equalToIgnoringCase(userData.getStatus()));

        String userId = response.jsonPath().getString("data.id");
        userData.setId(userId);
    }

    //trong project thì phải verify đủ user như trong database
    @Test (priority = 1)
    public void getAllUsersSuccessfully() {
        Response response = userHelper.getUsers("");

        response.then().assertThat().statusCode(200)
                .body("code", equalTo(200))
                .body("meta.pagination.total", notNullValue())
                .body("meta.pagination.pages", notNullValue())
                .body("meta.pagination.page", notNullValue())
                .body("meta.pagination.limit", notNullValue())
                .body("data[0]", hasKey("id"))
                .body("data[0]", hasKey("name"))
                .body("data[0]", hasKey("email"))
                .body("data[0]", hasKey("gender"))
                .body("data[0]", hasKey("status"));
    }

    @Test (priority = 2)
    public void getUserDetailsSuccessfully() {
        Response response = userHelper.getUserDetails(userData.getId());

        response.then().assertThat().statusCode(200)
                .body("code", equalTo(200))
                .body("data.name", equalTo(userData.getName()))
                .body("data.email", equalTo(userData.getEmail()))
                .body("data.gender", equalToIgnoringCase(userData.getGender()))
                .body("data.status", equalToIgnoringCase(userData.getStatus()));
    }

    //Cho testcase độc lập, k phụ thuộc nhau -> k nên lấy id của testcase create
    @Test (priority = 3)
    public void updateUserDetailsSuccessfully() {
        //Modify userData
        userData.setName("Thanh Tran");
        userData.setEmail("thanhtran@gmail.com");
        userData.setStatus("inactive");

        Response response = userHelper.updateUserDetails(userData.getId(), userData);

        response.then().assertThat().statusCode(200)
                .body("code", equalTo(200))
                .body("data.name", equalTo(userData.getName()))
                .body("data.email", equalTo(userData.getEmail()))
                .body("data.gender", equalToIgnoringCase(userData.getGender()))
                .body("data.status", equalToIgnoringCase(userData.getStatus()));
    }

    @Test (priority = 4)
    public void verifyUpdateUserJsonSchema() {
        Response response = userHelper.updateUserDetails(userData.getId(), userData);
        userHelper.verifyUpdateUserWithSchema(response, "user_schema.json");
    }

    //K nên phụ thuộc id, nên thêm pre-condition tạo riêng
    @Test (priority = 5)
    public void deleteUserSuccessfully() {
        Response response = userHelper.deleteUser(userData.getId());

        response.then().assertThat().statusCode(200)
                .body("code", equalTo(204))
                .body("meta", nullValue())
                .body("data", nullValue());
    }
}
