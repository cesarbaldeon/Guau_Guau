package pe.edu.cibertec.guauguau.presentation.menu.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import pe.edu.cibertec.guauguau.R;
import pe.edu.cibertec.guauguau.data.entities.Mascotas;

public class CanesAdapter extends RecyclerView.Adapter<CanesAdapter.MyViewHolder> {

    private List<Mascotas> mascotasList;


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

    public CanesAdapter(List<Mascotas> mascotasList) {
        this.mascotasList = mascotasList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_canes, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Mascotas mascotas = mascotasList.get(position);

        String documento = "DOG" +  String.valueOf(mascotas.getObjUsuarios().getId_User()) +  String.valueOf(mascotas.getId_mascota());
        holder.txtmonbre.setText(String.valueOf(mascotas.getNombre()));
        holder.txtfecha_nac.setText(String.valueOf(mascotas.getFecha_nac()));
        holder.txtdocumento.setText(documento);
        holder.txtraza.setText(String.valueOf(mascotas.getRaza()));
        holder.txtgrupo.setText(String.valueOf(mascotas.getCaracter()));
    }

    @Override
    public int getItemCount() {
        return mascotasList.size();
    }

}
