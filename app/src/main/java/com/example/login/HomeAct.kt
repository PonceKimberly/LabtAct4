package com.example.login

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class HomeAct : AppCompatActivity() {

    // Chips
    private lateinit var chipAll: TextView
    private lateinit var chipUniforms: TextView
    private lateinit var chipTextbooks: TextView
    private lateinit var chipElectronics: TextView

    // Product cards
    private lateinit var cardPeShirt: LinearLayout
    private lateinit var cardCalculator: LinearLayout
    private lateinit var cardPhoneCase: LinearLayout
    private lateinit var cardHeadphone: LinearLayout
    private lateinit var cardReviewer: LinearLayout
    private lateinit var cardEngKit: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)

        // Find chips
        chipAll = findViewById(R.id.chip_all)
        chipUniforms = findViewById(R.id.chip_uniforms)
        chipTextbooks = findViewById(R.id.chip_textbooks)
        chipElectronics = findViewById(R.id.chip_electronics)

        // Find product cards
        cardPeShirt = findViewById(R.id.card_peshirt)
        cardCalculator = findViewById(R.id.card_calculator)
        cardPhoneCase = findViewById(R.id.card_phonecase)
        cardHeadphone = findViewById(R.id.card_headphone)
        cardReviewer = findViewById(R.id.card_reviewer)
        cardEngKit = findViewById(R.id.card_engkit)

        // Default: All selected
        selectChip(chipAll)
        showCategory(Category.ALL)

        chipAll.setOnClickListener {
            selectChip(chipAll)
            showCategory(Category.ALL)
            Toast.makeText(this, "Category: All", Toast.LENGTH_SHORT).show()
        }

        chipUniforms.setOnClickListener {
            selectChip(chipUniforms)
            showCategory(Category.UNIFORMS)
            Toast.makeText(this, "Category: Uniforms", Toast.LENGTH_SHORT).show()
        }

        chipTextbooks.setOnClickListener {
            selectChip(chipTextbooks)
            showCategory(Category.TEXTBOOKS)
            Toast.makeText(this, "Category: Textbooks", Toast.LENGTH_SHORT).show()
        }

        chipElectronics.setOnClickListener {
            selectChip(chipElectronics)
            showCategory(Category.ELECTRONICS)
            Toast.makeText(this, "Category: Electronics", Toast.LENGTH_SHORT).show()
        }
    }

    private enum class Category {
        ALL, UNIFORMS, TEXTBOOKS, ELECTRONICS
    }

    private fun showCategory(category: Category) {
        // Hide all first
        val allCards = listOf(
            cardPeShirt,
            cardCalculator,
            cardPhoneCase,
            cardHeadphone,
            cardReviewer,
            cardEngKit
        )
        allCards.forEach { it.visibility = View.GONE }

        when (category) {
            Category.ALL -> {
                allCards.forEach { it.visibility = View.VISIBLE }
            }
            Category.UNIFORMS -> {
                cardPeShirt.visibility = View.VISIBLE
            }
            Category.TEXTBOOKS -> {
                cardReviewer.visibility = View.VISIBLE
            }
            Category.ELECTRONICS -> {
                cardPhoneCase.visibility = View.VISIBLE
                cardHeadphone.visibility = View.VISIBLE
            }
        }
    }

    private fun selectChip(selected: TextView) {
        val chips = listOf(chipAll, chipUniforms, chipTextbooks, chipElectronics)

        val selectedBg = R.drawable.unimart_chip_selected
        val unselectedBg = R.drawable.unimart_chip_unselected
        val white = ContextCompat.getColor(this, R.color.white)
        val secondary = ContextCompat.getColor(this, R.color.text_secondary)

        chips.forEach { chip ->
            if (chip == selected) {
                chip.setBackgroundResource(selectedBg)
                chip.setTextColor(white)
            } else {
                chip.setBackgroundResource(unselectedBg)
                chip.setTextColor(secondary)
            }
        }
    }
}
