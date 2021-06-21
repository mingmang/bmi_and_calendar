package com.example.bmi_and_calendar

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.bumptech.glide.Glide
import com.example.bmi_and_calendar.databinding.ActivityDetailBinding
import com.example.bmi_and_calendar.model.Restaurant
import com.example.bmi_and_calendar.model.Review

class DetailActivity :AppCompatActivity(){

    private lateinit var binding: ActivityDetailBinding
    private lateinit var db :AppDataBase

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = Room.databaseBuilder(
                applicationContext,
                AppDataBase::class.java,
                "ResSearchDB"
        ).build()

        val model = intent.getParcelableExtra<Restaurant>("ResModel")
        binding.nameTextview.text = model?.name.orEmpty()
        binding.descTextview.text = model?.text.orEmpty()

        Glide.with(binding.imgImgview.context)
                .load(model?.img.orEmpty())
                .into(binding.imgImgview)

        Thread{
            val review = db.reviewDao().getOnReview(model?.id?.toInt()?:0)
            runOnUiThread{
                binding.reviewEdittext.setText(review?.review.orEmpty())
            }
        }.start()

        binding.saveBtn.setOnClickListener{
            Thread{
                db.reviewDao().saveReview(
                        Review(model?.id?.toInt()?:0,
                                binding.reviewEdittext.text.toString())
                )
            }.start()
        }

        binding.phoneBtn.setOnClickListener{
            val callnum = model?.call.toString()
            val myUri = Uri.parse("tel:${callnum}")
            val myIntent = Intent(Intent.ACTION_DIAL, myUri)
            startActivity(myIntent)
        }

    }
}