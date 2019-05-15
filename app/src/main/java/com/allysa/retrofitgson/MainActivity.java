package com.allysa.retrofitgson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

//import butterknife.BindView;
//import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ApiKontak ApiKontak;
    private TextView textViewResult;
    // @BindView(R.id.text_view_result) private TextView textViewResult;  //cara mudah dan cepat

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = (TextView) findViewById(R.id.text_view_result);
        //ButterKnife.bind(this);

        //make retrofit object for base config of retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiKontak.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //initialize KontakApi interface for use the method of API
        ApiKontak = retrofit.create(ApiKontak.class);
        //getAllContact();
        //getContact(); / getContact(1);
        //getContact(2);
        //createContact();
        //deleteContact();
        updateContact();


    }

    public void getContact(int contactId) {  //atau getContact()
        Call<Kontak> call = ApiKontak.getContact(contactId);  //getContact();

        call.enqueue(new Callback<Kontak>() {
            @Override
            public void onResponse(Call<Kontak> call, Response<Kontak> response) {
                Kontak kontak = response.body();

                String content = " ";
                content += "ID : " + kontak.getIdContact() + "\n";
                content += "Nama :  " + kontak.getNama() + "\n";
                content += "Email : " + kontak.getEmail() + "\n";
                content += "No Hp : " + kontak.getPhone() + "\n";
                content += "Alamat : " + kontak.getAddres() + "\n\n";

                textViewResult.append(content);
            }

            @Override
            public void onFailure(Call<Kontak> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }

    public void getAllContact() {
        Call<List<Kontak>> call = ApiKontak.getAllContact();

        call.enqueue(new Callback<List<Kontak>>() {
            @Override
            public void onResponse(Call<List<Kontak>> call, Response<List<Kontak>> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("Code Response : " + response.code());
                    return;
                }
                List<Kontak> kontaks = response.body();
                for (Kontak kontak : kontaks) {
                    String content = " ";
                    content += "ID : " + kontak.getIdContact() + "\n";
                    content += "Nama :  " + kontak.getNama() + "\n";
                    content += "Email : " + kontak.getEmail() + "\n";
                    content += "No Hp : " + kontak.getPhone() + "\n";
                    content += "Alamat : " + kontak.getAddres() + "\n\n";

                    textViewResult.append(content);

                }
            }

            @Override
            public void onFailure(Call<List<Kontak>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }

    public void createContact() {
        //CARA 1 SAVE DATA
        //Kontak icha = new Kontak("Bryan Fahlevi", "Bryanflv@gmail.com", "081227291112", "Tebet, Jakarta Selatan" );
        //Call<Kontak> call = ApiKontak.saveContact(icha);

        //CARA 2 SAVE DATA
        Call<Kontak> call = ApiKontak.saveContact("Dinda", "Dindaafhiraa@gmail.com","08567725612", "Pagedangan");

        call.enqueue(new Callback<Kontak>() {
            @Override
            public void onResponse(Call<Kontak> call, Response<Kontak> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("Code Response : " + response.code());
                    return;
                }
                Kontak kontak = response.body();

                String content = " ";
                content += "Code : " + response.code() + "\n";
                content += "ID : " + kontak.getIdContact() + "\n";
                content += "Nama :  " + kontak.getNama() + "\n";
                content += "Email : " + kontak.getEmail() + "\n";
                content += "No Hp : " + kontak.getPhone() + "\n";
                content += "Alamat : " + kontak.getAddres() + "\n\n";

                textViewResult.append(content);
                Log.i("response : ", content);

            }


            @Override
            public void onFailure(Call<Kontak> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }

    public void deleteContact() {
        Call<Void> call = ApiKontak.deleteContact(77);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("Code Response : " + response.code());
                    return;
                }
                    textViewResult.setText("Code Response : " + response.code());

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });

    }

    public void updateContact() {
        //CARA 1 SAVE DATA
        Kontak icha = new Kontak("Bryan Fahlevi", "Bryanflv@gmail.com", "081227291112", "Tebet, Jakarta Selatan" );
        //Call<Kontak> call = ApiKontak.putContact(79,icha);
        Call<Kontak> call = ApiKontak.patchContact(84,icha);

        //CARA 2 SAVE DATA
        //Call<Kontak> call = ApiKontak.saveContact("Dinda", "Dindaafhiraa@gmail.com","08567725612", "Pagedangan");

        call.enqueue(new Callback<Kontak>() {
            @Override
            public void onResponse(Call<Kontak> call, Response<Kontak> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("Code Response : " + response.code());
                    return;
                }
                Kontak kontak = response.body();

                String content = " ";
                content += "Code : " + response.code() + "\n";
                content += "ID : " + kontak.getIdContact() + "\n";
                content += "Nama :  " + kontak.getNama() + "\n";
                content += "Email : " + kontak.getEmail() + "\n";
                content += "No Hp : " + kontak.getPhone() + "\n";
                content += "Alamat : " + kontak.getAddres() + "\n\n";

                textViewResult.append(content);
                Log.i("response : ", content);

            }


            @Override
            public void onFailure(Call<Kontak> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }
}