package com.alexandre.cadastrousuario;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

//Classe Adapter: Gerencia a criação e o preenchimenhto dos itens na RecycleView
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    //Atributo privado que armazena a referencia dos dados que serao exibidos
    private List<String> listaUsuarios;

    // Construtor que permite que a MainActivity "entregue" a lista de dados para este Adapter
    public UserAdapter(List<String> lista){
        this.listaUsuarios = lista;
    }

    // Metodo 1: cria " do zero" o visual de uma linha da lista (+viewHolder)
    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        //LayoutInflatr transforma o arquivo XML em um objeto view Java
        //Aqui usamos um layout padrao do Android (simple_list_item_1) para facilitar
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);

        //retorna uma nova instancia da nossa classe interna ViewHolder a View Criada
        return new ViewHolder(view);
    }

    // Metodo 2: Vincula os dados de um objeto de lista a uma linha especifica da tela
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        // Recupera os dados da lista de acordo com a posição que o Android esta desenhando agora
        String nome = listaUsuarios.get(position);

        //define o texto no componete visual que esta guardado dentro de 'holder'
        holder.tvNome.setText(nome);
    }

    //Metodo 3: informa ao Android quantos itens a lista possui ao todo
    @Override
    public int getItemCount(){
        //Se a lista exister, retorna o tamanho. Se não, retorna zero
        return listaUsuarios != null ? listaUsuarios.size() : 0;
    }

    //Classe interna viewHolder: Servir para "segurar" as referencias dos componentes de cada linha
    //Evitar chamadas respectivas ao findViewById, melhorando a performance do RecycleView
    public class ViewHolder extends RecyclerView.ViewHolder{
        //Referencia para o TextView da linha

        TextView tvNome;

    public ViewHolder(@NonNull View itemView){
        super(itemView);
        //Faz o mapeamento do ID do layout para o objeto java
        //Android.R.id.text1 é o ID padrao do layout 'simple_list_item_1'
        tvNome = itemView.findViewById(android.R.id.text1);
    }
}
}
