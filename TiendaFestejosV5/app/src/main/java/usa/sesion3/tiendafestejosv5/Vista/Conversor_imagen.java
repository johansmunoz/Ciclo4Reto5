package usa.sesion3.tiendafestejosv5.Vista;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import usa.sesion3.tiendafestejosv5.R;

public class Conversor_imagen extends AppCompatActivity {

    ImageView cargarImagen;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conversor_imagen);

        cargarImagen = findViewById(R.id.image_url);

        Picasso.get()
                .load("https://correos-marketplace.ams3.cdn.digitaloceanspaces.com/prod-new/uploads/correos-marketplace-shop/1/product/3893-ep1jflmw-pinatas-en-la-nube-pinata-logo-whatsapp-1.jpg")
                .error(R.mipmap.ic_launcher)
                .into(cargarImagen);

    }
}
