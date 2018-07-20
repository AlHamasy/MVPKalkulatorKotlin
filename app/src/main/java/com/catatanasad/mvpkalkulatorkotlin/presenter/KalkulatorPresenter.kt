package com.catatanasad.mvpkalkulatorkotlin.presenter

import com.catatanasad.mvpkalkulatorkotlin.view.KalkulatorView

class KalkulatorPresenter (var kalkulatorView: KalkulatorView) {

    fun cekInput(input1 : String, input2 : String, operator : String){

        if (validasi(input1,input2))hitung(input1,input2, operator)
        else kalkulatorView.error("tidak boleh kosong")

    }

    private fun hitung(input1: String, input2: String, operator: String) {

        val a = input1.toDouble()
        val b = input2.toDouble()

        when (operator){
            "+" -> kalkulatorView.hasil((a+b).toString())
            "-" -> kalkulatorView.hasil((a-b).toString())
            "*" -> kalkulatorView.hasil((a*b).toString())
            "/" -> kalkulatorView.hasil((a/b).toString())
        }
    }

    private fun validasi(input1: String, input2: String): Boolean {
        return input1 != "" && input2 != ""
    }
}