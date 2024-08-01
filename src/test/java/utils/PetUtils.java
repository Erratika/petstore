package utils;

import constants.Constants;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import pojos.Category;
import pojos.Pet;

import java.util.ArrayList;

public class PetUtils {

    public static RequestSpecification findByStatusRequestSpec(String status) {
        return getRequestSpecBuilderWithPath(Constants.PET_FIND_BY_STATUS_PATH)
                .addQueryParam("status", status)
                .build();
    }

    public static RequestSpecification findByStatusNoQueryParamRequestSpec() {
        return getRequestSpecBuilderWithPath(Constants.PET_FIND_BY_STATUS_PATH)
                .build();
    }

    private static RequestSpecBuilder getRequestSpecBuilderWithPath(String path) {
        return new RequestSpecBuilder()
                .setBaseUri(Constants.BASE_PATH)
                .setBasePath(path);
    }

    public static RequestSpecification addPetRequestSpec(Pet pet) {
        return getRequestSpecBuilderWithPath(Constants.PET_PATH)
                .setBody(pet)
                .addHeader("Content-Type", "application/json")
                .build();
    }

    public static RequestSpecification deletePetRequestSpec(long id) {
        return getRequestSpecBuilderWithPath(Constants.SINGLE_PET_PATH)
                .addPathParam("petId", id)
                .build();
    }

    public static Pet getValidPet() {
        Category category = getValidCategory();
        Pet pet = new Pet();
        pet.setId(123456);
        pet.setCategory(category);
        pet.setTags(new ArrayList<>());
        pet.setStatus("pending");
        pet.setPhotoUrls(new ArrayList<>());
        return pet;
    }

    public static Category getValidCategory() {
        Category category = new Category();
        category.setId(7890);
        category.setName("Cats");
        return category;
    }
}
