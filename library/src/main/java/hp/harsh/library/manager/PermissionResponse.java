package hp.harsh.library.manager;

/**
 * Created by Harsh on 2/19/2016.
 */

/**
 * Abstract class is used to store request code. Request code is stored from PermissionRequest class when permission is granted by user.
 * This request code is returned in onGranted() of your calling class.
 */

public class PermissionResponse {

    public int type;

    public PermissionResponse(int type) {
        this.type = type;
    }
}
