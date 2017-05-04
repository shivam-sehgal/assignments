package fragments;

import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.uiassignment.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;
import java.util.Locale;

/**
 * class for map fragment
 */
public class MapFragment extends Fragment implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener,
        com.google.android.gms.location.LocationListener {
    private GoogleMap gmap;
    private MapView mapView;
    private final int reqestLocationPermission = 99;
    private GoogleApiClient googleApiClient;
    private LatLng origin;
    private TextView tvCurrentAdrs;
    private LocationRequest locationRequest;
    private final int normalTime = 6000;
    private final int fastTime = 1000;
    private final int zoomLevel = 12;


    /**
     * empty constructor
     */
    public MapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        mapView = (MapView) view.findViewById(R.id.my_map);
        MapsInitializer.initialize(getActivity());
        mapView.onCreate(savedInstanceState);
        tvCurrentAdrs = (TextView) view.findViewById(R.id.curr_adress);
        mapView.onResume();
        mapView.getMapAsync(this);

        return view;

    }


    @Override
    public void onMapReady(final GoogleMap googleMap) {
        gmap = googleMap;
        if (ContextCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            gmap.setMyLocationEnabled(true);
            buildGoogleApiClient();
        } else {
            askPermission();
        }


    }

    /**
     * make gogle api client
     */
    public void buildGoogleApiClient() {
        googleApiClient = new GoogleApiClient.Builder(getActivity())
                .addConnectionCallbacks(this).addOnConnectionFailedListener(this).
                        addApi(LocationServices.API).build();
        googleApiClient.connect();
    }

    /**
     * method to ask permission at run time
     */
    public void askPermission() {
        if (ContextCompat.checkSelfPermission(getActivity()
                , android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                    reqestLocationPermission);
        }
    }

    @Override
    public void onRequestPermissionsResult(final int requestCode, final String[] permissions, final int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == reqestLocationPermission) {
            for (int i = 0; i < permissions.length; i++) {
                String permission = permissions[i];
                int grant = grantResults[i];
                if (permission.equals(android.Manifest.permission.ACCESS_FINE_LOCATION)
                        && grant == PackageManager.PERMISSION_GRANTED) {
                    if (ContextCompat.checkSelfPermission(getActivity(),
                            android.Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {
                        gmap.setMyLocationEnabled(true);
                        buildGoogleApiClient();
                    }
                } else {
                    Toast.makeText(getActivity(), "NO MAP FOR YOU", Toast.LENGTH_LONG).show();
                }

            }
        }
    }

    @Override
    public void onLocationChanged(final Location location) {

        origin = new LatLng(location.getLatitude(), location.getLongitude());
        MarkerOptions mrker = new MarkerOptions();
        mrker.position(origin);
        mrker.title("here you are");
        BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.drawable.pin);
        mrker.icon(icon);

        gmap.addMarker(mrker);
        gmap.moveCamera(CameraUpdateFactory.newLatLng(origin));
        gmap.animateCamera(CameraUpdateFactory.zoomTo(zoomLevel));
        tvCurrentAdrs.setText(getCompleteAddressString(location.getLatitude(), location.getLongitude()));
        if (googleApiClient != null) {
            LocationServices.FusedLocationApi.removeLocationUpdates(googleApiClient, (com.google.android.gms.location.LocationListener) this);

        }

    }


    @Override
    public void onConnected(final Bundle bundle) {

        locationRequest = new LocationRequest();
        locationRequest.setInterval(normalTime);
        locationRequest.setFastestInterval(fastTime);
        locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        if (ContextCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

            LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient,
                    locationRequest, (com.google.android.gms.location.LocationListener) this);
        }

    }

    @Override
    public void onConnectionSuspended(final int i) {

    }

    @Override
    public void onConnectionFailed(final ConnectionResult connectionResult) {

    }

    /**
     * @param latitude  latitude of current location
     * @param longitude longitude of current location
     * @return string off adress
     */
    private String getCompleteAddressString(final double latitude, final double longitude) {
        String addres = null;
        Geocoder geocode = new Geocoder(getActivity(), Locale.getDefault());
        try {
            List<Address> adresslist = geocode.getFromLocation(latitude, longitude, 1);
            if (adresslist != null) {
                android.location.Address returnedAddress = adresslist.get(0);
                StringBuilder strbuilder = new StringBuilder("");
                for (int i = 0; i < returnedAddress.getMaxAddressLineIndex(); i++) {

                    strbuilder.append(returnedAddress.getAddressLine(i));
                }
                addres = strbuilder.toString();

                return addres;

            }


        } catch (Exception e) {
            Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }


        return addres;
    }
}

