package me.kentin.fbtvloginsample;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.DeviceLoginButton;

public class LoginActivity extends Activity {

    private DeviceLoginButton facebookLoginButton;
    private CallbackManager facebookCallbackManager;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        facebookLoginButton = (DeviceLoginButton) findViewById(R.id.btn_facebook_login);

        final Context context = this;
        facebookCallbackManager = CallbackManager.Factory.create();
        facebookLoginButton.registerCallback(facebookCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                AccessToken accessToken = loginResult.getAccessToken();
                Toast.makeText(context, "Success, token: " + accessToken.toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancel() {
                Toast.makeText(context, "Canceled", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(final FacebookException error) {
                Toast.makeText(context, "Error " + error.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        facebookCallbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
