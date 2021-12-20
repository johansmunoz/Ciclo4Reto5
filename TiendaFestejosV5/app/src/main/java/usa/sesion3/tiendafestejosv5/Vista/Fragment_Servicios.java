package usa.sesion3.tiendafestejosv5.Vista;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import usa.sesion3.tiendafestejosv5.Entidades.Entidad_Servicios;
import usa.sesion3.tiendafestejosv5.R;

public class Fragment_Servicios extends Fragment {

    String TAG = "Fragment_Servicios";

    View v;
    ListView listaServicios;
    //ServiciosAdapter adaptador_servicios;
    TextView nombreServicio, descripcionServicio, linkServicios;


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment__servicios, container, false);

        listaServicios = (ListView)v.findViewById(R.id.list_viewServicios);
        ServiciosAdapter adaptador_servicios = new ServiciosAdapter(GetItemLista(), getContext());

        listaServicios.setAdapter(adaptador_servicios);
        nombreServicio = (TextView) v.findViewById(R.id.nombreServicio);
        descripcionServicio=(TextView) v.findViewById(R.id.descripción_Servicio);
        linkServicios =(TextView) v.findViewById(R.id.urlServicios);

      return v;

}
    private ArrayList<Entidad_Servicios> GetItemLista(){
        ArrayList<Entidad_Servicios> listaServicios2 = new ArrayList<>();


        String url="https://g0dfc25f9d5bd2a-db202112132345.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/servicios/servicios";
        List<String> jsonResponses = new ArrayList<>();

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("items");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                String nombre = jsonObject.getString("name");
                                String descripcion = jsonObject.getString("descripcion");
                                //String url = jsonObject.getString("imagen");


                                nombreServicio.append(nombre +'\n');
                                descripcionServicio.append(descripcion+'\n');
                                //link.append(url+'\n');


                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue.add(jsonObjectRequest);

        listaServicios2.add(new Entidad_Servicios(R.drawable.cumpleanos, "Cumpleaños", "Para niños y adultos"));
        listaServicios2.add(new Entidad_Servicios(R.drawable.despedidasolteros, "Despedidas de Solteros", "Damas y Caballeros"));
        listaServicios2.add(new Entidad_Servicios(R.drawable.fiestas15anos, "Fiestas de 15 años", "Reuniones y paseos"));
        listaServicios2.add(new Entidad_Servicios(R.drawable.matrimonios, "Matrimonios", "Dentro y fuera de Bogotá"));

        return listaServicios2;
    }
}