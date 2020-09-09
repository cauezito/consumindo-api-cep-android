package br.com.cauezito.consumindoapi.service;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import br.com.cauezito.consumindoapi.model.Endereco;

public class HttpService extends AsyncTask<Void, Void, Endereco> {
    private final String cep;

    public HttpService(String cep) {
        this.cep = cep;
    }

    @Override
    protected Endereco doInBackground(Void... voids) {
            try {
                StringBuilder retorno = new StringBuilder();
                URL url = new URL("http://viacep.com.br/ws/" + this.cep + "/json/");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line;
                while ((line = rd.readLine()) != null) {
                    retorno.append(line);
                }
                return new Gson().fromJson(retorno.toString(),Endereco.class);
            } catch (IOException e) {
                e.printStackTrace();
                return new Endereco();
            }
    }
}


