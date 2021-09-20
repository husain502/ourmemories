package com.example.ourmemories.ui

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.ourmemories.R
import com.example.ourmemories.databinding.ActivityMainBinding

private const val REQUEST_CODE = 72

class MainActivity : AppCompatActivity() {



    private lateinit var binding:ActivityMainBinding
    private var imageuri: Uri? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        imageviewhome()
        startaction()

    }
    //take uri gambar
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE)
            data?.data?.let{
                imageuri = it
                binding.imageViewHome.load(imageuri){
                    crossfade(true)
                    transformations(RoundedCornersTransformation(10f))
                }
            }
    }

    //deklarasi aksi

    private fun startaction(){
        binding.buttonSelectImage.setOnClickListener{
            Intent(Intent.ACTION_GET_CONTENT).also {
                it.type = "image/*"
                startActivityForResult(it, REQUEST_CODE

                )}
        }


        binding.buttonUploadImage.setOnClickListener{
            Toast.makeText(this, "tombol upload di klik", Toast.LENGTH_SHORT).show()

        }


        binding.buttonDownloadImage.setOnClickListener(

        )

        binding.buttonDeleteImage.setOnClickListener(

        )
    }



    //set gambar
    private fun imageviewhome(){
        binding.imageViewHome.load(ContextCompat.getDrawable(this, R.drawable.itemshape)){
            crossfade(true)
            crossfade(500)
            transformations(RoundedCornersTransformation(13f))
        }
    }
}