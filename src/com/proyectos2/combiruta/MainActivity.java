package com.proyectos2.combiruta;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


import android.location.Geocoder;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnCameraChangeListener;
import com.google.android.gms.maps.GoogleMap.OnMapLongClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.GoogleMap.CancelableCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.MarkerOptionsCreator;
import com.google.android.maps.GeoPoint;

public class MainActivity extends FragmentActivity implements OnCameraChangeListener,  OnMapLongClickListener{
	
	GoogleMap googleMap;
	private CompoundButton mAnimateToggle;
	private CompoundButton mCustomDurationToggle;
	private SeekBar mCustomDurationBar;
	
	private CameraPosition mCameraPosition;

	private LatLngBounds mRegion;

	private int mMaxZoom, mMinZoom;
	
	
	private boolean mTouchEnabled = true;
	Geocoder geoCoder;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final Button btn = (Button)findViewById(R.id.btnsearch);
		final EditText txt = (EditText)findViewById(R.id.txtsearch);
		mRegion = new LatLngBounds(new LatLng(-12.270078, -77.175178), new LatLng(-11.822714, -77.942339));
		//mMaxZoom = 13;
		//mMinZoom = 1;
		System.out.println("Entro");	
		geoCoder = new Geocoder(this, Locale.getDefault());
		btn.setOnClickListener(ListenerSearch(txt.getText().toString()));
		setUpMapIfNeeded();
		
		
		
	}
	
	protected void onResume(){
		super.onResume();
		//updateEnabledState();
		setUpMapIfNeeded();
	}
	
public View.OnClickListener ListenerSearch(final String txt){
		
		View.OnClickListener listener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			try{
				List<Address> addresses = geoCoder.getFromLocationName(txt, 5);
				if (addresses.size() > 0){
					System.out.println("si hay datos y latidud es:"+ addresses.get(0).getLatitude());
					googleMap.clear();
					googleMap.addMarker(new MarkerOptions().position(new LatLng(addresses.get(0).getLatitude(), addresses.get(0).getLongitude())).title("Marker"));
				}
			} catch (IOException e){
				e.printStackTrace();
			}
			
		}
	};
		return listener;
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
		
		
		 // We will provide our own zoom controls.
		googleMap.getUiSettings().setZoomControlsEnabled(true);
		googleMap.setOnCameraChangeListener(this);
		googleMap.setOnMapLongClickListener(this);
		googleMap.setMyLocationEnabled(true);

        // Show Sydney
		googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-12.095, -77.008), 10));
    }

	
	private GoogleMap.CancelableCallback mCancelCallback = new GoogleMap.CancelableCallback() {
	    @Override
	    public void onFinish() {
	        mTouchEnabled = true;
	    }

	    @Override
	    public void onCancel() {

	    }
	};

	@Override
	public void onCameraChange(CameraPosition cameraPosition) {
		// TODO Auto-generated method stub
		//System.out.println("El CameraPosition.target: "+cameraPosition.target);
	    if(!mRegion.contains(cameraPosition.target)){
	        mTouchEnabled = false;
	        //CameraPosition cameraPosition1 = new CameraPosition(cameraPosition.target, mMaxZoom, cameraPosition.tilt, cameraPosition.bearing);
	        //googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition1), mCancelCallback);
	        //System.out.println("esta entrando 1");
	        //googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-12.095, -77.008), 10));
	        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-12.095, -77.008), 10));
	       
	    } 
	}

	@Override
	public void onMapLongClick(LatLng x) {
		// TODO Auto-generated method stub
		googleMap.clear();
		googleMap.addMarker(new MarkerOptions().position(x).title("Marker"));
		//googleMap.setTrafficEnabled(true);
		//googleMap.setMyLocationEnabled(true);
	}
	
	
}
