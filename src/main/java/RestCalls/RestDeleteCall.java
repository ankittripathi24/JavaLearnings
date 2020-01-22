package RestCalls;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import static io.restassured.RestAssured.given;


public class RestDeleteCall {
    public static void main(String[] args) {

        RestDeleteCall objRDC = new RestDeleteCall();

        objRDC.restPostCallUsingJSON();

    }

    public void restPostCall(){
        /*        int empid = 320800;
        RestAssured.baseURI = "http://restapi.demoqa.com/customer";
        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("FirstName", "A123098");
        requestParams.put("LastName", "B123098");
        requestParams.put("UserName", "AA123098");
        requestParams.put("Password", "BB123098");
        requestParams.put("Email",  "AB123098@gmail.com");

        request.body(requestParams.toJSONString());
        Response response = request.post("/register");

        int statusCode = response.getStatusCode();
        System.out.println(statusCode);
        String successCode = response.jsonPath().get("SuccessCode");
        System.out.println(successCode);
*/

        //Another POST request

        //Rest Call - POST
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        RequestSpecification request = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "A123098");
        requestParams.put("salary", "123098");
        requestParams.put("age", "123098");

        request.body(requestParams.toJSONString());
        Response response = request.post("/create");
        int statusCode = response.getStatusCode();
        System.out.println(statusCode);
        String successCode = response.jsonPath().get("status");
        System.out.println(successCode);


        //Rest Call - DELETE
        int x = 1;
        request.header("Content-Type", "application/json");
        response = request.delete("/delete/"+ x);
        statusCode = response.getStatusCode();
        String jsonString =response.asString();

        System.out.println("response---" +response.asString());
        System.out.println("statusCode---" +statusCode);
        System.out.println("jsonString----" + jsonString);
    }
    public void restPostCallUsingJSON(){

        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        RequestSpecification request = RestAssured.given();
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;

        try (Reader reader = new FileReader("D:\\projects\\PUNE_FW\\AnkitLearning.0.1\\src\\main\\java\\RestCalls\\request.json")) {
            JSONArray msg = (JSONArray) parser.parse(reader);
            System.out.println(msg);
            jsonObject = (JSONObject) msg.get(0);
        }catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


        request.body(jsonObject.toJSONString());
        Response response = request.post("/create");
        int statusCode = response.getStatusCode();
        System.out.println(statusCode);
        String successCode = response.jsonPath().get("status");
        System.out.println(successCode);

    }
}
