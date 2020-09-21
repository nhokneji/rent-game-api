package com.dts.rentgameapi;

/**
 * @author Rin-DTS
 */
public interface RentConstant {
    int TOP_PLAY = 1;
    int TOP_NEWEST = 2;
    int TOP_HIRE = 3;
    String SECRET = "rinnhinho";
    long TIME_TOKEN_EXPIRE = 3600000000L;
    String ENPOINT_LOGIN = "/auth/login";
    String ENPOINT_REGISTER = "/auth/register";
    String ENPOINT_MATCH_API = "/api/**";
    String ENPOINT_MATCH_AUTH_API = "/auth/api/**";
    String FACEBOOK_PASSWORD = "rinnhinho";
    int STATUS_CODE_SUCCESS = 0;
    String MSG_SUCCESS = "success";
    int STATUS_CODE_AUTHEN = 401;
    String MSG_AUTHEN = "Token invalidate";
    String TOKEN_NAME = "token";
    int PAGE_SIZE = 3;
    int MIN_LEHGTH_PASSWORD = 6;
    int STATUS_CODE_USERNAME_OR_PASSWORD_INVALID = 30;
    String SORT_ASC = "1";
    String SORT_DESC = "2";
    String FOLDER_UPLOAD = "fileupload";
    public static final int RESULT_ERROR = 0;
    public static final int RESULT_OK = 1;
    public static final int STATUS_APPROVED = 1; // Đã được duyệt
    public static final int STATUS_APPROVING = 0; // Đang chờ duyệt

    public static final int PUBLISH = 1;
    public static final int NOT_PUBLISH = 0;

    public static final int STATUS_ACCOUNT_USING = 1;//game acc
    public static final int STATUS_ACCOUNT_NOT_USE = 0;//game acc

    public static final int ACTION_RENT = 1;
    public static final int ACTION_CHARGE = 2;
    String BASE_FOLDER = System.getProperty("user.home") + java.io.File.separator;
    String CONFIG_FOLDER = BASE_FOLDER + "config" + java.io.File.separator + "rent-game-api" + java.io.File.separator;
    String CONFIG_FILE_NAME = "rent-game-api.xml";
}
