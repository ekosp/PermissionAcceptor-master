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
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import hp.harsh.permissionacceptor.R;
import hp.harsh.permissionacceptor.fragment.PermissionDemoFragment;
public class FragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        // Replace fragment in frame layout named body_container
        getPermissionFragment();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.body_container);
        if (fragment != null) {
            // return onRequestPermissionsResult() method in respected fragment
            fragment.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    private void getPermissionFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.body_container, new PermissionDemoFragment()).commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(FragmentActivity.this, MainActivity.class));
        finish();
    }
}
