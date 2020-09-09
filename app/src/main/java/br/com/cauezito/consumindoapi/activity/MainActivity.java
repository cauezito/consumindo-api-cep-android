package br.com.cauezito.consumindoapi.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

import br.com.cauezito.consumindoapi.R;
import br.com.cauezito.consumindoapi.fragment.CepFragment;
import br.com.cauezito.consumindoapi.model.Endereco;
import br.com.cauezito.consumindoapi.service.HttpService;

public class MainActivity extends AppCompatActivity {
    private Button btnPesquisar;
    private TextView txtCep;
    private String cep = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtCep = findViewById(R.id.txtCep);
        btnPesquisar = findViewById(R.id.btnPesquisar);
        btnPesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cep = txtCep.getText().toString();
                if(cep.length() == 8) {
                    try {
                        CepFragment cepFragment = new CepFragment();
                        Endereco endereco = new HttpService(cep).execute().get();
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("resultado", endereco);
                        cepFragment.setArguments(bundle);
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frameResultado, cepFragment);
                        transaction.commit();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else { //alerta validação
                    Toast.makeText(getApplicationContext(), "Digite um CEP válido!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}