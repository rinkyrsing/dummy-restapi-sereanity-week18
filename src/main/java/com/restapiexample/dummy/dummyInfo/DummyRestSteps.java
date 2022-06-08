package com.restapiexample.dummy.dummyInfo;

import com.restapiexample.dummy.constants.EndPoints;
import com.restapiexample.dummy.constants.model.RestAPIPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;

public class DummyRestSteps {
    @Step("Creating Employee with status : {0}, record: {1}")
    public ValidatableResponse createUser(String status, HashMap<String, Object> createRecord) {
        RestAPIPojo restAPIPojo = new RestAPIPojo();
        restAPIPojo.setStatus(status);
        restAPIPojo.setData(createRecord);
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(restAPIPojo)
                .when()
                .post(EndPoints.CREATE_EMPLOYEE)
                .then();
    }

    @Step("Reading an employee ID : 12")
    public ValidatableResponse readingEmployee() {
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .pathParam("employeeID", 12)
                .when()
                .get(EndPoints.GET_EMPLOYEE_BY_ID)
                .then();
    }
    @Step("Reading an employee ID : 12")
    public ValidatableResponse readingAllEmployee() {
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .when()
                .get(EndPoints.GET_ALL_EMPLOYEE)
                .then();
    }

    @Step("Updating an Employee ID 12")
    public ValidatableResponse updatingEmployee(HashMap<String, Object> createRecord) {
        RestAPIPojo restAPIPojo = new RestAPIPojo();
        restAPIPojo.setData(createRecord);
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .pathParam("employeeID",12)
                .body(restAPIPojo)
                .when()
                .put(EndPoints.UPDATE_EMPLOYEE_BY_ID)
                .then();
    }

    @Step("Deleting an Employee ID 12")
    public ValidatableResponse deletingEmployee() {
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .pathParam("employeeID",12)
                .when()
                .delete(EndPoints.DELETE_EMPLOYEE_BY_ID)
                .then();
    }

}
