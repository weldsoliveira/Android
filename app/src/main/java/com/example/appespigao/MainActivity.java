package com.example.appespigao;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.appespigao.adapter.AdapterJogosPersonalizado;
import com.example.appespigao.models.Bloco;
import com.example.appespigao.models.Jogo;
import com.example.appespigao.services.GeradorLoteria;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {
    private Button btnGerar;
    private   ListView  lista;
    private   TextView txtQtd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        btnGerar = findViewById(R.id.btnGerar);
        lista = (ListView) findViewById(R.id.lv_jogos);
        txtQtd = (TextView)findViewById(R.id.txtQtd);
        btnGerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                List<Jogo> jogos = AdicionarJogos(txtQtd.getText().toString());
                AdapterJogosPersonalizado adapter = new AdapterJogosPersonalizado(jogos, MainActivity.this);
                lista.setAdapter(adapter);
            }
        });
    }

    public List<Jogo> AdicionarJogos(String qtd){
        GeradorLoteria gerador = new GeradorLoteria();
        List<Bloco> blocos = gerador.Gerar(Integer.parseInt(qtd));
        List<Jogo> paraTela  = new ArrayList<>();
        int i = 1;

        for (Bloco bloco : blocos) {
            for (Jogo jogo : bloco.getJogos()) {

                jogo.setNomeBloco("Bloco" + i);
                paraTela.add(jogo);
            }
            i += 1;
        }
        return paraTela;
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater menuInflater = getMenuInflater();
//        menuInflater.inflate(R.menu.bottom_nav_menu, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        switch (item.getItemId()) {
//            case R.id.navigation_home:
//                Intent intent = new Intent(this, MainActivity.class);
//                //  Intent intent2 = new Intent(this, MainActivity.class);
//                this.startActivity(intent);
//                return true;
//
//            case R.id.navigation_dashboard:
//                Toast.makeText(this, "You clicked dashboard", Toast.LENGTH_SHORT).show();
//                return true;
//
//            case R.id.navigation_notifications:
//                Toast.makeText(this, "You clicked notificações", Toast.LENGTH_SHORT).show();
//            default:
//                return super.onOptionsItemSelected(item);
//
//        }
//    }

}
