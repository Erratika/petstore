package utils;

import constants.Constants;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class PetUtils {

    public static RequestSpecification findByStatusRequestSpec(String status) {
        return new RequestSpecBuilder()
                .setBaseUri(Constants.BASE_PATH)
                .setBasePath(Constants.PET_FIND_BY_STATUS_PATH)
                .addQueryParam("status", status)
                .build();
    }
}
