package hp.harsh.permissionacceptor.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import hp.harsh.permissionacceptor.R;

/**
 * Created by Harsh on 3/4/2016.
 */
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
