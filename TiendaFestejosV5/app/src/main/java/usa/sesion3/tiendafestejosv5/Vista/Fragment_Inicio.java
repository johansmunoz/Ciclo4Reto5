package usa.sesion3.tiendafestejosv5.Vista;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import usa.sesion3.tiendafestejosv5.R;


public class Fragment_Inicio extends Fragment {

    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        v = inflater.inflate(R.layout.fragment__inicio, container, false);

        return v;
    }
}