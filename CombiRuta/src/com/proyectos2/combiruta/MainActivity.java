package com.proyectos2.combiruta;


import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.os.AsyncTask;
import android.view.Menu;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.support.v4.app.FragmentActivity;
import android.widget.Button;
import android.widget.EditText;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.location.Geocoder;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnCameraChangeListener;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.GoogleMap.OnMapLongClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.PolylineOptions;
import com.proyectos2.controladora.PuntoDAO;
import com.proyectos2.util.DirectionsJSONParser;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;




public class MainActivity extends FragmentActivity implements OnCameraChangeListener,  OnMapLongClickListener, OnMapClickListener{
	
	GoogleMap googleMap;
	private LatLngBounds mRegion;
	Geocoder geoCoder;
	ArrayList<LatLng> markerPoints;
	PuntoDAO helper;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		if (android.os.Build.VERSION.SDK_INT > 9) {
		    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		    StrictMode.setThreadPolicy(policy);
		}
		
		final Button btn = (Button)findViewById(R.id.btnsearch);
		markerPoints = new ArrayList<LatLng>();
		
		helper = new PuntoDAO(this);
		
		helper.abrir();
		//Limite del Mapa
		mRegion = new LatLngBounds(new LatLng(-12.270078, -77.175178), new LatLng(-11.822714, -77.942339));
		
		btn.setOnClickListener(ListenerSearch());
		
		setUpMapIfNeeded();
		
		
	}
	
	protected void onResume(){
		super.onResume();
		//updateEnabledState();
		setUpMapIfNeeded();
	}
	
	private void setUpMapIfNeeded() {
		 if (googleMap == null) {
			 googleMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
	                    .getMap();
	            if (googleMap != null) {
	            	
	                setUpMap();
	            }
	        }
   }
	
	private void setUpMap() {
		
		
		 // Configuración del Mapa
		googleMap.getUiSettings().setZoomControlsEnabled(true);
		googleMap.setOnCameraChangeListener(this);
		googleMap.setOnMapLongClickListener(this);
		googleMap.setOnMapClickListener(this);
		googleMap.setMyLocationEnabled(true);

       // Mostrar Lima
		googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-12.095, -77.008), 15));
   }

	
public View.OnClickListener ListenerSearch(){
		
		View.OnClickListener listener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			EditText txt = (EditText)findViewById(R.id.txtsearch);
			String nombre = txt.getText().toString();
			
		    HttpGet httpGet = new HttpGet("http://maps.google.com/maps/api/geocode/json?address=" +nombre+"&ka&sensor=false");
		    HttpClient client = new DefaultHttpClient();
		    HttpResponse response;
		    StringBuilder stringBuilder = new StringBuilder();
		   
		    try {
		    	response = client.execute(httpGet);
		        HttpEntity entity = response.getEntity();
		        InputStream stream = entity.getContent();
		        int b;
		        while ((b = stream.read()) != -1) {
		            stringBuilder.append((char) b);
		        }
		    } catch (ClientProtocolException e) {
		    } catch (IOException e) {
		    }

		    JSONObject jsonObject = new JSONObject();

		    try {
		        jsonObject = new JSONObject(stringBuilder.toString());
		    } catch (JSONException e) {

		        e.printStackTrace();
		        
		    }
			
			googleMap.clear();
		    googleMap.addMarker(new MarkerOptions().position(getLatLng(jsonObject)).title("Marker"));
		    googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(getLatLng(jsonObject), 10));
			
			
		}
	};
		return listener;
	}
	
public  LatLng getLatLng(JSONObject jsonObject) {

    Double lon = new Double(0);
    Double lat = new Double(0);

    try {

        lon = ((JSONArray)jsonObject.get("results")).getJSONObject(0)
            .getJSONObject("geometry").getJSONObject("location")
            .getDouble("lng");

        lat = ((JSONArray)jsonObject.get("results")).getJSONObject(0)
            .getJSONObject("geometry").getJSONObject("location")
            .getDouble("lat");

    } catch (JSONException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    return new LatLng(lat,lon);

}
	
	
	

	@Override
	public void onCameraChange(CameraPosition cameraPosition) {
		// TODO Auto-generated method stub
	    if(!mRegion.contains(cameraPosition.target)){
	       
	        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-12.095, -77.008), 15));
	       
	    } 
	}

	@Override
	public void onMapLongClick(LatLng x) {
		// TODO Auto-generated method stub
		//googleMap.clear();
		markerPoints.add(x);
		MarkerOptions options = new MarkerOptions();
		options.position(x);
		if(markerPoints.size()==1){
            options.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        }else if(markerPoints.size()==2){
            options.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        }
		googleMap.addMarker(options);
		//googleMap.addMarker(new MarkerOptions().position(x).title("Marker"));
		//googleMap.setTrafficEnabled(true);
		 if(markerPoints.size() >= 2){
             LatLng origin = markerPoints.get(0);
             LatLng dest = markerPoints.get(1);
            
             // Getting URL to the Google Directions API
             String url = getDirectionsUrl(origin, dest);

             DownloadTask downloadTask = new DownloadTask();

             // Start downloading json data from Google Directions API
             downloadTask.execute(url);
         }
	}

	@Override
	public void onMapClick(LatLng arg0) {
		// TODO Auto-generated method stub
		googleMap.clear();
	}
	
	 private String getDirectionsUrl(LatLng origin,LatLng dest){
		 
	        // Origin of route
	        String str_origin = "origin="+origin.latitude+","+origin.longitude;
	 
	        // Destination of route
	        String str_dest = "destination="+dest.latitude+","+dest.longitude;
	 
	        // Sensor enabled
	        String sensor = "sensor=false";
	 
	        // Building the parameters to the web service
	        String parameters = str_origin+"&"+str_dest+"&"+sensor;
	 
	        // Output format
	        String output = "json";
	 
	        // Building the url to the web service
	        String url = "https://maps.googleapis.com/maps/api/directions/"+output+"?"+parameters;
	 
	        return url;
	    }
	    /** A method to download json data from url */
	    private String downloadUrl(String strUrl) throws IOException{
	        String data = "";
	        InputStream iStream = null;
	        HttpURLConnection urlConnection = null;
	        try{
	            URL url = new URL(strUrl);
	 
	            // Creating an http connection to communicate with url
	            urlConnection = (HttpURLConnection) url.openConnection();
	 
	            // Connecting to url
	            urlConnection.connect();
	 
	            // Reading data from url
	            iStream = urlConnection.getInputStream();
	 
	            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));
	 
	            StringBuffer sb = new StringBuffer();
	 
	            String line = "";
	            while( ( line = br.readLine()) != null){
	                sb.append(line);
	            }
	 
	            data = sb.toString();
	 
	            br.close();
	 
	        }catch(Exception e){
	            Log.d("Exception while downloading url", e.toString());
	        }finally{
	            iStream.close();
	            urlConnection.disconnect();
	        }
	        return data;
	    }
	 
	    // Fetches data from url passed
	    private class DownloadTask extends AsyncTask<String, Void, String>{
	 
	        // Downloading data in non-ui thread
	        @Override
	        protected String doInBackground(String... url) {
	 
	            // For storing data from web service
	            String data = "";
	 
	            try{
	                // Fetching the data from web service
	                data = downloadUrl(url[0]);
	            }catch(Exception e){
	                Log.d("Background Task",e.toString());
	            }
	            return data;
	        }
	 
	        // Executes in UI thread, after the execution of
	        // doInBackground()
	        @Override
	        protected void onPostExecute(String result) {
	            super.onPostExecute(result);
	 
	            ParserTask parserTask = new ParserTask();
	 
	            // Invokes the thread for parsing the JSON data
	            parserTask.execute(result);
	        }
	    }
	 
	    /** A class to parse the Google Places in JSON format */
	    private class ParserTask extends AsyncTask<String, Integer, List<List<HashMap<String,String>>> >{
	 
	        // Parsing the data in non-ui thread
	        @Override
	        protected List<List<HashMap<String, String>>> doInBackground(String... jsonData) {
	 
	            JSONObject jObject;
	            List<List<HashMap<String, String>>> routes = null;
	 
	            try{
	                jObject = new JSONObject(jsonData[0]);
	                DirectionsJSONParser parser = new DirectionsJSONParser();
	 
	                // Starts parsing data
	                routes = parser.parse(jObject);
	            }catch(Exception e){
	                e.printStackTrace();
	            }
	            return routes;
	        }
	 
	        // Executes in UI thread, after the parsing process
	        @Override
	        protected void onPostExecute(List<List<HashMap<String, String>>> result) {
	            ArrayList<LatLng> points = null;
	            PolylineOptions lineOptions = null;
	            MarkerOptions markerOptions = new MarkerOptions();
	 
	            // Traversing through all the routes
	            for(int i=0;i<result.size();i++){
	                points = new ArrayList<LatLng>();
	                lineOptions = new PolylineOptions();
	 
	                // Fetching i-th route
	                List<HashMap<String, String>> path = result.get(i);
	 
	                // Fetching all the points in i-th route
	                for(int j=0;j<path.size();j++){
	                    HashMap<String,String> point = path.get(j);
	 
	                    double lat = Double.parseDouble(point.get("lat"));
	                    double lng = Double.parseDouble(point.get("lng"));
	                    LatLng position = new LatLng(lat, lng);
	 
	                    points.add(position);
	                }
	 
	                // Adding all the points in the route to LineOptions
	                lineOptions.addAll(points);
	                lineOptions.width(4);
	                lineOptions.color(Color.BLACK);
	            }
	 
	            // Drawing polyline in the Google Map for the i-th route
	            googleMap.addPolyline(lineOptions);
	        }
	    }
	 
	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.main, menu);
	        return true;
	    }
}
