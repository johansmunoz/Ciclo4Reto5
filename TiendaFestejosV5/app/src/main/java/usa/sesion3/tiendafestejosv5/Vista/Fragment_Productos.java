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

import usa.sesion3.tiendafestejosv5.R;


public class Fragment_Productos extends Fragment {

    String TAG = "Fragment_Productos";

    View v;
    ListView listaProductos;
    Adaptador_Productos adaptador_productos;
    TextView prueba, titulo, descripcion1, link;
    Conversor_imagen imagen;
    //int [] imagen;


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment__productos, container, false);

        listaProductos = (ListView)v.findViewById(R.id.list_view);
        Adaptador_Productos adaptador_productos = new Adaptador_Productos(GetItemLista(), getContext());

        //final ArrayAdapter adapter = new ArrayAdapter<String>(getContext(), R.layout.fragment__productos);
        //listaProductos.setAdapter(adapter);//adaptador_productos
        prueba = (TextView) v.findViewById(R.id.prueba);
        descripcion1=(TextView) v.findViewById(R.id.descripcion);
        link =(TextView) v.findViewById(R.id.url2);

        return v;
    }

    /**
     * FUNCION PARA LA IMPORTACION DE LA LISTA
     * @return
     */
    private ArrayList<Entidad_Productos> GetItemLista(){
        ArrayList<Entidad_Productos> listaProductos2 = new ArrayList<>();


        String url="https://g0dfc25f9d5bd2a-db202112132345.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/datos/plantilla";
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

                                String name = jsonObject.getString("name");
                                String descripcion = jsonObject.getString("descripcion");
                                String url = jsonObject.getString("imagen");


                                prueba.append(name +'\n');
                                descripcion1.append(descripcion+'\n');
                                link.append(url+'\n');


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

        return listaProductos2;
    }
}