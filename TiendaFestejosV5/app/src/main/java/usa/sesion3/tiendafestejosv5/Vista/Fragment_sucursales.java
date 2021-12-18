package usa.sesion3.tiendafestejosv5.Vista;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.osmdroid.config.Configuration;
import org.osmdroid.library.BuildConfig;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus;
import org.osmdroid.views.overlay.OverlayItem;
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;

import java.util.ArrayList;

import usa.sesion3.tiendafestejosv5.R;


public class Fragment_sucursales extends Fragment {

    View v;

    private MapView myOpenMapView;
    private MapController myMapController;

    GeoPoint PlazaCentral, CiudadMontes, BosaCentro, Galerias;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_sucursales, container, false);
        //-----------------------------------------------------------------------------

        myOpenMapView = (MapView) v.findViewById(R.id.openmapview);

        /* ---- necesitamos establecer el valor del agente de usuario en la configuración ------- */
        Configuration.getInstance().setUserAgentValue(BuildConfig.APPLICATION_ID);

        /*   punto de geolocalizacion de ejemplo */
        PlazaCentral = new GeoPoint(4.631332194040551, -74.11578207339942);
        CiudadMontes = new GeoPoint(4.605108386207282, -74.11410638151348);
        BosaCentro = new GeoPoint(4.6096350579382355, -74.18437482956178);
        Galerias = new GeoPoint(4.6418456391447265, -74.07362225602759);

        myOpenMapView.setBuiltInZoomControls(true);

        myMapController = (MapController) myOpenMapView.getController();
        myMapController.setCenter(PlazaCentral);
        myMapController.setZoom(12);

        myOpenMapView.setMultiTouchControls(true);

        /* -------------------------------------------------------------------------------------------------- */
        final MyLocationNewOverlay myLocationoverlay = new MyLocationNewOverlay(new GpsMyLocationProvider(getContext()), myOpenMapView);
        myOpenMapView.getOverlays().add(myLocationoverlay); //No añadir si no quieres una marca
        myLocationoverlay.enableMyLocation();

        myLocationoverlay.runOnFirstFix(new Runnable() {
            public void run() {
                myMapController.animateTo(myLocationoverlay.getMyLocation());
            }
        });
        /* -------------------------------------------------------------------------------------------------- */

        /* MARCAS EN EL MAPA */

        ArrayList<OverlayItem> puntos = new ArrayList<OverlayItem>();
        puntos.add(new OverlayItem("Plaza central", "Av. calle 13", PlazaCentral));
        puntos.add(new OverlayItem("Ciudad Montes", "Octava sur", CiudadMontes));
        puntos.add(new OverlayItem("Bosa Centro", "Bosa Centro", BosaCentro));
        puntos.add(new OverlayItem("Galerias", "Galerias", Galerias));

        ItemizedIconOverlay.OnItemGestureListener<OverlayItem> tap = new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>() {
            @Override
            public boolean onItemLongPress(int arg0, OverlayItem arg1) {
                return false;
            }
            @Override
            public boolean onItemSingleTapUp(int index, OverlayItem item) {
                return true;
            }
        };

        ItemizedOverlayWithFocus<OverlayItem> capa = new ItemizedOverlayWithFocus<OverlayItem>(getContext(), puntos, tap);
        capa.setFocusItemsOnTap(true);
        myOpenMapView.getOverlays().add(capa);



        //-----------------------------------------------------------------------------
        return v;
    }

}