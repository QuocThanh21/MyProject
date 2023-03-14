package in.co.gorest.testdatas;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import in.co.gorest.utils.JsonUtil;
import java.io.FileNotFoundException;

public class UserData {
    private String id;
    private String name;
    private String email;
    private String gender;
    private String status;

    /** ---------------------- Constructor ------------------------ */
    public UserData() {}

    public UserData(String nameOfJsonFile) throws FileNotFoundException {
        UserData userData = covertJsonToObject(nameOfJsonFile);
        this.id = userData.id;
        this.name = userData.name;
        this.email = userData.email;
        this.gender = userData.gender;
        this.status = userData.status;
    }

    /** ---------------------- Methods ------------------------ */
    private UserData covertJsonToObject(String nameOfJsonFile) throws FileNotFoundException {
        JsonUtil jsonUtil = new JsonUtil();
        JsonReader reader = jsonUtil.readJsonFile(nameOfJsonFile);
        Gson gson = new Gson();
        UserData userData = gson.fromJson(reader, UserData.class);
        return userData;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getStatus() {
        return status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
