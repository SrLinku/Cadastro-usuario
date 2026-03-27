package com.alexandre.cadastrousuario;

import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;
import android.os.Bundle;

public class CreateUser extends AppCompatActivity {
    TextInputEditText editNome, editMail;

    Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_user);

        editNome = findViewById(R.id.nome);
        editMail = findViewById(R.id.email);
        btnSalvar = findViewById(R.id.salvar);

        btnSalvar.setOnClickListener(view -> {

            String nome = editNome.getText().toString();
            String email = editMail.getText().toString();

            if (!nome.isEmpty()) {
                MainActivity.listaNomes.add(nome + " (" + email + ") ");
                finish();
            }
        });
    }
}
