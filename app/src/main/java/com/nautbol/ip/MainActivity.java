package com.nautbol.ip;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.nautbol.ip.api.APIBuilder;
import com.nautbol.ip.models.IpGeolocationResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView version, response_tv, ip, country;
    IpGeolocationResponse ipGeolocationResponse;
    LinearLayout init, error, response_lyt;
    CardView map, find;
    ProgressBar progress;
    ImageView progress_off;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initView();
        try {
            initLogic();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void isLoading(Boolean is) {
        if (is) {
            progress_off.setVisibility(View.GONE);
            progress.setVisibility(View.VISIBLE);
        } else {
            progress_off.setVisibility(View.VISIBLE);
            progress.setVisibility(View.GONE);
        }
    }

    private void goToMaps(String latitude, String longitude) {
        Uri gmmIntentUri = Uri.parse("geo:" + latitude + "," + longitude + "?q=" + latitude + "," + longitude);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        startActivity(mapIntent);
    }

    private void initView() {
        response_tv = findViewById(R.id.response);
        version = findViewById(R.id.version);
        ip = findViewById(R.id.ip);
        country = findViewById(R.id.country);
        init = findViewById(R.id.init);
        error = findViewById(R.id.error);
        response_lyt = findViewById(R.id.response_lyt);
        map = findViewById(R.id.map);
        progress = findViewById(R.id.progress);
        find = findViewById(R.id.find);
        progress_off = findViewById(R.id.progress_off);
    }

    private void initLogic() throws Exception {
        PackageInfo pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
        int versionCode = pInfo.versionCode;
        String versionName = pInfo.versionName;
        version.setText(versionName + " (" + versionCode + ")");
        ipGeolocationResponse = null;
        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isLoading(true);
                init.setVisibility(View.VISIBLE);
                response_lyt.setVisibility(View.GONE);
                error.setVisibility(View.GONE);
                callIpGeo();
            }
        });
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMaps(ipGeolocationResponse.getLatitude(), ipGeolocationResponse.getLongitude());
            }
        });
    }

    private void callIpGeo() {
        APIBuilder api = new APIBuilder();
        api.getJsonApi().getIpInfo(this.getResources().getString(R.string.API_KEY)).enqueue(new Callback<IpGeolocationResponse>() {
            @Override
            public void onResponse(Call<IpGeolocationResponse> call, Response<IpGeolocationResponse> response) {
                isLoading(false);
                if (response.isSuccessful() && response.body() != null) {
                    //response_tv.setText(response.body().toString());
                    ipGeolocationResponse = response.body();
                    init.setVisibility(View.GONE);
                    ip.setText(ipGeolocationResponse.getIp());
                    country.setText(ipGeolocationResponse.getCountryName());
                    response_lyt.setVisibility(View.VISIBLE);
                    error.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<IpGeolocationResponse> call, Throwable t) {
                isLoading(false);
                response_tv.setText("ERROR: " + t.getLocalizedMessage());
                init.setVisibility(View.GONE);
                response_lyt.setVisibility(View.GONE);
                error.setVisibility(View.VISIBLE);
            }
        });
    }
}