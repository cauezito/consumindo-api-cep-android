package br.com.cauezito.consumindoapi.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.com.cauezito.consumindoapi.R;
import br.com.cauezito.consumindoapi.model.Endereco;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CepFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CepFragment extends Fragment {

    private TextView logradouro;
    private TextView bairro;
    private TextView localidade;
    private TextView uf;
    private TextView ddd;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CepFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CepFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CepFragment newInstance(String param1, String param2) {
        CepFragment fragment = new CepFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cep, container, false);
        logradouro = view.findViewById(R.id.txtLogradouro);
        bairro = view.findViewById(R.id.txtBairro);
        localidade = view.findViewById(R.id.txtLocalidade);
        uf = view.findViewById(R.id.txtUf);
        ddd = view.findViewById(R.id.txtDDD);
        Endereco endereco = (Endereco) getArguments().getSerializable("resultado");
        preencheResultados(endereco);
        return view;
    }

    private void preencheResultados(Endereco endereco){
            logradouro.setText(endereco.getLogradouro());
            bairro.setText(endereco.getBairro());
            localidade.setText(endereco.getLocalidade());
            uf.setText(endereco.getUf());
            ddd.setText(endereco.getDdd());
    }
}