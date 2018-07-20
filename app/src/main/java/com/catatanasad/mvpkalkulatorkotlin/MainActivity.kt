package com.catatanasad.mvpkalkulatorkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.catatanasad.mvpkalkulatorkotlin.presenter.KalkulatorPresenter
import com.catatanasad.mvpkalkulatorkotlin.view.KalkulatorView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), KalkulatorView {

    //declarate implicit
    private var kalkulatorPresenter : KalkulatorPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //inisialisasi
        kalkulatorPresenter = KalkulatorPresenter(this)

        btn_tambah.setOnClickListener {
            kalkulatorPresenter!!.cekInput(edt_input1.text.toString(), edt_input2.text.toString(), "+")
        }

        btn_kurang.setOnClickListener {
            kalkulatorPresenter!!.cekInput(edt_input1.text.toString(), edt_input2.text.toString(), "-")
        }

        btn_kali.setOnClickListener {
            kalkulatorPresenter!!.cekInput(edt_input1.text.toString(), edt_input2.text.toString(), "*")
        }

        btn_bagi.setOnClickListener {
            kalkulatorPresenter!!.cekInput(edt_input1.text.toString(), edt_input2.text.toString(), "/")
        }
    }

    override fun hasil(hasil: String) {

        txt_hasil.text = hasil
    }

    override fun error(msg: String) {

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

    }
}
