/*
* Copyright 2016 Harsh Patel
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package hp.harsh.permissionacceptor.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import hp.harsh.library.interfaces.PermissionInterface;
import hp.harsh.library.manager.PermissionRequest;
import hp.harsh.library.manager.PermissionResponse;
import hp.harsh.library.utilbag.Permission;
import hp.harsh.library.utilbag.PermissionCode;
import hp.harsh.permissionacceptor.R;
public class PermissionDemoActivity extends AppCompatActivity implements View.OnClickListener, PermissionInterface {

    private TextView mTxtTitle;
    private Button mBtnCamera, mBtnLocation, mBtnCameraLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_permission);

        mTxtTitle = (TextView) findViewById(R.id.txtTitle);

        mBtnCamera = (Button) findViewById(R.id.btnCamera);
        mBtnLocation = (Button) findViewById(R.id.btnLocation);
        mBtnCameraLocation = (Button) findViewById(R.id.btnCameraLocation);

        mTxtTitle.setText(getResources().getString(R.string.title_activity));

        mBtnCamera.setOnClickListener(this);
        mBtnLocation.setOnClickListener(this);
        mBtnCameraLocation.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCamera:
                // Check permission for camera
                checkCameraPermission();
                break;
            case R.id.btnLocation:
                // Check permission for location
                checkLocationPermission();
                break;
            case R.id.btnCameraLocation:
                // Check permission for camera and location
                checkCameraPermission();
                checkLocationPermission();
                break;
            default:
                break;
        }
    }

    @Override
    public void onGranted(PermissionResponse permissionResponse) {
        switch (permissionResponse.type) {
            case PermissionCode.CODE_PERMISSION_CAMERA:
                // Camera permission granted, set your logic here
                Toast.makeText(PermissionDemoActivity.this, getResources().getString(R.string.permission_camera_granted), Toast.LENGTH_SHORT).show();
                break;
            case PermissionCode.CODE_PERMISSION_FINE_LOCATION:
                // Location permission granted, set your logic here
                Toast.makeText(PermissionDemoActivity.this, getResources().getString(R.string.permission_location_granted), Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PermissionCode.CODE_PERMISSION_CAMERA:
                // Check granted permission for camera
                new PermissionRequest(PermissionDemoActivity.this,
                        Permission.PERMISSION_CAMERA,
                        PermissionCode.CODE_PERMISSION_CAMERA,
                        R.string.permission_camera_rationale,
                        R.string.permission_camera_denied,
                        R.string.permission_enable_message, this)
                        .onRequestPermissionsResult(PermissionDemoActivity.this, requestCode, grantResults);
                break;
            case PermissionCode.CODE_PERMISSION_FINE_LOCATION:
                // Check granted permission for location
                new PermissionRequest(PermissionDemoActivity.this,
                        Permission.PERMISSION_FINE_LOCATION,
                        PermissionCode.CODE_PERMISSION_FINE_LOCATION, R.string.permission_location_rationale,
                        R.string.permission_location_denied,
                        R.string.permission_enable_message, this)
                        .onRequestPermissionsResult(PermissionDemoActivity.this, requestCode, grantResults);
                break;
        }
    }

    private void checkCameraPermission() {
        new PermissionRequest(PermissionDemoActivity.this,
                Permission.PERMISSION_CAMERA,
                PermissionCode.CODE_PERMISSION_CAMERA,
                R.string.permission_camera_rationale,
                R.string.permission_camera_denied,
                R.string.permission_enable_message, this)
                .checkPermission();
    }

    private void checkLocationPermission() {
        new PermissionRequest(PermissionDemoActivity.this,
                Permission.PERMISSION_FINE_LOCATION,
                PermissionCode.CODE_PERMISSION_FINE_LOCATION,
                R.string.permission_location_rationale,
                R.string.permission_location_denied,
                R.string.permission_enable_message, this)
                .checkPermission();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(PermissionDemoActivity.this, MainActivity.class));
        finish();
    }
}
