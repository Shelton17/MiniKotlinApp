package com.example.tutorialapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.tutorialapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        super.onCreate(savedInstanceState)
        setContentView(view)

        val addContactDialog = AlertDialog.Builder(this)
            .setTitle("Add contact")
            .setMessage("Do you want to add Mr.Poop to your contact")
            .setIcon(R.drawable.ic_add_contact_foreground)
            .setPositiveButton("Yes"){_, _->
                Toast. makeText(this, "You added Mr. Poop to your contact list",Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No"){_, _->
                Toast. makeText(this, "You didn't add Mr. Poop to your contact list",Toast.LENGTH_SHORT).show()
            }.create()
        binding.btnDialog1.setOnClickListener {
            addContactDialog.show()
        }
        val options = arrayOf("First Item", "Second Item", "Third Item")
        val singleChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose one of the options")
            .setSingleChoiceItems(options, 0){dialogInterface, i ->
                Toast.makeText(this, "You clicked on ${options[i]}", Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton("Accept"){_,_ ->
                Toast.makeText(this, "You accepted the SingleChoiceDialog", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Decline"){_,_ ->
                Toast.makeText(this, "You declined the SingleChoiceDialog", Toast.LENGTH_SHORT).show()
            }.create()
        binding.btnDialog2.setOnClickListener {
            singleChoiceDialog.show()
        }

        val multiChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose one of the options")
            .setMultiChoiceItems(options, booleanArrayOf(false, false, false)){_, i, isChecked ->
                if (isChecked){
                    Toast.makeText(this, "You checked ${options[i]}", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "You unchecked ${options[i]}", Toast.LENGTH_SHORT).show()
                }
            }
            .setPositiveButton("Accept"){_,_ ->
                Toast.makeText(this, "You accepted the MultiChoiceDialog", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Decline"){_,_ ->
                Toast.makeText(this, "You declined the MultiChoiceDialog", Toast.LENGTH_SHORT).show()
            }.create()
        binding.btnDialog3.setOnClickListener {
            multiChoiceDialog.show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.miAddContact -> Toast.makeText(this, "You clicked on Add Contact", Toast.LENGTH_SHORT).show()
            R.id.miFeedback -> Toast.makeText(this, "You clicked Feedback", Toast.LENGTH_SHORT).show()
            R.id.miSettings -> Toast.makeText(this, "You clicked on Settings", Toast.LENGTH_SHORT).show()
            R.id.miFavorites -> Toast.makeText(this, "You clicked on Favorites", Toast.LENGTH_SHORT).show()
            R.id.miCLose -> finish()

        }
        return true
    }
}