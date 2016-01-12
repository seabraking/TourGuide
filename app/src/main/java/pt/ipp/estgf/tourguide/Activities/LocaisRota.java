package pt.ipp.estgf.tourguide.Activities;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

import pt.ipp.estgf.tourguide.Adapter.LocalAdapter;
import pt.ipp.estgf.tourguide.Adapter.SearchableLocalAdapter;
import pt.ipp.estgf.tourguide.Classes.Local;
import pt.ipp.estgf.tourguide.Gestores.GestorRotas;
import pt.ipp.estgf.tourguide.R;

public class LocaisRota extends ListActivity {
    private Context mContext;
    private SearchableLocalAdapter mAdapter;
    private ArrayList<Local> mLocaisRota = new ArrayList<Local>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locais_rota);

        mAdapter = new SearchableLocalAdapter(getApplicationContext(), mLocaisRota);

        setListAdapter(mAdapter);
        

        TextView nomeRota = (TextView) findViewById(R.id.nomeRotaLocais);
        
        
        Intent intent = getIntent();
        int idRota = intent.getExtras().getInt("idRota");

        GestorRotas gestorRotas = new GestorRotas();
        mLocaisRota.addAll(gestorRotas.listarLocaisRota(idRota,getApplicationContext()));

        mAdapter.notifyDataSetChanged();

 }
}
