package com.gunawan.pemulaandroidd;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gunawan.pemulaandroidd.model.DataKlub;
import com.gunawan.pemulaandroidd.model.Klub;

import java.util.ArrayList;
import java.util.List;

public class HalamanUtamaActivity extends AppCompatActivity implements DataKlub.KlubClickListener {
    public static final String Key_HalamanUtamaActivity="Key_HalamanUtamaActivity";

    public RecyclerView rv;
    public DataKlub dataKlub;
    public RecyclerView.LayoutManager layoutManager;
    public List<Klub> listKlub = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_utama);
        rv = findViewById(R.id.rvKlub);
        listKlub.add(new Klub("Bali United",
                "Poin 69",
                "https://1.bp.blogspot.com/-hy4GUKCzrMQ/YF176wFCPWI/AAAAAAAACKI/Qo3ep_ztW_MRwLPy-g3z10bZqp6QCYwvgCNcBGAsYHQ/s2048/Bali%2BUnited.png",
                "Peringkat ke-1"));
        listKlub.add(new Klub("Persib",
                "Poin 66",
                "https://cdn.freelogovectors.net/wp-content/uploads/2017/04/persib-logo.png",
                "Peringkat ke-2"));
        listKlub.add(new Klub("Persebaya",
                "Poin 59",
                "https://1.bp.blogspot.com/-Yijf7q1bbFc/XkaJ9IyRaNI/AAAAAAAABmw/GpcUqu8e5T817jdO7J7uGP0Nle0CPCbQACLcBGAsYHQ/s1600/Logo%2BPersebaya%2BSurabaya%2BHD.png",
                "Peringkat ke-3"));
        listKlub.add(new Klub("Bhayangkara",
                "Poin 59",
                "https://1.bp.blogspot.com/-1CVUl7tLr9U/YF185fA4HeI/AAAAAAAACKQ/SAf--4IcpDMznpRRn8ilmGmq2qWH2O17gCNcBGAsYHQ/s2048/Bhayangkara%2BSolo%2BFC.png",
                "Peringkat ke-4"));
        listKlub.add(new Klub("Arema",
                "Poin 58",
                "https://1.bp.blogspot.com/-C-iJSHQGKmE/YF17NCeZpKI/AAAAAAAACKA/vwENzLk_Jpg7Ag9UQsrLfOPdF2oa9gcsQCNcBGAsYHQ/s2048/Arema%2BFC.png",
                "Peringkat ke-5"));

        dataKlub = new DataKlub(listKlub);
        dataKlub.setListener(this);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        rv.setAdapter(dataKlub);
        rv.setLayoutManager(layoutManager);

    }

    @Override
    public void onClick(View view, int position) {
        Klub klub = listKlub.get(position);
        Intent apkklub = new Intent(HalamanUtamaActivity.this,HalamanDetailActivity.class);
        apkklub.putExtra(Key_HalamanUtamaActivity,klub);
        startActivity(apkklub);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainmenu, menu);
        return true;//super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.halamanutama:
                Toast.makeText(HalamanUtamaActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.halamandetail:
                Toast.makeText(HalamanUtamaActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.halamantentang:
                Toast.makeText(HalamanUtamaActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
        }
        return true;//super.onOptionsItemSelected(item);

    }
}
