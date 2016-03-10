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

import hp.harsh.permissionacceptor.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnPermissionActivity, mBtnPermissionFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnPermissionActivity = (Button) findViewById(R.id.btnPermissionActivity);
        mBtnPermissionFragment = (Button) findViewById(R.id.btnPermissionFragment);

        mBtnPermissionActivity.setOnClickListener(this);
        mBtnPermissionFragment.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPermissionActivity:
                // Navigate to Permission activity
                navigatePermissionActivity();
                break;
            case R.id.btnPermissionFragment:
                // Navigate to Permission fragment
                navigatePermissionFragment();
                break;
            default:
                break;
        }
    }

    private void navigatePermissionActivity() {
        startActivity(new Intent(MainActivity.this, PermissionDemoActivity.class));
        finish();
    }

    private void navigatePermissionFragment() {
        startActivity(new Intent(MainActivity.this, FragmentActivity.class));
        finish();
    }
}
