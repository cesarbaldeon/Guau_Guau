package pe.edu.cibertec.guauguau.presentation.menu.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import pe.edu.cibertec.guauguau.R;

public class VacunasAdapter extends RecyclerView.Adapter<VacunasAdapter.MyViewHolder>  {

    //private List<> mascotasList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtmonbre, txtfecha_nac,txtdocumento,txtraza,txtgrupo;

        public MyViewHolder(View view) {
            super(view);

            txtmonbre = (TextView) view.findViewById(R.id.avatar_nombre);
            txtfecha_nac = (TextView) view.findViewById(R.id.avatar_fechas_nac);
            txtdocumento = (TextView) view.findViewById(R.id.avatar_documento);
            txtraza = (TextView) view.findViewById(R.id.avatar_raza);
            txtgrupo = (TextView) view.findViewById(R.id.avatar_grupo);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

}
