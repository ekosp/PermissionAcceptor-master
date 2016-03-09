package hp.harsh.library.interfaces;

import hp.harsh.library.manager.PermissionResponse;

/**
 * Interface used  to allow for continuation of a permission request.
 */
public interface PermissionInterface {

    void onGranted(PermissionResponse permissionResponse);
}
