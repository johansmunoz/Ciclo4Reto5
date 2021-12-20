/**package usa.sesion3.tiendafestejosv5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Configuracion extends AppCompatActivity {

    Button edicion_servicios;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.configuracion);

        edicion_servicios = (Button)findViewById(R.id.editar_servicios);
        edicion_servicios.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent edit_Ser = new Intent(getApplicationContext(), Tu_Perfil.class);
                startActivity(edit_Ser);
            }
        });
    }




}
*/