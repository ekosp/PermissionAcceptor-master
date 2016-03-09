package hp.harsh.library.manager;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import hp.harsh.library.utilbag.PermissionUtils;
import hp.harsh.library.R;
import hp.harsh.library.interfaces.PermissionInterface;

/**
 * Created by Harsh on 2/19/2016.
 */
public class PermissionRequest {

    private Activity mTarget;

    private int mPermissionRequestCode;
    private int mNeverAskMessageId, mRetionalMessageId, mErrorMessageId;

    private String[] mRequestedPermission;

    private PermissionInterface mPermissionInterface;

    /**
     * Method that request for permission
     *
     * @param activity              activity
     * @param requestedPermission   permission list
     * @param permissionRequestCode permission code to distinguish from other permission
     * @param retionalMessageId     String resource id for retional message
     * @param errorMessageId        String resource id for error message
     * @param permissionInterface   permission interface
     */
    public PermissionRequest(Activity activity, String[] requestedPermission, int permissionRequestCode, int retionalMessageId, int errorMessageId, int neverAskMessageId, PermissionInterface permissionInterface) {
        mTarget = activity;
        mRequestedPermission = requestedPermission;
        mPermissionRequestCode = permissionRequestCode;
        mRetionalMessageId = retionalMessageId;
        mErrorMessageId = errorMessageId;
        mNeverAskMessageId = neverAskMessageId;
        mPermissionInterface = permissionInterface;
    }

    /**
     * method required for checking permission.
     */
    public void checkPermission() {
        if (PermissionUtils.hasSelfPermissions(mTarget, mRequestedPermission)) {
            mPermissionInterface.onGranted(new PermissionResponse(mPermissionRequestCode));
        } else {
            if (PermissionUtils.shouldShowRequestPermissionRationale(mTarget, mRequestedPermission)) {
                showRationaleDialog(mRetionalMessageId);
            } else {
                ActivityCompat.requestPermissions(mTarget, mRequestedPermission, mPermissionRequestCode);
            }
        }
    }

    /**
     * Method requires for callback of permission result.
     */
    public synchronized void onRequestPermissionsResult(Activity target, int requestCode, int[] grantResults) {
        if (PermissionUtils.getTargetSdkVersion(target) < 23 && !PermissionUtils.hasSelfPermissions(target, mRequestedPermission)) {
            showDeniedError();
            return;
        }
        if (PermissionUtils.verifyPermissions(grantResults)) {
            mPermissionInterface.onGranted(new PermissionResponse(requestCode));
        } else {
            if (!PermissionUtils.shouldShowRequestPermissionRationale(target, mRequestedPermission)) {
                showNeverAskError();
            } else {
                showDeniedError();
            }
        }
    }

    /**
     * Method required to show retionale message.
     */
    private void showRationaleDialog(@StringRes int messageResId) {
        new AlertDialog.Builder(mTarget)
                .setPositiveButton(mTarget.getResources().getString(R.string.allow), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(@NonNull DialogInterface dialog, int which) {
                        ActivityCompat.requestPermissions(mTarget, mRequestedPermission, mPermissionRequestCode);
                    }
                })
                .setNegativeButton(mTarget.getResources().getString(R.string.deny), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(@NonNull DialogInterface dialog, int which) {
                        showDeniedError();
                    }
                })
                .setCancelable(false)
                .setMessage(messageResId)
                .show();
    }

    /**
     * Method required to show error message.
     */
    private void showDeniedError() {
        Toast.makeText(mTarget, mTarget.getResources().getString(mErrorMessageId), Toast.LENGTH_SHORT).show();
    }

    /**
     * Method required to show never ask message.
     */
    private void showNeverAskError() {
        Toast.makeText(mTarget, mTarget.getResources().getString(mNeverAskMessageId), Toast.LENGTH_SHORT).show();
    }
}
