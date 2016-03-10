# PermissionAcceptor-master

PermissionAcceptor allows to handle runtime permission in Marshmallow(Android 6.0)

Runtime permission is necessary from Marshmallow. It is also very good for users but for developer, it is quite monotonous. Sometime it is repetitive task for developer.
 
This simple and fast library carries all the boring task.

# How to use

Here is some simple step to follow

# 1. Request Permission
<pre>
Library includes all required permission. Just make permission request with adding "Permission", "PermissionCode" and few other parameters.

For example,

new PermissionRequest(MainActivity.this,
                Permission.PERMISSION_CAMERA,
                PermissionCode.CODE_PERMISSION_CAMERA,
                R.string.permission_camera_rationale,
                R.string.permission_camera_denied,
                R.string.permission_enable_message, this)
                .checkPermission();
</pre>
# 2. Add onRequestPermissionsResult() method for Callback
<pre>
onRequestPermissionsResult() is necessary to get Callback of permission result

You should add like,

@Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PermissionCode.CODE_PERMISSION_CAMERA:
                // Check granted permission for camera
                new PermissionRequest(MainActivity.this,
                        Permission.PERMISSION_CAMERA,
                        PermissionCode.CODE_PERMISSION_CAMERA,
                        R.string.permission_camera_rationale,
                        R.string.permission_camera_denied,
                        R.string.permission_enable_message, this)
                        .onRequestPermissionsResult(MainActivity.this, requestCode, grantResults);
                break;
            case PermissionCode.CODE_PERMISSION_FINE_LOCATION:
                // Check granted permission for location
                new PermissionRequest(MainActivity.this,
                        Permission.PERMISSION_FINE_LOCATION,
                        PermissionCode.CODE_PERMISSION_FINE_LOCATION, R.string.permission_location_rationale,
                        R.string.permission_location_denied,
                        R.string.permission_enable_message, this)
                        .onRequestPermissionsResult(MainActivity.this, requestCode, grantResults);
                break;
        }
    }
</pre>            
# 3. Getting Response from Permission
<pre>
If permission is granted by user, you will be notify in OnGranted().

For example,

@Override
    public void onGranted(PermissionResponse permissionResponse) {
        switch (permissionResponse.type) {
            case PermissionCode.CODE_PERMISSION_CAMERA:
                // Camera permission granted, set your logic here
                Toast.makeText(MainActivity.this, getResources().getString(R.string.permission_camera_granted), Toast.LENGTH_SHORT).show();
                break;
            case PermissionCode.CODE_PERMISSION_FINE_LOCATION:
                // Location permission granted, set your logic here
                Toast.makeText(MainActivity.this, getResources().getString(R.string.permission_location_granted), Toast.LENGTH_SHORT).show();
                break;
        }
    }
</pre>

# Working with Fragment

PermissionAcceptor is also working with Fragment. You can use this with <b>android.app.Fragment</b> and <b>android.support.v4.app.Fragment</b>.

To work with Fragment just simply follow all above steps and also add few lines of code in your Fragment parent activity.

<pre>
@Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.body_container);
        if (fragment != null) {
            // return onRequestPermissionsResult() method in respected fragment
            fragment.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
</pre>

# Download

To integrate it into your project, add library to your project and include following in your project build.gradle file
<pre>
dependencies {
    compile project(':library')
}
</pre>

# Licence

Copyright 2016 Harsh Patel

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

<p>&#09;http://www.apache.org/licenses/LICENSE-2.0</p>

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

