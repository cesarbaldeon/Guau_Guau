package pe.edu.cibertec.guauguau.presentation.vacunas.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import pe.edu.cibertec.guauguau.R;
import pe.edu.cibertec.guauguau.data.entities.Vacunas;

public class ListaVacunasAdapter extends RecyclerView.Adapter<ListaVacunasAdapter.MyViewHolder>  {

    private List<Vacunas> vacunasList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtnombre_mascota, txtfecha_vacuna,txtnombre_vacuna,txt_detalle_vacuna;

        public MyViewHolder(View view) {
            super(view);

            txtnombre_mascota = (TextView) view.findViewById(R.id.txtnombre_mascota);
            txtnombre_vacuna = (TextView) view.findViewById(R.id.txtnombreva);
            txtfecha_vacuna = (TextView) view.findViewById(R.id.txtfechas_vacuna);
            txt_detalle_vacuna = (TextView) view.findViewById(R.id.txt_detalle_vacuna);
        }
    }

    public ListaVacunasAdapter(List<Vacunas> vacunasList) {
        this.vacunasList = vacunasList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_vacunas, parent, false);
        return new ListaVacunasAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Vacunas vacuna = vacunasList.get(position);

        holder.txtnombre_mascota.setText(String.valueOf(vacuna.getObjMascota().getNombre()));
        holder.txtnombre_vacuna.setText(String.valueOf(vacuna.getNom_vacuna()));
        holder.txtfecha_vacuna.setText(String.valueOf(vacuna.getFecha_vacuna()));
        holder.txt_detalle_vacuna.setText(String.valueOf(vacuna.getDetalle_vacuna()));

    }

    @Override
    public int getItemCount() {
        return vacunasList.size();
    }

}
