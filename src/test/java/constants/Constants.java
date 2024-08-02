package constants;

import java.util.Map;

public class Constants {
	public static String BASE_PATH = "http://localhost:8080/api/v3";
	public static String PET_PATH = "/pet";
	public static String SINGLE_PET_PATH = "/pet/{petId}";
	public static String PET_FIND_BY_STATUS_PATH = "/pet/findByStatus";
	public static String PET_FIND_BY_TAG_PATH = "/pet/findByTag";
	public static String SINGLE_PET_UPLOAD_IMAGE_PATH = "/pet/{petId}/uploadImage";
	public static String STORE_INVENTORY_PATH = "/store/inventory";
	public static String STORE_ORDER_PATH = "/store/order";
	public static String SINGLE_STORE_ORDER_PATH = "/store/order/{orderId}";
	public static String USER_PATH = "/user";
	public static String USER_CREATE_WITH_LIST_PATH = "/user/createWithList";
	public static String USER_LOGIN_PATH = "/user/login";
	public static String USER_LOGOUT_PATH = "/user/logout";
	public static String SINGLE_USER_PATH = "/user/{username}";
	public static Map<String,String> HEADERS = Map.of("Accept", "application/vnd.github+json");

}
