package cientyproducciones.qmbiapad;

import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Switch;
import android.media.SoundPool;

import static android.media.AudioManager.STREAM_MUSIC;


public class MainActivity extends AppCompatActivity {

    Button pad1, pad2, pad3, pad4, pad5, pad6, pad7, pad8, aux;

    public SoundPool sp, sp2, sp3, sp4, sp5, sp6, sp7, sp8, cen, agu, gra, spl, bor;
    public int song = 0;
    public int songb = 0;
    public int songc = 0;
    public int songd = 0;
    public int songe = 0;
    public int songf = 0;
    public int songg = 0;
    public int songh = 0;
    public int songi = 0;
    public int songj = 0;
    public int songk = 0;
    public int songl = 0;
    public int songm = 0;
    public Switch sw;

    public int lo = 0;//Variable para activar el plato en la tumba

    @Override
    public void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);//SACAR LA BARRA DE TITULO

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        sw = (Switch) findViewById(R.id.switch1);

        //CARGAR LOS PADS PARA SOUNDPOOL
        sp = new SoundPool(1, AudioManager.STREAM_MUSIC, 1);
        song = sp.load(this, R.raw.pad1, 1);
        sp2 = new SoundPool(1, AudioManager.STREAM_MUSIC, 1);
        songb = sp2.load(this, R.raw.pad2, 1);
        sp3 = new SoundPool(1, AudioManager.STREAM_MUSIC, 1);
        songc = sp3.load(this, R.raw.pad3, 1);
        sp4 = new SoundPool(1, AudioManager.STREAM_MUSIC, 1);
        songd = sp4.load(this, R.raw.pad4, 1);
        sp5 = new SoundPool(1, AudioManager.STREAM_MUSIC, 1);
        songe = sp5.load(this, R.raw.pad5, 1);
        sp6 = new SoundPool(1, AudioManager.STREAM_MUSIC, 1);
        songf = sp6.load(this, R.raw.pad6, 1);
        sp7 = new SoundPool(1, AudioManager.STREAM_MUSIC, 1);
        songg = sp7.load(this, R.raw.pad7, 1);
        sp8 = new SoundPool(1, AudioManager.STREAM_MUSIC, 1);
        songh = sp8.load(this, R.raw.pad8, 1);
        cen = new SoundPool(1, AudioManager.STREAM_MUSIC, 1);
        songi = cen.load(this, R.raw.cen, 1);
        agu = new SoundPool(1, AudioManager.STREAM_MUSIC, 1);
        songj = agu.load(this, R.raw.agudo, 1);
        gra = new SoundPool(1, AudioManager.STREAM_MUSIC, 1);
        songk = gra.load(this, R.raw.grave, 1);
        spl = new SoundPool(1, AudioManager.STREAM_MUSIC, 1);
        songl = spl.load(this, R.raw.splash, 1);
        bor = new SoundPool(1, AudioManager.STREAM_MUSIC, 1);
        songm = bor.load(this, R.raw.bord, 1);

        this.setVolumeControlStream(STREAM_MUSIC);//Activar el control de volumen multimedia

        pad1 = (Button) findViewById(R.id.pad1);
        pad2 = (Button) findViewById(R.id.pad2);
        pad3 = (Button) findViewById(R.id.pad3);
        pad4 = (Button) findViewById(R.id.pad4);
        pad5 = (Button) findViewById(R.id.pad5);
        pad6 = (Button) findViewById(R.id.pad6);
        pad7 = (Button) findViewById(R.id.pad7);
        pad8 = (Button) findViewById(R.id.pad8);

        //aux=(Button) findViewById(R.id.aux);

        //CAMBIAR LOS NOMBRES CON EL SWITCH
        sw.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (sw.isChecked()) {
                    pad2.setText("conga");
                    pad3.setText("Tumba");
                    //aux.setVisibility();
                } else {
                    pad2.setText("Tumba");
                    pad3.setText("cencerro");
                }
                return false;
            }
        });

        //REPRODUCCION DE LOS PADS INFERIORES

        pad1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    if (sw.isChecked()) {
                        sp.play(song, 1, 1, 1, 0, 1);//bombo
                        bor.play(songm, 1, 1, 1, 0, 1);//borde timbal

                    } else {
                        sp.play(song, 1, 1, 1, 0, 1);//bombo
                    }
                }
                return false;
            }
        });
        pad2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    if (sw.isChecked()) {
                        sp3.play(songc, 1, 1, 1, 0, 1);//tumbadora
                        if (lo == 1) {
                            spl.play(songl, 1, 1, 1, 0, 1);//reproducir al platillo con la tumba al activar
                        }
                    } else {
                        sp2.play(songb, 1, 1, 1, 0, 1);//Conga

                    }
                }
                return false;
            }
        });
        pad3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    if (sw.isChecked()) {
                        sp4.play(songd, 1, 1, 1, 0, 1);//guiro
                        cen.play(songi, 1, 1, 1, 0, 1);//cencerro
                        lo = 1;//activa el valor del plato

                    } else {
                        sp3.play(songc, 1, 1, 1, 0, 1);//tumba

                    }
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    lo = 0;//desactivar el sonido del plato con la tumba
                }
                return false;
            }
        });
        pad4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    if (sw.isChecked()) {
                        sp4.play(songd, 1, 1, 1, 0, 1);//guiro
                        bor.play(songm, 1, 1, 1, 0, 1);//carcasa timbal

                    } else {
                        sp4.play(songd, 1, 1, 1, 0, 1);//guiro
                    }
                }
                return false;
            }
        });

        //REPRODUCCION DE SONIDOS DE LOS PADS SUPERIORES

        pad5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    sp5.play(songe, 1, 1, 1, 0, 1);//galleta
                }
                return false;
            }
        });
        pad6.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    if (sw.isChecked()) {
                        sp6.play(songf, 1, 1, 1, 0, 1);//tom agudo
                        agu.play(songj, 1, 1, 1, 0, 1);//timbal agudo
                    } else {
                        sp6.play(songf, 1, 1, 1, 0, 1);//timbal grave
                    }
                }
                return false;
            }
        });
        pad7.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    if (sw.isChecked()) {
                        sp7.play(songg, 1, 1, 1, 0, 1);//tom grave
                        gra.play(songk, 1, 1, 1, 0, 1);//timbal grave
                    } else {
                        sp7.play(songg, 1, 1, 1, 0, 1);//tom grave
                    }
                }
                return false;
            }
        });
        pad8.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    sp8.play(songh, 1, 1, 1, 0, 1);//platillo
                }
                return false;
            }
        });
    }
}