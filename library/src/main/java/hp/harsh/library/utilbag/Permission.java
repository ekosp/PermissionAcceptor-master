package hp.harsh.library.utilbag;

/**
 * Created by Harsh on 3/4/2016.
 */
public class Permission {

    // Required for Camera
    public static final String[] PERMISSION_CAMERA = new String[]{"android.permission.CAMERA"};

    // Required for member of Location group
    public static final String[] PERMISSION_FINE_LOCATION = new String[]{"android.permission.ACCESS_FINE_LOCATION"};
    public static final String[] PERMISSION_COARSE_LOCATION = new String[]{"android.permission.ACCESS_COARSE_LOCATION"};

    // Required for member of Calender group
    public static final String[] PERMISSION_READ_CALENDER = new String[]{"android.permission.READ_CALENDAR"};
    public static final String[] PERMISSION_WRITE_CALENDER = new String[]{"android.permission.WRITE_CALENDAR"};

    // Required for member of Contacts group
    public static final String[] PERMISSION_READ_CONTACT = new String[]{"android.permission.READ_CONTACTS"};
    public static final String[] PERMISSION_WRITE_CONTACT = new String[]{"android.permission.WRITE_CALENDAR"};
    public static final String[] PERMISSION_GET_ACCOUNTS = new String[]{"android.permission.GET_ACCOUNTS"};

    // Required for Microphone
    public static final String[] PERMISSION_RECORD_AUDIO = new String[]{"android.permission.RECORD_AUDIO"};

    // Required for member of Phone group
    public static final String[] PERMISSION_READ_PHONE_STATE = new String[]{"android.permission.READ_PHONE_STATE"};
    public static final String[] PERMISSION_CALL_PHONE = new String[]{"android.permission.CALL_PHONE"};
    public static final String[] PERMISSION_READ_CALL_LOG = new String[]{"android.permission.READ_CALL_LOG"};
    public static final String[] PERMISSION_WRITE_CALL_LOG = new String[]{"android.permission.WRITE_CALL_LOG"};
    public static final String[] PERMISSION_USE_SIP = new String[]{"android.permission.USE_SIP"};
    public static final String[] PERMISSION_PROCESS_OUTGOIG_CALL = new String[]{"android.permission.PROCESS_OUTGOING_CALLS"};

    // Required for member of SMS group
    public static final String[] PERMISSION_DEND_SMS = new String[]{"android.permission.SEND_SMS"};
    public static final String[] PERMISSION_RECEIVE_SMS = new String[]{"android.permission.RECEIVE_SMS"};
    public static final String[] PERMISSION_READ_SMS = new String[]{"android.permission.READ_SMS"};
    public static final String[] PERMISSION_RECEIVE_WAP_PUSH = new String[]{"android.permission.RECEIVE_WAP_PUSH"};
    public static final String[] PERMISSION_RECEIVE_MMS = new String[]{"android.permission.RECEIVE_MMS"};

    // Required for member of Storage group
    public static final String[] PERMISSION_READ_EXTERNAL_STORAGE = new String[]{"android.permission.READ_EXTERNAL_STORAGE"};
    public static final String[] PERMISSION_WRITE_EXTERNAL_STORAGE = new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"};
}
