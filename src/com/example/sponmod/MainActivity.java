package com.example.sponmod;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends Activity implements OnClickListener {
	
    public static final String PREFS_NAME = "sponmod_settings";
	private Button Button_berechnung;
	public Spinner stechnik;
	public Spinner stechnikzk;
	public Spinner shalbzd;
	public Spinner sdoppelzd;
	public Spinner serzwingen;
	public Spinner skostensparen;
	public Spinner swirkreichgross;
	public Spinner swirkreichklein;
	public Spinner sunfreiwillig;
	public Spinner sfreiwillig;
	public Spinner shalbwd;
	public Spinner sdoppelwd;
	public Spinner saufrechtfest;
	public String [] spinner_technik_text = {"0","1","2","3","4","5","6"};
	public String [] spinner_kostensparen_text = {"0","1","2","3","4","5"}; //darf maximal die Hälfte der Grundkosten sein
	public String [] spinner_nulleins_text = {"0","1"};
    public boolean gildenmagiercb; 
    public boolean elfcb;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	    //load settings
		SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
	    gildenmagiercb = settings.getBoolean("gildenmagier_settings", false);
	    elfcb = settings.getBoolean("elf_settings", false);

        //Listeneinträge konfigurieren
		stechnik = (Spinner)findViewById(R.id.spinner_technik);
		ArrayAdapter<CharSequence> adapter_stechnik = new ArrayAdapter<CharSequence>(this,android.R.layout.simple_spinner_dropdown_item,spinner_technik_text);
		stechnik.setAdapter(adapter_stechnik);
		stechnikzk = (Spinner)findViewById(R.id.spinner_technikzk);
		ArrayAdapter<CharSequence> adapter_stechnikzk = new ArrayAdapter<CharSequence>(this,android.R.layout.simple_spinner_dropdown_item,spinner_technik_text);
		stechnikzk.setAdapter(adapter_stechnikzk);
		shalbzd = (Spinner)findViewById(R.id.spinner_halbzd);
		ArrayAdapter<CharSequence> adapter_shalbzd = new ArrayAdapter<CharSequence>(this,android.R.layout.simple_spinner_dropdown_item,spinner_technik_text);
		shalbzd.setAdapter(adapter_shalbzd);
		sdoppelzd = (Spinner)findViewById(R.id.spinner_doppelzd);
		ArrayAdapter<CharSequence> adapter_sdoppelzd = new ArrayAdapter<CharSequence>(this,android.R.layout.simple_spinner_dropdown_item,spinner_nulleins_text);
		sdoppelzd.setAdapter(adapter_sdoppelzd);
		serzwingen = (Spinner)findViewById(R.id.spinner_erzwingen);
		ArrayAdapter<CharSequence> adapter_serzwingen = new ArrayAdapter<CharSequence>(this,android.R.layout.simple_spinner_dropdown_item,spinner_technik_text);
		serzwingen.setAdapter(adapter_serzwingen);
		skostensparen = (Spinner)findViewById(R.id.spinner_kostensparen);
		ArrayAdapter<CharSequence> adapter_skostensparen = new ArrayAdapter<CharSequence>(this,android.R.layout.simple_spinner_dropdown_item,spinner_kostensparen_text);
		skostensparen.setAdapter(adapter_skostensparen);
		swirkreichgross = (Spinner)findViewById(R.id.spinner_wirkreichgross);
		ArrayAdapter<CharSequence> adapter_swirkreichgross = new ArrayAdapter<CharSequence>(this,android.R.layout.simple_spinner_dropdown_item,spinner_technik_text);
		swirkreichgross.setAdapter(adapter_swirkreichgross);
		swirkreichklein = (Spinner)findViewById(R.id.spinner_wirkreichklein);
		ArrayAdapter<CharSequence> adapter_swirkreichklein = new ArrayAdapter<CharSequence>(this,android.R.layout.simple_spinner_dropdown_item,spinner_technik_text);
		swirkreichklein.setAdapter(adapter_swirkreichklein);
		sunfreiwillig = (Spinner)findViewById(R.id.spinner_unfreiwillig);
		ArrayAdapter<CharSequence> adapter_sunfreiwillig = new ArrayAdapter<CharSequence>(this,android.R.layout.simple_spinner_dropdown_item,spinner_nulleins_text);
		sunfreiwillig.setAdapter(adapter_sunfreiwillig);
		sfreiwillig = (Spinner)findViewById(R.id.spinner_freiwillig);
		ArrayAdapter<CharSequence> adapter_sfreiwillig = new ArrayAdapter<CharSequence>(this,android.R.layout.simple_spinner_dropdown_item,spinner_nulleins_text);
		sfreiwillig.setAdapter(adapter_sfreiwillig);
		shalbwd = (Spinner)findViewById(R.id.spinner_halbwd);
		ArrayAdapter<CharSequence> adapter_shalbwd = new ArrayAdapter<CharSequence>(this,android.R.layout.simple_spinner_dropdown_item,spinner_technik_text);
		shalbwd.setAdapter(adapter_shalbwd);
		sdoppelwd = (Spinner)findViewById(R.id.spinner_doppelwd);
		ArrayAdapter<CharSequence> adapter_sdoppelwd = new ArrayAdapter<CharSequence>(this,android.R.layout.simple_spinner_dropdown_item,spinner_technik_text);
		sdoppelwd.setAdapter(adapter_sdoppelwd);
		saufrechtfest = (Spinner)findViewById(R.id.spinner_aufrechtfest);
		ArrayAdapter<CharSequence> adapter_saufrechtfest = new ArrayAdapter<CharSequence>(this,android.R.layout.simple_spinner_dropdown_item,spinner_technik_text);
		saufrechtfest.setAdapter(adapter_saufrechtfest);

		
		if (gildenmagiercb) {
		  CheckBox checkBox = (CheckBox)findViewById(R.id.checkBox_gildenmagier);
		  checkBox.setChecked(true);
		}
		if (elfcb) {
			  CheckBox checkBox = (CheckBox)findViewById(R.id.checkBox_elf);
			  checkBox.setChecked(true);
		}
		
		
		//Button Aktion initialisieren
		Button_berechnung = (Button)findViewById(R.id.button_berechnen_start);
		Button_berechnung.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
            new AlertDialog.Builder(this).setMessage(
                    R.string.info_text_settings).setNeutralButton(
                    R.string.error_ok,
                    null).show();

			return true;
		}
		if (id == R.id.reichweite_info) {
            new AlertDialog.Builder(this).setMessage(
                    R.string.reichweite_info_text).setNeutralButton(
                    R.string.error_ok,
                    null).show();

			return true;
		}

		if (id == R.id.sonstige_info) {
			Intent intent = new Intent();
		    intent.setClass(this,InfoText.class);
		    startActivity(intent);

			return true;
		}

		return super.onOptionsItemSelected(item);
	}
	
	public void onCheckboxClicked(View view) {
	    // Is the view checked?
	    boolean checked = ((CheckBox) view).isChecked();
		CheckBox cbgildenmagier = (CheckBox) findViewById(R.id.checkBox_gildenmagier);
		CheckBox cbelf = (CheckBox) findViewById(R.id.checkBox_elf);
		
	    // welche wurde angeklickt
	    switch(view.getId()) {
	        case R.id.checkBox_gildenmagier:
	        	if (checked) {
	              cbelf.setChecked(false);
	        	}
	            break;
	        case R.id.checkBox_elf:
	            if (checked) {
	              cbgildenmagier.setChecked(false);
	            }
	            break;
	    }
	}
	
	@Override
	public void onClick(View v) {
		TextView zfwdiffausgabe = (TextView) findViewById(R.id.zfw_diff_ausgabe_feld);
		TextView zddiffausgabe = (TextView) findViewById(R.id.zd_diff_ausgabe_feld);
		TextView aspdiffausgabe = (TextView) findViewById(R.id.asp_diff_ausgabe_feld);
		TextView zfwergausgabe = (TextView) findViewById(R.id.zfw_erg_ausgabe_feld);
		TextView zdergausgabe = (TextView) findViewById(R.id.zd_erg_ausgabe_feld);
		TextView aspergausgabe = (TextView) findViewById(R.id.asp_erg_ausgabe_feld);
		TextView techniklabel = (TextView) findViewById(R.id.spinner_technik_label);
		TextView technikzklabel = (TextView) findViewById(R.id.spinner_technikzk_label);
		TextView halbzdlabel = (TextView) findViewById(R.id.spinner_halbzd_label);
		TextView doppelzdlabel = (TextView) findViewById(R.id.spinner_doppelzd_label);
		TextView erzwingenlabel = (TextView) findViewById(R.id.spinner_erzwingen_label);
		TextView kostensparenlabel = (TextView) findViewById(R.id.spinner_kostensparen_label);
		TextView wirkreichgrosslabel = (TextView) findViewById(R.id.spinner_wirkreichgross_label);
		TextView wirkreichkleinlabel = (TextView) findViewById(R.id.spinner_wirkreichklein_label);
		TextView unfreiwilliglabel = (TextView) findViewById(R.id.spinner_unfreiwillig_label);
		TextView freiwilliglabel = (TextView) findViewById(R.id.spinner_freiwillig_label);
		TextView halbwdlabel = (TextView) findViewById(R.id.spinner_halbwd_label);
		TextView doppelwdlabel = (TextView) findViewById(R.id.spinner_doppelwd_label);
		TextView aufrechtfestlabel = (TextView) findViewById(R.id.spinner_aufrechtfest_label);
		TextView zusatzinfolabel = (TextView) findViewById(R.id.zusatz_info_label);
		TextView zusatzmrtext = (TextView) findViewById(R.id.zusatz_mr_text);
		
		//Eingabefelder suchen
		EditText zfweingabe = (EditText) findViewById(R.id.zfw_eingabe);
		EditText zdeingabe = (EditText) findViewById(R.id.zd_eingabe);
		EditText aspeingabe = (EditText) findViewById(R.id.asp_eingabe);
		CheckBox cbgildenmagier = (CheckBox) findViewById(R.id.checkBox_gildenmagier);
		CheckBox cbelf = (CheckBox) findViewById(R.id.checkBox_elf);
		Spinner spinnertechnik = (Spinner) findViewById(R.id.spinner_technik);
        Spinner spinnertechnikzk = (Spinner) findViewById(R.id.spinner_technikzk);
        Spinner spinnerhalbzd = (Spinner) findViewById(R.id.spinner_halbzd);
        Spinner spinnerdoppelzd = (Spinner) findViewById(R.id.spinner_doppelzd);
        Spinner spinnererzwingen = (Spinner) findViewById(R.id.spinner_erzwingen);
        Spinner spinnerkostensparen = (Spinner) findViewById(R.id.spinner_kostensparen);
        Spinner spinnerwirkreichgross = (Spinner) findViewById(R.id.spinner_wirkreichgross);
        Spinner spinnerwirkreichklein = (Spinner) findViewById(R.id.spinner_wirkreichklein);
        Spinner spinnerunfreiwillig = (Spinner) findViewById(R.id.spinner_unfreiwillig);
        Spinner spinnerfreiwillig = (Spinner) findViewById(R.id.spinner_freiwillig);
        Spinner spinnerhalbwd = (Spinner) findViewById(R.id.spinner_halbwd);
        Spinner spinnerdoppelwd = (Spinner) findViewById(R.id.spinner_doppelwd);
        Spinner spinneraufrechtfest = (Spinner) findViewById(R.id.spinner_aufrechtfest);
        
        
		//leere Eingabe abfangen
		if (zfweingabe.getText().length() == 0 || zdeingabe.getText().length() == 0 || aspeingabe.getText().length() == 0) {
            new AlertDialog.Builder(this).setMessage(
                    R.string.error_name_missing).setNeutralButton(
                    R.string.error_ok,
                    null).show();
            return;
        }
		
		//Gildenmagier und Elf geht nicht
		if (cbgildenmagier.isChecked() && cbelf.isChecked()) {
			  cbelf.setChecked(false);
	          new AlertDialog.Builder(this).setMessage(
	              R.string.error_gildenmagier_elf).setNeutralButton(
	              R.string.error_ok,
	              null).show();
	          return;
		}
		
		int technik_wert_int = Integer.parseInt(String.valueOf(spinnertechnik.getSelectedItem()));
		int technikzk_wert_int = Integer.parseInt(String.valueOf(spinnertechnikzk.getSelectedItem()));
		int halbzd_wert_int = Integer.parseInt(String.valueOf(spinnerhalbzd.getSelectedItem()));
		int doppelzd_wert_int = Integer.parseInt(String.valueOf(spinnerdoppelzd.getSelectedItem()));
		int erzwingen_wert_int = Integer.parseInt(String.valueOf(spinnererzwingen.getSelectedItem()));
		int kostensparen_wert_int = Integer.parseInt(String.valueOf(spinnerkostensparen.getSelectedItem()));
		int wirkreichgross_wert_int = Integer.parseInt(String.valueOf(spinnerwirkreichgross.getSelectedItem()));
		int wirkreichklein_wert_int = Integer.parseInt(String.valueOf(spinnerwirkreichklein.getSelectedItem()));
		int unfreiwillig_wert_int = Integer.parseInt(String.valueOf(spinnerunfreiwillig.getSelectedItem()));
		int freiwillig_wert_int = Integer.parseInt(String.valueOf(spinnerfreiwillig.getSelectedItem()));
		int halbwd_wert_int = Integer.parseInt(String.valueOf(spinnerhalbwd.getSelectedItem()));
		int doppelwd_wert_int = Integer.parseInt(String.valueOf(spinnerdoppelwd.getSelectedItem()));
		int aufrechtfest_wert_int = Integer.parseInt(String.valueOf(spinneraufrechtfest.getSelectedItem()));
		
		int zfw_wert_int = Integer.parseInt(zfweingabe.getText().toString());
        int zd_wert_int = Integer.parseInt(zdeingabe.getText().toString());
        double asp_wert_int = Integer.parseInt(aspeingabe.getText().toString());
        
        double zfw_wert_erg = zfw_wert_int;
        double zd_wert_erg = zd_wert_int;
        double asp_wert_erg = asp_wert_int;
        double zfw_diff_akt = 0;
        double zd_diff_akt = zd_wert_int;
        double asp_diff_akt = 0;
        double zfw_technik_wert = 0;
        double zd_technik_wert = 0;
        double zfw_technikzk_wert = 0;
        double zd_technikzk_wert = 0;
        double zfw_halbzd_wert = 0;
        double zd_halbzd_wert = 1;  //wird multipliziert
        double zfw_doppelzd_wert = 0;
        double zd_doppelzd_wert = 1;  //wird multipliziert
        double zfw_erzwingen_wert = 0;
        double zd_erzwingen_wert = 0;
        double asp_erzwingen_wert = 0;
        double zfw_kostensparen_wert = 0;
        double zd_kostensparen_wert = 0;
        double asp_kostensparen_wert = 0;
        double zfw_wirkreichgross_wert = 0;
        double zd_wirkreichgross_wert = 0;
        double asp_wirkreichgross_wert = 0;
        double zfw_wirkreichklein_wert = 0;
        double zd_wirkreichklein_wert = 0;
        double zfw_unfreiwillig_wert = 0;
        double zd_unfreiwillig_wert = 0;
        double zfw_freiwillig_wert = 0;
        double zd_freiwillig_wert = 0;
        double zfw_halbwd_wert = 0;
        double zd_halbwd_wert = 0;
        double asp_halbwd_wert = 0;
        double zfw_doppelwd_wert = 0;
        double zd_doppelwd_wert = 0;
        double zfw_aufrechtfest_wert = 0;
        double zd_aufrechtfest_wert = 0;
        String mr_text = "";
        String zd_text = "";

        int anzahl_sponmods = 0;
               
        
        if (technik_wert_int > 0) {
        	zfw_technik_wert = technik_wert_int * 7;
        	zd_technik_wert = technik_wert_int * 3;
        	anzahl_sponmods = anzahl_sponmods + technik_wert_int;
        	techniklabel.setText(String.valueOf(getApplicationContext().getResources().getString(R.string.technik_label_text) + " (" + Double.toString(zfw_technik_wert) + "/" + Double.toString(zd_technik_wert) + ")"));
        } else {
        	techniklabel.setText(String.valueOf(getApplicationContext().getResources().getString(R.string.technik_label_text)));
        }

        if (technikzk_wert_int > 0) {
        	zfw_technikzk_wert = technikzk_wert_int * 12;
        	zd_technikzk_wert = technikzk_wert_int * 3;
        	anzahl_sponmods = anzahl_sponmods + technikzk_wert_int;
        	technikzklabel.setText(String.valueOf(getApplicationContext().getResources().getString(R.string.technikzk_label_text) + " (" + Double.toString(zfw_technikzk_wert) + "/" + Double.toString(zd_technikzk_wert) + ")"));
        } else {
        	technikzklabel.setText(String.valueOf(getApplicationContext().getResources().getString(R.string.technikzk_label_text)));
        }

        if (halbzd_wert_int > 0) {
        	zfw_halbzd_wert = halbzd_wert_int * 5;
        	//zd am Ende erst
        	zd_halbzd_wert = (Math.pow(0.5, halbzd_wert_int));
        	int zd_halbzd_wert_int = (int) (1 / zd_halbzd_wert);
        	zd_text = "/" + String.valueOf(zd_halbzd_wert_int);
        	anzahl_sponmods = anzahl_sponmods + halbzd_wert_int;
  	    	halbzdlabel.setText(String.valueOf(getApplicationContext().getResources().getString(R.string.halbzd_label_text) + " (" + Double.toString(zfw_halbzd_wert) + "/ *" + Double.toString(zd_halbzd_wert) + ")"));
        } else {
        	halbzdlabel.setText(String.valueOf(getApplicationContext().getResources().getString(R.string.halbzd_label_text)));
        }

        if (doppelzd_wert_int > 0 && halbzd_wert_int == 0) {
        	//wenn Gildenmagier dann -4   erst halbieren dann abziehen für Gildi
            if (cbgildenmagier.isChecked()) {
            	zfw_doppelzd_wert = -4;
            } else {
            	zfw_doppelzd_wert = -3;
            }
        	zd_doppelzd_wert = 2;
        	zd_text = "*2";
        	anzahl_sponmods = anzahl_sponmods + doppelzd_wert_int;
  	    	doppelzdlabel.setText(String.valueOf(getApplicationContext().getResources().getString(R.string.doppelzd_label_text) + " (" + Double.toString(zfw_doppelzd_wert) + "/ *" + Double.toString(zd_doppelzd_wert) + ")"));
        } else if (doppelzd_wert_int > 0 && halbzd_wert_int > 0){
        	doppelzdlabel.setText(String.valueOf(getApplicationContext().getResources().getString(R.string.doppelzd_label_text) + " (" + getApplicationContext().getResources().getString(R.string.error_halb_und_doppel) +")"));        	
        } else  {
        	doppelzdlabel.setText(String.valueOf(getApplicationContext().getResources().getString(R.string.doppelzd_label_text)));
        }
        
        if (erzwingen_wert_int > 0) {
        	//zfw wird erst halbiert bei Gildenmagier dann abgezogen!
        	zfw_erzwingen_wert = -erzwingen_wert_int;
        	zd_erzwingen_wert = erzwingen_wert_int;
        	asp_erzwingen_wert = Math.pow(2, erzwingen_wert_int-1);
        	anzahl_sponmods = anzahl_sponmods + 1;
        	erzwingenlabel.setText(String.valueOf(getApplicationContext().getResources().getString(R.string.erzwingen_label_text) + " (" + Double.toString(zfw_erzwingen_wert) + "/" + Double.toString(zd_erzwingen_wert) + "/" + Double.toString(asp_erzwingen_wert) + ")"));
        } else {
        	erzwingenlabel.setText(String.valueOf(getApplicationContext().getResources().getString(R.string.erzwingen_label_text)));
        }

        if (kostensparen_wert_int > 0 && erzwingen_wert_int == 0) {
        	//zfw wird erst halbiert bei Gildenmagier dann abgezogen!
        	zfw_kostensparen_wert = kostensparen_wert_int * 3;
        	zd_kostensparen_wert = kostensparen_wert_int;
        	//asp Kosten maximal die Hälfte des Grundwerts
        	asp_kostensparen_wert = -Math.round(((kostensparen_wert_int * 0.1) * asp_wert_int) * 100) / 100.0;
        	if (Math.abs(asp_kostensparen_wert) < kostensparen_wert_int) {
        		asp_kostensparen_wert = -kostensparen_wert_int;
        	}
        	anzahl_sponmods = anzahl_sponmods + kostensparen_wert_int;
        	kostensparenlabel.setText(String.valueOf(getApplicationContext().getResources().getString(R.string.kostensparen_label_text) + " (" + Double.toString(zfw_kostensparen_wert) + "/" + Double.toString(zd_kostensparen_wert) + "/" + Double.toString(asp_kostensparen_wert) + ")"));
        } else if (kostensparen_wert_int > 0 && erzwingen_wert_int > 0) {
        	kostensparenlabel.setText(String.valueOf(getApplicationContext().getResources().getString(R.string.kostensparen_label_text) + " (" + getApplicationContext().getResources().getString(R.string.error_erzwing_und_kostensparen) +")"));
        } else {
        	kostensparenlabel.setText(String.valueOf(getApplicationContext().getResources().getString(R.string.kostensparen_label_text)));
        }

        if (wirkreichgross_wert_int > 0) {
        	zfw_wirkreichgross_wert = wirkreichgross_wert_int * 5;
        	zd_wirkreichgross_wert = wirkreichgross_wert_int;
        	asp_wirkreichgross_wert = asp_wert_int * 4 * wirkreichgross_wert_int;
        	anzahl_sponmods = anzahl_sponmods + wirkreichgross_wert_int;
        	wirkreichgrosslabel.setText(String.valueOf(getApplicationContext().getResources().getString(R.string.wirkreichgross_label_text) + " (" + Double.toString(zfw_wirkreichgross_wert) + "/" + Double.toString(zd_wirkreichgross_wert) + "/+" + Double.toString(asp_wirkreichgross_wert) + getApplicationContext().getResources().getString(R.string.asp_wirkreichgross_info_text) + ")"));
        } else {
        	wirkreichgrosslabel.setText(String.valueOf(getApplicationContext().getResources().getString(R.string.wirkreichgross_label_text)));
        }
        
        if (wirkreichklein_wert_int > 0) {
        	zfw_wirkreichklein_wert = wirkreichklein_wert_int * 3;
        	zd_wirkreichklein_wert = wirkreichklein_wert_int;
        	anzahl_sponmods = anzahl_sponmods + wirkreichklein_wert_int;
        	wirkreichkleinlabel.setText(String.valueOf(getApplicationContext().getResources().getString(R.string.wirkreichklein_label_text) + " (" + Double.toString(zfw_wirkreichklein_wert) + "/" + Double.toString(zd_wirkreichklein_wert) + ")"));
        } else {
        	wirkreichkleinlabel.setText(String.valueOf(getApplicationContext().getResources().getString(R.string.wirkreichklein_label_text)));
        }

        if (unfreiwillig_wert_int > 0) {
        	zfw_unfreiwillig_wert = unfreiwillig_wert_int * 5;
        	zd_unfreiwillig_wert = unfreiwillig_wert_int;
        	anzahl_sponmods = anzahl_sponmods + unfreiwillig_wert_int;
        	mr_text = " +MR";
        	unfreiwilliglabel.setText(String.valueOf(getApplicationContext().getResources().getString(R.string.unfreiwillig_label_text) + " (" + Double.toString(zfw_unfreiwillig_wert) + "/" + Double.toString(zd_unfreiwillig_wert) + ")"));
        } else {
        	unfreiwilliglabel.setText(String.valueOf(getApplicationContext().getResources().getString(R.string.unfreiwillig_label_text)));
        }

        if (freiwillig_wert_int > 0 && unfreiwillig_wert_int == 0) {
        	zfw_freiwillig_wert = freiwillig_wert_int * 2;
        	zd_freiwillig_wert = freiwillig_wert_int;
        	anzahl_sponmods = anzahl_sponmods + freiwillig_wert_int;
        	mr_text = " +1/2MR";
        	freiwilliglabel.setText(String.valueOf(getApplicationContext().getResources().getString(R.string.freiwillig_label_text) + " (" + Double.toString(zfw_freiwillig_wert) + "/" + Double.toString(zd_freiwillig_wert) + ")"));
        } else if (freiwillig_wert_int > 0 && unfreiwillig_wert_int > 0){
        	freiwilliglabel.setText(String.valueOf(getApplicationContext().getResources().getString(R.string.freiwillig_label_text) + " (" + getApplicationContext().getResources().getString(R.string.error_frei_und_unfrei) +")"));        	
        } else {
        	freiwilliglabel.setText(String.valueOf(getApplicationContext().getResources().getString(R.string.freiwillig_label_text)));
        }
        
        if (halbwd_wert_int > 0) {
        	zfw_halbwd_wert = halbwd_wert_int * 3;
        	zd_halbwd_wert = halbwd_wert_int;
        	double halbwd_wert_double = (double) halbwd_wert_int;
        	asp_halbwd_wert = -Math.round((Math.pow(0.33333333, halbwd_wert_double) * asp_wert_int) * 100 ) / 100.0 ;
        	//ASP Kostensparen neu berechnen da Grundwert neu
        	if (kostensparen_wert_int > 0) {
        	    asp_kostensparen_wert = -Math.round(((kostensparen_wert_int * 0.1) * (asp_halbwd_wert + asp_wert_int)) * 100) / 100.0;
        	    kostensparenlabel.setText(String.valueOf(getApplicationContext().getResources().getString(R.string.kostensparen_label_text) + " (" + Double.toString(zfw_kostensparen_wert) + "/" + Double.toString(zd_kostensparen_wert) + "/" + Double.toString(asp_kostensparen_wert) + ")"));
        	}
        	anzahl_sponmods = anzahl_sponmods + halbwd_wert_int;
        	halbwdlabel.setText(String.valueOf(getApplicationContext().getResources().getString(R.string.halbwd_label_text) + " (" + Double.toString(zfw_halbwd_wert) + "/" + Double.toString(zd_halbwd_wert) + "/" + Double.toString(asp_halbwd_wert) + ")"));
        } else {
        	halbwdlabel.setText(String.valueOf(getApplicationContext().getResources().getString(R.string.halbwd_label_text)));
        }

        if (doppelwd_wert_int > 0) {
        	if (cbelf.isChecked()) {
        	  zfw_doppelwd_wert = doppelwd_wert_int * 4;
        	} else {
          	  zfw_doppelwd_wert = doppelwd_wert_int * 7;        		
        	}
        	zd_doppelwd_wert = doppelwd_wert_int;
        	anzahl_sponmods = anzahl_sponmods + doppelwd_wert_int;
        	doppelwdlabel.setText(String.valueOf(getApplicationContext().getResources().getString(R.string.doppelwd_label_text) + " (" + Double.toString(zfw_doppelwd_wert) + "/" + Double.toString(zd_doppelwd_wert) + ")"));
        } else {
        	doppelwdlabel.setText(String.valueOf(getApplicationContext().getResources().getString(R.string.doppelwd_label_text)));
        }
        
        if (aufrechtfest_wert_int > 0) {
        	zfw_aufrechtfest_wert = aufrechtfest_wert_int * 7;
        	zd_aufrechtfest_wert = aufrechtfest_wert_int;
        	anzahl_sponmods = anzahl_sponmods + aufrechtfest_wert_int;
        	aufrechtfestlabel.setText(String.valueOf(getApplicationContext().getResources().getString(R.string.aufrechtfest_label_text) + " (" + Double.toString(zfw_aufrechtfest_wert) + "/" + Double.toString(zd_aufrechtfest_wert) + ")"));
        } else {
        	aufrechtfestlabel.setText(String.valueOf(getApplicationContext().getResources().getString(R.string.aufrechtfest_label_text)));
        }
        
        
        //Ergebnisse berechnen
        if (cbgildenmagier.isChecked()) {
        	zfw_diff_akt = ((zfw_technik_wert + zfw_technikzk_wert + zfw_halbzd_wert + zfw_kostensparen_wert + zfw_wirkreichgross_wert + zfw_wirkreichklein_wert + zfw_unfreiwillig_wert + zfw_freiwillig_wert + zfw_halbwd_wert + zfw_doppelwd_wert + zfw_aufrechtfest_wert) / 2) + zfw_doppelzd_wert + zfw_erzwingen_wert;
        } else {
        	zfw_diff_akt = zfw_technik_wert + zfw_technikzk_wert + zfw_halbzd_wert + zfw_kostensparen_wert + zfw_wirkreichgross_wert + zfw_wirkreichklein_wert + zfw_doppelzd_wert + zfw_erzwingen_wert + zfw_unfreiwillig_wert + zfw_freiwillig_wert + zfw_halbwd_wert + zfw_doppelwd_wert + zfw_aufrechtfest_wert;
        }
        
        zd_diff_akt = (zd_technik_wert + zd_technikzk_wert + zd_erzwingen_wert + zd_kostensparen_wert + zd_wirkreichgross_wert + zd_wirkreichklein_wert + zd_unfreiwillig_wert + zd_freiwillig_wert + zd_halbwd_wert + zd_doppelwd_wert + zd_aufrechtfest_wert);
        //Zauberdauer erst, verdoppeln oder halbieren nachdem alle anderen eingerechnet sind
        zd_wert_erg = (zd_wert_int + zd_technik_wert + zd_technikzk_wert + zd_erzwingen_wert + zd_kostensparen_wert + zd_wirkreichgross_wert + zd_wirkreichklein_wert + zd_unfreiwillig_wert + zd_freiwillig_wert + zd_halbwd_wert + zd_doppelwd_wert + zd_aufrechtfest_wert) * zd_halbzd_wert * zd_doppelzd_wert;
        //niemals weniger als 1
        if (zd_wert_erg < 1) { zd_wert_erg = 1; } 
        
        asp_diff_akt = Math.round((asp_kostensparen_wert + asp_erzwingen_wert) * 100) / 100.0;
        if (halbwd_wert_int > 0) {
        	// asp_wert_erg = asp_halbwd_wert + asp_diff_akt;
        	asp_diff_akt = asp_halbwd_wert + asp_diff_akt;
        } else {
        	// asp_wert_erg = asp_wert_int + asp_diff_akt;
        }
        asp_diff_akt =  Math.round((asp_diff_akt) * 100) / 100.0;
        int asp_diff_akt_int = (int) (asp_diff_akt);
        asp_wert_erg = asp_wert_int + asp_diff_akt_int;
        
        zfw_wert_erg = Math.round(zfw_wert_int - (zfw_diff_akt + 0.1));
		int zfw_wert_erg_int = (int) (zfw_wert_erg); 
        
        // Ausgabe
		zfwdiffausgabe.setText(String.valueOf(Double.toString(zfw_diff_akt)));
		if (zd_diff_akt > 0) {
		  zddiffausgabe.setText(String.valueOf("+" + Double.toString(zd_diff_akt) + zd_text));
		} else {
	      zddiffausgabe.setText(String.valueOf(Double.toString(zd_diff_akt) + zd_text));
		}
		aspdiffausgabe.setText(String.valueOf(Double.toString(asp_diff_akt)));
		
		if (zfw_wert_erg > zfw_wert_int) { 
			zfw_wert_erg_int = zfw_wert_int;
			zfwergausgabe.setText(String.valueOf(zfw_wert_erg_int) + " max!");
		} else {
		    zfwergausgabe.setText(String.valueOf(zfw_wert_erg_int));
		}
		
		zusatzmrtext.setText(mr_text);
		
		// immer auf nächsthöhere Ganzzahlrunden, sobald größer als eine Ganzzahl
		if (zd_wert_erg != Math.floor(zd_wert_erg)) {
		  zd_wert_erg = Math.floor(zd_wert_erg) + 1;
		}
		int zd_wert_erg_int = (int) (zd_wert_erg); 
		zdergausgabe.setText(String.valueOf(zd_wert_erg_int));
	
		asp_wert_erg = Math.round((asp_wert_erg) * 100) / 100.0;
		int asp_wert_erg_int = (int) (asp_wert_erg);
		if (asp_wert_erg_int < 1) { 
			asp_wert_erg_int = 1;
			aspergausgabe.setText(String.valueOf(asp_wert_erg_int) + " min!");
		} else {
			aspergausgabe.setText(String.valueOf(asp_wert_erg_int));
		}
		
		if (anzahl_sponmods > 0) {
			zusatzinfolabel.setText(String.valueOf(Integer.toString(anzahl_sponmods)) + " " + getApplicationContext().getResources().getString(R.string.anzahl_sponmod_text));
		} else {
			zusatzinfolabel.setText(String.valueOf(""));
		}
		
	}
	
    @Override
    protected void onStop(){
       super.onStop();

       // Einstellungen speichern
       CheckBox cbgildenmagier = (CheckBox) findViewById(R.id.checkBox_gildenmagier);
       if (cbgildenmagier.isChecked()) {
         gildenmagiercb = true;
       } else {
         gildenmagiercb = false;
       }
       CheckBox cbelf = (CheckBox) findViewById(R.id.checkBox_elf);
       if (cbelf.isChecked()) {
         elfcb = true;
       } else {
         elfcb = false;
       }

       SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
       SharedPreferences.Editor editor = settings.edit();
       editor.putBoolean("gildenmagier_settings", gildenmagiercb);
       editor.putBoolean("elf_settings", elfcb);
       // Commit the edits!
       editor.commit();
    }
	
}