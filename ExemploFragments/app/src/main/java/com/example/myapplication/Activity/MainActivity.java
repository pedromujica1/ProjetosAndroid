package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.Fragment.ContatosFragment;
import com.example.myapplication.Fragment.ConversasFragment;
import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

    private Button buttonConversa,buttonContato;
    private ConversasFragment conversasFragment;

    private ContatosFragment contatosFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //DEFINIR ELEMENTOS
        buttonContato = findViewById(R.id.buttonContatos);
        buttonConversa = findViewById(R.id.buttonConversas);

        conversasFragment = new ConversasFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        //DEFINIR QUAL FRAGMENTO VAI SER EXIBIDO EM QUAL PARTE
        transaction.replace(R.id.frameConteudo,conversasFragment);
        transaction.commit();

        buttonContato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contatosFragment = new ContatosFragment();

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameConteudo,contatosFragment);
                transaction.commit();

            }
        });

        buttonConversa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                conversasFragment = new ConversasFragment();

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameConteudo,conversasFragment);
                transaction.commit();
            }
        });

    }
}